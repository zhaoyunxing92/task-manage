package com.sunny.task.controller.project;

import com.sunny.task.form.pro.ProForm;
import com.sunny.task.service.project.ProjectService;
import com.sunny.task.result.BaseResult;
import com.sunny.task.result.ResultEnum;
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
 * @className com.sunny.task.controller.project.ProjectController
 * @date 2017-11-14 14:18
 * @description: 项目模块
 */
@RestController
@RequestMapping("/pro")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    /**
     * 创建团队
     *
     * @param form
     * @return
     */
    @PostMapping("/add")
    BaseResult addOrganization(@RequestBody @Validated({InsertGroup.class}) ProForm form) {
        return ResultUtils.success(ResultEnum.SUCCESS, projectService.addProject(form));
    }
   // 修改项目

}
