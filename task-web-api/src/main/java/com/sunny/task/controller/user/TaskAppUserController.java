package com.sunny.task.controller.user;


import com.sunny.task.result.BaseResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunny
 * @className com.sunny.task.controller.user.TaskAppUserController
 * @date 2017-10-26 20:12
 * @description: //profile
 */
@RestController
@RequestMapping("/profile")
public class TaskAppUserController {

    @PostMapping("/info")
    BaseResult getAppUserInfo() {
        return null;
//        return ResultUtils.success(ResultEnum.LOGIN_SUCCESS, appUserService.login(req, res, org));
    }
}
