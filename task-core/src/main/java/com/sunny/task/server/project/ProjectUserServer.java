package com.sunny.task.server.project;

import com.sunny.task.controller.project.form.ProjectUserForm;

/**
 * @author sunny
 * @className com.sunny.task.server.project.ProjectUserServer
 * @date 2017-12-28 13:34
 * @description:
 */
public interface ProjectUserServer {
    String ORG_PROJECT_USER_UID_PREFIX = "org_p_u";

    /**
     * 添加项目成员
     *
     * @param orgId  团队id
     * @param proId  项目id
     * @param userId 成员id
     */
    void addOrgnizationProjectUserAuto(String orgId, String proId, String userId);

    /**
     * 批量添加项目成员
     *
     * @param orgId   团队
     * @param proId   项目
     * @param userIds 项目成员集合
     * @param auto    是否自动添加
     */
    void addOrgnizationProjectUsers(String orgId, String proId, String[] userIds, Boolean auto);

    /**
     * 批量添加项目成员
     *
     * @param form 前端提交表单
     */
    void addOrgnizationProjectUsers(ProjectUserForm form);
}
