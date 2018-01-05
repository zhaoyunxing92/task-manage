package com.sunny.task.server.project;

import com.sunny.task.controller.project.form.ProjectVsersionForm;
import com.sunny.task.model.project.vo.ProjectVersionVo;

import java.util.List;

/**
 * @author sunny
 * @className com.sunny.task.server.project.ProjectVersionServer
 * @date 2018-01-05 14:33
 * @description:
 */
public interface ProjectVersionServer {
    String ORG_PROJECT_VERSION_UID_PREFIX = "org_p_v";

    String ORG_PROJECT_VERSION_DEFAULT_NAME = "默认版本";

    /**
     * 创建项目版本
     *
     * @param form
     * @return
     */
    String addProjectVersion(ProjectVsersionForm form);


    /**
     * 创建项目有添加默认版本
     *
     * @param proId
     * @return
     */
    void addProjectVersionAuto(String proId);

    /**
     * 获取项目版本列表
     *
     * @param proId
     * @return
     */
    List<ProjectVersionVo> getOrganizationProjectVersions(String proId);
}
