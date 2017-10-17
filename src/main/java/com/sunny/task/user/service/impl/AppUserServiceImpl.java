package com.sunny.task.user.service.impl;

import com.sunny.task.common.base.BaseFields;
import com.sunny.task.common.base.ResultEnum;
import com.sunny.task.common.utils.NullUtil;
import com.sunny.task.common.utils.UUIDUtills;
import com.sunny.task.core.exception.TaskException;
import com.sunny.task.user.form.AppUserForm;
import com.sunny.task.user.mapper.AppUserExtendMapper;
import com.sunny.task.user.mapper.AppUserMapper;
import com.sunny.task.user.model.AppUser;
import com.sunny.task.user.model.AppUserExtend;
import com.sunny.task.user.service.AppUserByAccountService;
import com.sunny.task.user.service.AppUserByEmailService;
import com.sunny.task.user.service.AppUserByMobileService;
import com.sunny.task.user.service.AppUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

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
            String password = NullUtil.isNotNull(pwd) ? pwd : BaseFields.DEFAULT_PASSWORD;

            AppUser appUser = new AppUser();
            BeanUtils.copyProperties(form, appUser);
            appUser.setUniqueId(UUIDUtills.getPrefixUUID("task"));
            appUser.setPassword1(password);
            appUser.setPassword2(password);
            appUser.setStatus(NullUtil.isNotNull(pwd) ? 1 : 9); //没有密码就是未激活用户
            appUserMapper.insertSelective(appUser);
            //添加用户扩展数据
             userId = appUser.getId();
            addAppUserExtend(userId);
        } catch (TaskException e) {
            throw new TaskException(ResultEnum.ADD_APP_USER_ERROR, e);
        }
        String account = form.getAccount();
        //添加账号搜索
        if (NullUtil.isNotNull(account)) {
            appUserByAccountService.addAppUserByAccount(account, userId);
        }
        //添加邮箱搜索
        if (NullUtil.isNotNull(email)) {
            appUserByEmailService.addAppUserByEmail(email, userId);
        }
        //添加手机号搜索
        String mobile = form.getMobile();

        if (NullUtil.isNotNull(mobile)) {
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
}
