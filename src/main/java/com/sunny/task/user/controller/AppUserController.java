package com.sunny.task.user.controller;

import com.sunny.task.user.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunny
 * @className com.sunny.task.user.controller.AppUserController
 * @date 2017-10-16 10:11
 * @description:
 */
//@Api(value = "AppUserController", description = "用户相关接口")
@RestController
@RequestMapping("/user")
public class AppUserController {
    @Autowired
    private AppUserService appUserService;
  
}
