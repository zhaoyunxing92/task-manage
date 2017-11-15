package com.sunny.task.service.user;


import com.sunny.task.contaxt.TaskManageUser;
import com.sunny.task.result.BaseResult;
import com.sunny.task.form.user.AppUserForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
     *
     * @param req
     * @param res
     *@param form  @return
     */
    TaskManageUser login(HttpServletRequest req, HttpServletResponse res, AppUserForm form);

    /**
     * 根据token激活用户
     * @param token
     */
    void activeAccountByTaskToken(HttpServletResponse res, String token);
}
