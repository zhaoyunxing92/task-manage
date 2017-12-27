package com.sunny.task.server.org.impl;

import com.sunny.task.core.common.context.TaskAppUserContext;
import com.sunny.task.core.common.utils.UUIDUtills;
import com.sunny.task.mapper.org.OrganizationMemberMapper;
import com.sunny.task.model.org.OrganizationMember;
import com.sunny.task.server.org.OrganizationMemberServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sunny
 * @className com.sunny.task.server.org.impl.OrganizationMemberServerImpl
 * @date 2017-12-27 15:52
 * @description:
 */
@Service
public class OrganizationMemberServerImpl implements OrganizationMemberServer {
    @Autowired
    private OrganizationMemberMapper organizationMemberMapper;

    /**
     * 创建组织默认添加组织
     *
     * @param orgId
     * @return
     */
    @Override
    public String saveOrganizationMemberAuto(String orgId, String userId) {
        return saveOrganizationMember(orgId, userId, true);
    }

    /**
     * 添加组织成员
     *
     * @param orgId
     * @param userId
     * @param auto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String saveOrganizationMember(String orgId, String userId, Boolean auto) {

        OrganizationMember organizationMember = new OrganizationMember();
        String uId = UUIDUtills.getUUID(OrganizationMemberServer.ORG_USER_UID_PREFIX);
        organizationMember.setuId(uId);
        organizationMember.setManager(auto);
        organizationMember.setOrgId(orgId);
        //自动添加人员不需要验证团队成员限制
        if (auto) {
            organizationMember.setUserId(userId);
            organizationMember.setNickName(TaskAppUserContext.getNackName());
        }
        try {
            organizationMemberMapper.insertSelective(organizationMember);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return uId;
    }
}
