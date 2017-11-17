package com.sunny.task.service.project;

import com.sunny.task.form.pro.ProUserForm;

import java.util.List;

/**
 * @author sunny
 * @className com.sunny.task.service.project.ProjectUserService
 * @date 2017-11-15 17:45
 * @description:
 */
public interface ProjectUserService {

    /**
     * 添加项目用户
     *
     * @param orgId
     * @param proId
     * @param auto
     * @param userIds
     */
    void addProjectUser(String orgId, String proId, Boolean auto, List<String> userIds);

    /**
     * 添加项目用户
     *
     * @param proId
     * @param auto
     * @param userIds
     */
    void addProjectUser(String proId, Boolean auto, List<String> userIds);

    /**
     * 批量删除用户
     *
     * @param proId
     * @param userIds
     */
    void removeProjectUserByProId(String proId, List<String> userIds);

    /**
     * 修改用户信息
     *
     * @param form
     */
    void reviseProjectUserByProId(ProUserForm form);
}
