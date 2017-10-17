package com.sunny.task.user.controller;

import com.sunny.task.common.base.BaseResult;
import com.sunny.task.common.base.ResultEnum;
import com.sunny.task.common.utils.ResultUtils;
import com.sunny.task.common.valid.LoginGroup;
import com.sunny.task.user.form.AppUserForm;
import com.sunny.task.user.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
     * @param request
     * @param form
     * @return
     */
    @PostMapping("/login")
    BaseResult login(HttpServletRequest request, @RequestBody @Validated({LoginGroup.class}) AppUserForm form) {
        return ResultUtils.success(ResultEnum.LOGIN_SUCCESS,appUserService.login(form));
    }
}
