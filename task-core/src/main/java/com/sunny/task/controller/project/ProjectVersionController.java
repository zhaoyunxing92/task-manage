package com.sunny.task.controller.project;

import com.sunny.task.controller.project.form.ProjectUserForm;
import com.sunny.task.core.common.result.BaseResult;
import com.sunny.task.core.common.result.ResultEnum;
import com.sunny.task.core.common.utils.ResultUtils;
import com.sunny.task.core.common.valid.InsertGroup;
import com.sunny.task.server.project.ProjectUserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunny
 * @className com.sunny.task.controller.project.ProjectUserController
 * @date 2018-01-05 13:13
 * @description:
 */
@RestController
@RequestMapping("/org/project/version")
public class ProjectVersionController {
    @Autowired
    private ProjectUserServer projectUserServer;

    /**
     * 添加团队项目版本
     *
     * @param form
     * @return
     */
    @PostMapping
    BaseResult addOrganizationProject(@RequestBody @Validated({InsertGroup.class}) ProjectUserForm form) {
        projectUserServer.addOrgnizationProjectUsers(form);
        return ResultUtils.success(ResultEnum.TASK_INSERT_PROJECT_USER_OK);
    }
}
