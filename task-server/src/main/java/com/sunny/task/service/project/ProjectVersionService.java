package com.sunny.task.service.project;

import com.sunny.task.form.pro.ProVsersionForm;
import com.sunny.task.model.project.ProjectVersion;

import java.util.List;

/**
 * @author sunny
 * @className com.sunny.task.service.project.ProjectVersionService
 * @date 2017-11-17 10:43
 * @description:
 */
public interface ProjectVersionService {
    String pro_version_prefix = "v_";
    String pro_version_default_name = "默认版本";

    /**
     * 添加项目版本
     *
     * @param form
     */
    String addProjectVersion(ProVsersionForm form);

    /**
     * 添加默认版本
     *
     * @param proId
     */
    void addProjectDefaultVersion(String proId);

    /**
     * 修改项目版本信息
     *
     * @param form
     */
    void reviseProjectVersion(ProVsersionForm form);

    /**
     * 删除项目版本
     *
     * @param uid
     */
    void removeProjectVersion(String uid);

    /**
     * 获取项目版本
     *
     * @param proId
     * @return
     */
    List<ProjectVersion> getProjectVersions(String proId);
}
