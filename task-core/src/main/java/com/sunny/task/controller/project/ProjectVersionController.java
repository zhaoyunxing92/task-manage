package com.sunny.task.controller.project;

import com.sunny.task.controller.project.form.ProjectVsersionForm;
import com.sunny.task.core.common.result.BaseResult;
import com.sunny.task.core.common.result.ResultEnum;
import com.sunny.task.core.common.utils.ResultUtils;
import com.sunny.task.core.common.valid.InsertGroup;
import com.sunny.task.server.project.ProjectVersionServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    private ProjectVersionServer projectVersionServer;

    /**
     * 添加团队项目版本
     *
     * @param form
     * @return
     */
    @PostMapping
    BaseResult addOrganizationProjectVersion(@RequestBody @Validated({InsertGroup.class}) ProjectVsersionForm form) {
        return ResultUtils.success(ResultEnum.TASK_INSERT_PROJECT_VERSION_OK, projectVersionServer.addProjectVersion(form));
    }

    /**
     * 获取项目的版本列表
     *
     * @param proId
     * @return
     */
    @GetMapping("/list")
    BaseResult getOrganizationProjectVersions(@RequestParam("proId") String proId) {
        return ResultUtils.success(ResultEnum.TASK_SELECT_PROJECT_VERSION_OK, projectVersionServer.getOrganizationProjectVersions(proId));
    }
}
