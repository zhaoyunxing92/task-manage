package com.sunny.task.controller.project;

import com.sunny.task.form.pro.ProUserForm;
import com.sunny.task.result.BaseResult;
import com.sunny.task.result.ResultEnum;
import com.sunny.task.service.project.ProjectUserService;
import com.sunny.task.utils.ResultUtils;
import com.sunny.task.valid.DeleteGroup;
import com.sunny.task.valid.InsertGroup;
import com.sunny.task.valid.UpdateGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
     * 获取项目成员
     *
     * @param proId
     * @return
     */
    @GetMapping
    BaseResult getProjectUser(@RequestParam("proId") String proId) {
        return null;
    }

    /**
     * 添加项目成员
     *
     * @param form
     * @return
     */
    @PostMapping("/add")
    BaseResult addProjectUser(@RequestBody @Validated({InsertGroup.class}) ProUserForm form) {
        projectUserService.addProjectUser(form.getProId(), false, form.getUserIds());
        return ResultUtils.success(ResultEnum.SUCCESS);
    }

    /**
     * 批量删除用户
     *
     * @param form
     * @return
     */
    @DeleteMapping("/remove")
    BaseResult removeProjectUserByProId(@RequestBody @Validated({DeleteGroup.class}) ProUserForm form) {
        projectUserService.removeProjectUserByProId(form.getProId(), form.getUserIds());
        return ResultUtils.success(ResultEnum.SUCCESS);
    }

    /**
     * 修改用户信息
     *
     * @param form
     * @return
     */
    @PutMapping("/revise")
    BaseResult reviseProjectUserByProId(@RequestBody @Validated({UpdateGroup.class}) ProUserForm form) {
        projectUserService.reviseProjectUserByProId(form);
        return ResultUtils.success(ResultEnum.SUCCESS);
    }
}
