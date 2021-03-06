package com.sunny.task.controller.project;

import com.sunny.task.controller.project.form.ProjectForm;
import com.sunny.task.core.common.result.BaseResult;
import com.sunny.task.core.common.result.ResultEnum;
import com.sunny.task.core.common.utils.ResultUtils;
import com.sunny.task.core.common.valid.InsertGroup;
import com.sunny.task.server.project.ProjectServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author sunny
 * @className com.sunny.task.controller.project.ProjectController
 * @date 2017-12-28 13:05
 * @description: 团队项目
 */
@RestController
@RequestMapping("/org/project")
public class ProjectController {
    @Autowired
    private ProjectServer projectServer;

    /**
     * 添加团队项目
     *
     * @param form
     * @return
     */
    @PostMapping
    BaseResult addOrganizationProject(@RequestBody @Validated({InsertGroup.class}) ProjectForm form) {

        return ResultUtils.success(ResultEnum.TASK_INSERT_PROJECT_OK, projectServer.addOrganizationProject(form));
    }

    /**
     * 获取组织项目
     *
     * @param orgId 组织id
     * @return
     */
    @GetMapping
    BaseResult getOrganizationsProjects(@RequestParam("orgId") String orgId) {

        return ResultUtils.success(ResultEnum.TASK_SELECT_ORG_PROJECT_OK, projectServer.getOrganizationsProjectsByOrgId(orgId));
    }
}
