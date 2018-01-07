package com.sunny.task.server.project;

import com.sunny.task.controller.project.form.ProjectForm;
import com.sunny.task.model.project.vo.ProjectVo;

import java.util.List;

/**
 * @author sunny
 * @className com.sunny.task.server.project.ProjectServer
 * @date 2017-12-28 13:09
 * @description:
 */
public interface ProjectServer {
    String ORG_PROJECT_UID_PREFIX = "org_p";

    /**
     * 添加团队项目
     *
     * @param form
     * @return
     */
    String addOrganizationProject(ProjectForm form);

    /**
     * 根据组织id和项目id获取项目详情
     *
     * @param proId
     * @return
     */
    ProjectVo findOrganizationProjectByProIdAndOrgId(String proId);

    /**
     * 获取团队项目
     *
     * @param orgId
     * @return
     */
    List<ProjectVo> getOrganizationsProjectsByOrgId(String orgId);
}
