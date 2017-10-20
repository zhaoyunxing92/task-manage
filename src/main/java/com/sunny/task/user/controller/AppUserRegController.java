package com.sunny.task.user.controller;

import com.sunny.task.common.base.BaseResult;
import com.sunny.task.common.base.ResultEnum;
import com.sunny.task.common.utils.ResultUtils;
import com.sunny.task.common.valid.InsertGroup;
import com.sunny.task.core.service.TaskEmailService;
import com.sunny.task.user.form.AppUserForm;
import com.sunny.task.user.service.AppUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sunny
 * @className com.sunny.task.user.controller.TaksRegController
 * @date 2017-10-16 13:46
 * @description: 注册用户
 */
@RestController
@RequestMapping("/reg")
public class AppUserRegController {
    final static Logger log = LoggerFactory.getLogger(AppUserRegController.class);
    @Autowired
    private AppUserService appUserService;
    @Autowired
    private TaskEmailService taskEmailService;

    /**
     * 注册用户
     *
     * @param request
     * @param form
     * @return
     */
    @PostMapping("/user")
    public BaseResult addAppUser(HttpServletRequest request, @RequestBody @Validated({InsertGroup.class}) AppUserForm form) {
        appUserService.addAppUser(request, form);
        return ResultUtils.success(ResultEnum.ADD_APP_USER_SUCCESS);
    }

    /**
     * 判断用户是否存在
     *
     * @param account
     * @return
     */
    @GetMapping("/check/{account:.+}")
    public BaseResult checkAccountIsExist(@PathVariable("account") String account) {
        return appUserService.checkAccountIsExist(account);
    }
    
}
