package com.sunny.task.user.service.impl;

import com.google.gson.JsonObject;
import com.sunny.task.contaxt.TaskManageUser;
import com.sunny.task.exception.TaskException;
import com.sunny.task.exception.TaskUserAuthException;
import com.sunny.task.field.BaseFields;
import com.sunny.task.msg.service.TaskEmailService;
import com.sunny.task.result.BaseResult;
import com.sunny.task.result.ResultEnum;
import com.sunny.task.status.AppUserStatus;
import com.sunny.task.unique.service.PrimaryKeyByUniqueIdService;
import com.sunny.task.form.form.AppUserForm;
import com.sunny.task.user.mapper.AppUserExtendMapper;
import com.sunny.task.user.mapper.AppUserMapper;
import com.sunny.task.user.model.AppUser;
import com.sunny.task.user.model.AppUserExtend;
import com.sunny.task.user.model.vo.AppUserVo;
import com.sunny.task.user.service.AppUserByAccountService;
import com.sunny.task.user.service.AppUserByEmailService;
import com.sunny.task.user.service.AppUserByMobileService;
import com.sunny.task.user.service.AppUserService;
import com.sunny.task.utils.*;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sunny
 * @className com.sunny.task.user.service.impl.AppUserServiceImpl
 * @date 2017-10-16 09:55
 * @description:
 */
@Service
public class AppUserServiceImpl implements AppUserService {
    final static Logger log = LoggerFactory.getLogger(AppUserServiceImpl.class);
    @Autowired
    private AppUserMapper appUserMapper;
    @Autowired
    private AppUserExtendMapper appUserExtendMapper;
    @Autowired
    private AppUserByAccountService appUserByAccountService;
    @Autowired
    private AppUserByEmailService appUserByEmailService;
    @Autowired
    private AppUserByMobileService appUserByMobileService;
    @Autowired
    private TaskEmailService taskEmailService;
    @Autowired
    private PrimaryKeyByUniqueIdService primaryKeyByUniqueIdService;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addAppUser(HttpServletRequest request, AppUserForm form) {
        String email;
        Long userId;
        String uId;
        try {
            email = form.getEmail(); //邮箱
            uId = UUIDUtills.getPrefixUUID(BaseFields.APP_USER_PREFIX_UNQ_ID);
            String pwd = form.getPassword(); //密码
            String password = NullUtils.isNotNull(pwd) ? pwd : BaseFields.DEFAULT_PASSWORD;

            AppUser appUser = new AppUser();
            BeanUtils.copyProperties(form, appUser);
            appUser.setUniqueId(uId);
            appUser.setPassword1(password);
            appUser.setPassword2(password);
            appUser.setStatus(AppUserStatus.NOT_ACTIVATE_STATUS); //默认未激活用户
            appUserMapper.insertSelective(appUser);
            userId = appUser.getId();
        } catch (TaskException e) {
            throw new TaskException(ResultEnum.ADD_APP_USER_ERROR, e);
        }
        //添加用户扩展数据
        addAppUserExtend(uId, userId);
        String account = form.getAccount();
        //添加账号搜索
        if (NullUtils.isNotNull(account)) {
            appUserByAccountService.addAppUserByAccount(account, userId);
        }
        //添加邮箱搜索
        if (NullUtils.isNotNull(email)) {

            appUserByEmailService.addAppUserByEmail(email, userId);

            // sendActiveToken(email, userId);
        }
        //添加手机号搜索
        String mobile = form.getMobile();

        if (NullUtils.isNotNull(mobile)) {
            appUserByMobileService.addAppUserByMobile(mobile, userId);
        }
        /**添加unq搜索*/
        primaryKeyByUniqueIdService.addPrimaryKeyByUniqueId(uId, userId, BaseFields.APP_USER_TYPE);
    }

    /**
     * 添加用户扩展表
     */
    private void addAppUserExtend(String uId, Long userId) {
        try {
            AppUserExtend appUserExtend = new AppUserExtend();
            appUserExtend.setUserId(uId);
            appUserExtend.setCreationDate(new Date());
            appUserExtend.setCreator(userId);
            appUserExtend.setModifier(userId);
            appUserExtendMapper.insertSelective(appUserExtend);
        } catch (TaskException e) {
            throw new TaskException(ResultEnum.ADD_APP_USER_EXTEND_ERROR, e);
        }
    }

