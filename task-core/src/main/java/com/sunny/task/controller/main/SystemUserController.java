package com.sunny.task.controller.main;

import com.sunny.task.controller.main.form.AppUserForm;
import com.sunny.task.core.common.result.BaseResult;
import com.sunny.task.core.common.result.ResultEnum;
import com.sunny.task.core.common.utils.ResultUtils;
import com.sunny.task.core.common.valid.InsertGroup;
import com.sunny.task.core.common.valid.LoginGroup;
import com.sunny.task.server.main.SystemUserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sunny
 * @className com.sunny.task.controller.main.SystemUserController
 * @date 2017-12-25 16:33
 * @description: 系统成员控制器
 */
@RestController
@RequestMapping("/auth")
public class SystemUserController {
    @Autowired
    private SystemUserServer systemUserServer;

    /**
     * 登录
     *
     * @param req
     * @param res
     * @param form
     * @return
     */
    @PostMapping("/login")
    BaseResult login(HttpServletRequest req, HttpServletResponse res, @RequestBody @Validated({LoginGroup.class}) AppUserForm form) {

        return ResultUtils.success(ResultEnum.LOGIN_SUCCESS, systemUserServer.login(req, res, form));
    }

    /**
     * 注册
     *
     * @param req
     * @param res
     * @param form
     * @return
     */
    @PostMapping("/register")
    BaseResult registerAppUser(HttpServletRequest req, HttpServletResponse res, @RequestBody @Validated({InsertGroup.class}) AppUserForm form) {

        return ResultUtils.success(ResultEnum.ADD_APP_USER_SUCCESS, systemUserServer.registerAppUser(req, res, form));
    }

}
