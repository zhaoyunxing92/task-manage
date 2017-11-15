package com.sunny.task.controller.user;


import com.sunny.task.service.msg.TaskEmailService;
import com.sunny.task.result.BaseResult;
import com.sunny.task.result.ResultEnum;
import com.sunny.task.form.user.AppUserForm;
import com.sunny.task.service.user.AppUserService;
import com.sunny.task.utils.ResultUtils;
import com.sunny.task.valid.LoginGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sunny
 * @className com.sunny.task.controller.user.AppUserController
 * @date 2017-10-16 10:11
 * @description:
 */
@RestController
@RequestMapping("/auth")
public class AppUserController {
    @Autowired
    private AppUserService appUserService;
    @Autowired
    private TaskEmailService taskEmailService;
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
//     @GetMapping("/mail")
//    void sendemail() throws MessagingException, IOException, TemplateException {
//         Map<String, Object> map = new HashMap<>();
//         map.put("account", "112122");
//         String token = TokenUtils.generateToken(map);
//         map.put("activeUrl", BaseFields.task_email_host + "auth/active?token=" + token);
//         taskEmailService.sendActiveAccountEmail(new String[]{"ZhaoYunxing@ifugle.com"},map);
//    }

}
