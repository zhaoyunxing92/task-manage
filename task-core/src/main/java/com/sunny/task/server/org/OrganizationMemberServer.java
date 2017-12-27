package com.sunny.task.server.org;

/**
 * @author sunny
 * @className com.sunny.task.server.org.OrganizationMemberServer
 * @date 2017-12-27 15:51
 * @description: 团队成员
 */
public interface OrganizationMemberServer {
    String ORG_USER_UID_PREFIX = "org_u";
    /**
     * 创建组织默认添加组织
     *
     * @param orgId
     * @param userId
     * @return
     */
    String saveOrganizationMemberAuto(String orgId, String userId);

    /**
     * 添加组织成员
     *
     * @param orgId
     * @param userId
     * @param auto
     * @return
     */
    String saveOrganizationMember(String orgId, String userId, Boolean auto);
}
