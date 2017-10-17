package com.sunny.task.user.service;

import com.sunny.task.common.base.BaseResult;
import com.sunny.task.common.base.TaskManageUser;
import com.sunny.task.user.form.AppUserForm;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sunny
 * @className com.sunny.task.user.service.AppUserService
 * @date 2017-10-16 09:55
 * @description:
 */
public interface AppUserService {
    /**
     * 添加app_user
     *
     * @param request
     * @param form
     */
    void addAppUser(HttpServletRequest request, AppUserForm form);

    /**
     * 判断账号是否存在
     *
     * @param account
     * @return
     */
    BaseResult checkAccountIsExist(String account);

    /**
     * 登录
     *
     * @param form
     * @return
     */
    TaskManageUser login(AppUserForm form);
}