    /**
     * 发送激活邮件
     *
     * @param email
     * @param userId
     */
    private void sendActiveToken(String email, Long userId) {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("account", userId);
            String token = TokenUtils.generateToken(map);
            map.put("activeUrl", BaseFields.task_email_host + "auth/active?token=" + token);

            taskEmailService.sendActiveAccountEmail(new String[]{email}, map);
        } catch (MessagingException e) {
            log.error("发送激活邮件异常:email--{},id--{},{}", email, userId, e);
        } catch (IOException e) {
            log.error("io异常:{}", e);
        } catch (TemplateException e) {
            log.error("模板异常:{}", e);
        } catch (Exception e) {
            log.error("发送邮件异常{},{}", email, e);
        }
    }

    /**
     * 检测账号是否存在
     *
     * @param account
     * @return
     */
    @Override
    public BaseResult checkAccountIsExist(String account) {
        Object object;

        if (StringUtils.isEmail(account)) { //邮箱
            object = appUserByEmailService.findAppUserByEmail(account);
        } else if (StringUtils.isMobile(account)) {  //手机号
            object = appUserByMobileService.findAppUserByMobile(account);
        } else {  //账号
            object = appUserByAccountService.findAppUserByAccount(account);
        }

        if (NullUtils.isNull(object)) {
            return ResultUtils.success(ResultEnum.REG_APP_USER_ACCOUNT_NOT_EXIST);
        } else {
            return ResultUtils.success(ResultEnum.REG_APP_USER_ACCOUNT_EXIST);
        }
    }

    @Override
    public TaskManageUser login(HttpServletRequest req, HttpServletResponse res, AppUserForm form) {
        String account = form.getAccount();
        Long userId;
        if (StringUtils.isEmail(account)) { //邮箱
            userId = appUserByEmailService.findAppUserIdByEmail(account);
        } else if (StringUtils.isMobile(account)) {  //手机号
            userId = appUserByMobileService.findAppUserIdByMobile(account);
        } else {  //账号
            userId = appUserByAccountService.findAppUserIdByAccount(account);
        }
        //账号不存在
        if (NullUtils.isNull(userId)) {
            throw new TaskException(ResultEnum.LOGIN_APP_USLOGINER_ACCOUNT_NOT_EXIST);
        }
        //密码
        String pwd = form.getPassword();
        TaskManageUser taskManageUser = new TaskManageUser();

        AppUserVo appUserVo = findAppUserVoByUserId(userId);
        Integer status = appUserVo.getStatus();
        if (AppUserStatus.ACCOUNT_LOCK_STATUS.equals(status)) { //账号锁定
            throw new TaskUserAuthException(ResultEnum.APP_USER_LOCK_ERROR);
        } else if (AppUserStatus.NOT_ACTIVATE_STATUS.equals(status)) {  //账号未激活
            throw new TaskUserAuthException(ResultEnum.APP_USER_NOT_ACTIVATE_ERROR);
        }
        //密码错误
        if (!pwd.equals(appUserVo.getPassword1())) {
            throw new TaskUserAuthException(ResultEnum.APP_USER_PASSWORD_ERROR);
        }
        BeanUtils.copyProperties(appUserVo, taskManageUser);
        taskManageUser.setUid(appUserVo.getUniqueId());//设置唯一id
        //设置token
        generateToken(res, taskManageUser);
        taskManageUser.setId(null);
        return taskManageUser;
    }

    /**
     * 设置token 保存到cookie里面
     *
     * @param taskManageUser
     */
    private void generateToken(HttpServletResponse res, TaskManageUser taskManageUser) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("uid", taskManageUser.getUid());
        claims.put("id", taskManageUser.getId());
        String token = TokenUtils.generateToken(claims);
       // taskManageUser.setToken(token);

       // res.setHeader(BaseFields.APP_USER_COOKIE_KEY, token);
        CookiesUtils.setCookie(res, BaseFields.APP_USER_COOKIE_KEY, token);
    }

    /**
     * 根据用户id获取用户
     *
     * @param userId
     * @return
     */
    private AppUserVo findAppUserVoByUserId(Long userId) {
        AppUserVo appUserVo;
        try {
            appUserVo = appUserMapper.selectTaskManageUserByUserIdAndPassword(userId);
        } catch (TaskException e) {
            throw new TaskException(ResultEnum.SELECT_APP_USER_BY_USERID_REEOR, e);
        }
        //账号不存在
        if (NullUtils.isNull(appUserVo)) {
            throw new TaskException(ResultEnum.LOGIN_APP_USLOGINER_ACCOUNT_NOT_EXIST);
        }

        return appUserVo;
    }

    @Override
    public void activeAccountByTaskToken(HttpServletResponse res, String token) {
        //appUserMapper.updateByPrimaryKey();
        JsonObject parseToken = TokenUtils.parseToken(token);
        if (NullUtils.isNotNull(parseToken.get("error_type"))) {
            log.error("io异常:{}", parseToken.get("error_type"));
        } else {
            //用户id
            Long id = parseToken.get("account").getAsLong();
            AppUserVo appUserVo = findAppUserVoByUserId(id);
            Integer status = appUserVo.getStatus();
            if (AppUserStatus.NOT_ACTIVATE_STATUS.equals(status)) {  //账号未激活
                AppUser appUser = new AppUser();
                appUser.setId(id);
                appUser.setModifier(id);
                appUser.setStatus(AppUserStatus.NORMALITY_STATUS);
                appUserMapper.updateByPrimaryKeySelective(appUser);
            }
        }
    }
}
