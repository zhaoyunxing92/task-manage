package com.sunny.task.user.controller;

import com.sunny.task.common.base.BaseResult;
import com.sunny.task.common.base.ResultEnum;
import com.sunny.task.common.utils.ResultUtils;
import com.sunny.task.common.valid.LoginGroup;
import com.sunny.task.user.form.AppUserForm;
import com.sunny.task.user.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sunny
 * @className com.sunny.task.user.controller.AppUserController
 * @date 2017-10-16 10:11
 * @description:
 */
@RestController
@RequestMapping("/auth")
public class AppUserController {
    @Autowired
    private AppUserService appUserService;

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
        return ResultUtils.success(ResultEnum.LOGIN_SUCCESS, appUserService.login(req, res, form));
    }

    /**
     * @param res
     * @param token
     */
    @GetMapping("/active")
    void activeAccountByTaskToken(HttpServletResponse res, @RequestParam("token") String token) {
        appUserService.activeAccountByTaskToken(res, token);
    }

}
