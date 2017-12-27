package com.sunny.task.server.main.impl;

import com.sunny.task.controller.main.form.AppUserForm;
import com.sunny.task.core.common.context.TaskAppUser;
import com.sunny.task.core.common.exception.TaskException;
import com.sunny.task.core.common.field.BaseFields;
import com.sunny.task.core.common.result.ResultEnum;
import com.sunny.task.core.common.utils.CookiesUtils;
import com.sunny.task.core.common.utils.StringUtils;
import com.sunny.task.core.common.utils.TokenUtils;
import com.sunny.task.core.common.utils.UUIDUtills;
import com.sunny.task.model.systemUser.vo.AppUserVo;
import com.sunny.task.server.main.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * @author sunny
 * @className com.sunny.task.server.main.impl.SystemUserServierImpl
 * @date 2017-12-25 16:40
 * @description:
 */
@Service
public class SystemUserServierImpl implements SystemUserServer {
    @Autowired
    private AppUserByAccountServer appUserByAccountServer;
    @Autowired
    private AppUserByEmailServer appUserByEmailServer;
    @Autowired
    private AppUserByMobileServer appUserByMobileServer;
    @Autowired
    private AppUserServer appUserServer;

    @Override
    public TaskAppUser login(HttpServletRequest req, HttpServletResponse res, AppUserForm form) {

        String uId = getAppUserUIdByAccount(form.getAccount());

        if (StringUtils.isBlank(uId)) {
            throw new TaskException(ResultEnum.SYSTEM_ACCOUNT_NOT_EXIST);
        }

        AppUserVo appUserVo = appUserServer.findAppUserByUId(uId);
        if (appUserVo == null) {
            throw new TaskException(ResultEnum.SYSTEM_ACCOUNT_NOT_EXIST);
        }
        //校验人员状态
        checkAppUserStatus(appUserVo.getStatus());

        //校验密码
        String password = form.getPassword();
        if (!password.equals(appUserVo.getPassword1())) {
            throw new TaskException(ResultEnum.APP_USER_PASSWORD_ERROR);
        }
        TaskAppUser taskAppUser = new TaskAppUser();
        BeanUtils.copyProperties(appUserVo, taskAppUser);
        taskAppUser.setuId(uId);
        setToken(res, uId, appUserVo.getNickName());
        return taskAppUser;
    }

    private void checkAppUserStatus(Integer status) {
        switch (status) {
            //注销
            case 0:
                throw new TaskException(ResultEnum.SYSTEM_ACCOUNT_LOGOUT_STATUS);
            case 1:
                break;
            case 9:
                throw new TaskException(ResultEnum.SYSTEM_ACCOUNT_NOT_ACTIVE_STATUS);
                //锁定
            case 10:
                throw new TaskException(ResultEnum.SYSTEM_ACCOUNT_LOCK_STATUS);
        }
    }

    @Override
    public TaskAppUser registerAppUser(HttpServletRequest req, HttpServletResponse res, AppUserForm form) {
        /*用户名校验*/
        String account = form.getAccount();
        if (!StringUtils.isBlank(getAppUserUIdByAccount(account))) {
            throw new TaskException(ResultEnum.SYSTEM_ACCOUNT_EXIST);
        }
        /*邮箱校验*/
        if (!StringUtils.isBlank(getAppUserUIdByAccount(form.getEmail()))) {
            throw new TaskException(ResultEnum.SYSTEM_EMAIL_EXIST);
        }
        String uId = UUIDUtills.getUUID(SystemUserServer.SYSTEM_USER_ID_PREFIX);
        form.setuId(uId);
        appUserServer.saveAppUser(form);
        //返回前端数据
        TaskAppUser taskAppUser = new TaskAppUser();
        taskAppUser.setuId(uId);
        taskAppUser.setNickName(account);
        setToken(res, uId, account);
        return taskAppUser;
    }

    private void setToken(HttpServletResponse res, String uId, String nackName) {
        HashMap<String, Object> map = new HashMap();
        map.put(SystemUserServer.SYSTEM_USER_ID_TOKEN_KEY, uId);
        map.put(SystemUserServer.SYSTEM_USER_NACK_NAME_TOKEN_KEY, nackName);
        CookiesUtils.setCookie(res, BaseFields.APP_USER_COOKIE_KEY, TokenUtils.generateToken(map));
    }

    private String getAppUserUIdByAccount(String account) {
        String uId;
        if (StringUtils.isMobile(account)) {
            uId = appUserByMobileServer.findAppUserUidByMobile(account);
        } else if (StringUtils.isEmail(account)) {
            uId = appUserByEmailServer.findAppUserUidByEmail(account);
        } else {
            uId = appUserByAccountServer.findAppUserUidByAccount(account);
        }
        return uId;
    }
}
