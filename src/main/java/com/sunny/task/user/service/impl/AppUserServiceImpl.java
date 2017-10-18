package com.sunny.task.user.service.impl;

import com.sunny.task.common.base.*;
import com.sunny.task.common.utils.*;
import com.sunny.task.core.exception.TaskException;
import com.sunny.task.core.exception.TaskUserAuthException;
import com.sunny.task.user.form.AppUserForm;
import com.sunny.task.user.mapper.AppUserExtendMapper;
import com.sunny.task.user.mapper.AppUserMapper;
import com.sunny.task.user.model.AppUser;
import com.sunny.task.user.model.AppUserExtend;
import com.sunny.task.user.model.vo.AppUserVo;
import com.sunny.task.user.service.AppUserByAccountService;
import com.sunny.task.user.service.AppUserByEmailService;
import com.sunny.task.user.service.AppUserByMobileService;
import com.sunny.task.user.service.AppUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @Transactional(rollbackFor = Exception.class)
    public void addAppUser(HttpServletRequest request, AppUserForm form) {
        String email;
        Long userId;
        try {
            email = form.getEmail(); //邮箱
            String pwd = form.getPassword(); //密码
            String password = NullUtils.isNotNull(pwd) ? pwd : BaseFields.DEFAULT_PASSWORD;

            AppUser appUser = new AppUser();
            BeanUtils.copyProperties(form, appUser);
            appUser.setUniqueId(UUIDUtills.getPrefixUUID(BaseFields.app_user_prefix_unq_id));
            appUser.setPassword1(password);
            appUser.setPassword2(password);
            appUser.setStatus(AppUserStatus.NOT_ACTIVATE_STATUS); //默认未激活用户
            appUserMapper.insertSelective(appUser);

            userId = appUser.getId();

        } catch (TaskException e) {
            throw new TaskException(ResultEnum.ADD_APP_USER_ERROR, e);
        }
        //添加用户扩展数据
        addAppUserExtend(userId);
        String account = form.getAccount();
        //添加账号搜索
        if (NullUtils.isNotNull(account)) {
            appUserByAccountService.addAppUserByAccount(account, userId);
        }
        //添加邮箱搜索
        if (NullUtils.isNotNull(email)) {
            appUserByEmailService.addAppUserByEmail(email, userId);
        }
        //添加手机号搜索
        String mobile = form.getMobile();

        if (NullUtils.isNotNull(mobile)) {
            appUserByMobileService.addAppUserByMobile(mobile, userId);
        }
    }

    /**
     * 添加用户扩展表
     */
    private void addAppUserExtend(Long userId) {
        try {
            AppUserExtend appUserExtend = new AppUserExtend();
            appUserExtend.setUserId(userId);
            appUserExtend.setCreator(userId);
            appUserExtend.setModifier(userId);
            appUserExtendMapper.insertSelective(appUserExtend);
        } catch (TaskException e) {
            throw new TaskException(ResultEnum.ADD_APP_USER_EXTEND_ERROR, e);
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
        //密码错误
        if (!pwd.equals(appUserVo.getPassword1())) {
            throw new TaskUserAuthException(ResultEnum.APP_USER_PASSWORD_ERROR);
        }

        BeanUtils.copyProperties(appUserVo, taskManageUser);
        taskManageUser.setUid(appUserVo.getUniqueId());//设置唯一id
        //设置token
        generateToken(res, taskManageUser);
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
        // res.setHeader(BaseFields.app_cookie_key,token);
        CookiesUtils.setCookie(res, BaseFields.app_user_cookie_key, token);
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

        Integer status = appUserVo.getStatus();

        if (AppUserStatus.ACCOUNT_LOCK_STATUS.equals(status)) { //账号锁定
            throw new TaskUserAuthException(ResultEnum.APP_USER_LOCK_ERROR);
        } else if (AppUserStatus.NOT_ACTIVATE_STATUS.equals(status)) {  //账号未激活
            throw new TaskUserAuthException(ResultEnum.APP_USER_NOT_ACTIVATE_ERROR);
        }


        return appUserVo;
    }
}
