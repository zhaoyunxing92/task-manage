package com.sunny.task.controller.project;

import com.sunny.task.form.pro.ProUserForm;
import com.sunny.task.result.BaseResult;
import com.sunny.task.result.ResultEnum;
import com.sunny.task.service.project.ProjectUserService;
import com.sunny.task.utils.ResultUtils;
import com.sunny.task.valid.InsertGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunny
 * @className com.sunny.task.controller.project.ProjectUserController
 * @date 2017-11-16 13:39
 * @description:
 */
@RestController
@RequestMapping("/pro/user")
public class ProjectUserController {
    @Autowired
    private ProjectUserService projectUserService;

    /**
     * 添加项目成员
     *
     * @param form
     * @return
     */
    @PostMapping("/add")
    BaseResult addProjectUser(@RequestBody @Validated({InsertGroup.class}) ProUserForm form) {
        projectUserService.addProjectUser(form.getProId(),false,form.getUsers());
        return ResultUtils.success(ResultEnum.SUCCESS);
    }
}
