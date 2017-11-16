package com.sunny.task.service.project;

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
     * @param users
     */
    void addProjectUser(String orgId, String proId, Boolean auto, List<String> users);

    /**
     * 添加项目用户
     *
     * @param proId
     * @param auto
     * @param users
     */
    void addProjectUser(String proId, Boolean auto, List<String> users);

}
