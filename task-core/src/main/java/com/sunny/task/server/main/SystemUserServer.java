package com.sunny.task.server.main;

import com.sunny.task.controller.main.form.AppUserForm;
import com.sunny.task.core.common.context.TaskAppUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sunny
 * @className com.sunny.task.server.main.SystemUserServer
 * @date 2017-12-25 16:40
 * @description:
 */
public interface SystemUserServer {
    /**
     * 登录
     *
     * @param req
     * @param res
     * @param form
     * @return
     */
    TaskAppUser login(HttpServletRequest req, HttpServletResponse res, AppUserForm form);

    /**
     * 注册用户
     *
     * @param req
     * @param res
     * @param form
     * @return
     */
    TaskAppUser registerAppUser(HttpServletRequest req, HttpServletResponse res, AppUserForm form);
}
