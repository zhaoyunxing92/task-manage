package com.sunny.task.server.org.impl;

import com.sunny.task.controller.org.form.OrgUserForm;
import com.sunny.task.core.common.context.TaskAppUserContext;
import com.sunny.task.core.common.exception.TaskException;
import com.sunny.task.core.common.result.ResultEnum;
import com.sunny.task.core.common.utils.StringUtils;
import com.sunny.task.core.common.utils.UUIDUtills;
import com.sunny.task.mapper.org.OrganizationMemberMapper;
import com.sunny.task.model.org.OrganizationMember;
import com.sunny.task.model.org.vo.OrganizationMemberVo;
import com.sunny.task.model.org.vo.OrganizationVo;
import com.sunny.task.server.main.AppUserServer;
import com.sunny.task.server.org.OrganizationMemberServer;
import com.sunny.task.server.org.OrganizationServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    @Autowired
    private AppUserServer appUserServer;
    @Autowired
    private OrganizationServer OrganizationServer;

    /**
     * 创建组织默认添加组织
     *
     * @param orgId
     * @return
     */
    @Override
    public void saveOrganizationMemberAuto(String orgId, String userId) {
        saveOrganizationMember(orgId, userId, true);
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
        organizationMember.setUserId(userId);
        organizationMember.setOrgId(orgId);
        organizationMember.setCreator(TaskAppUserContext.getuId());
        //自动添加人员不需要验证团队成员限制
        if (auto) {
            organizationMember.setManager(Boolean.TRUE);
            organizationMember.setNickName(TaskAppUserContext.getNickName());
        } else {
            //验证该团队成员是否超员
            OrganizationVo organization = OrganizationServer.findOrganizationById(orgId);
            if (null == organization) {
                return null;
            }
            //已经添加的成员
            List<String> oldUserList = new ArrayList<>(Arrays.asList(organization.getUserIdList().split(",")));
            //存在不添加
            if (oldUserList.contains(userId)) {
                return null;
            }
            if (organization.getUserCount() >= organization.getMemberLimit()) {
                throw new TaskException(ResultEnum.TASK_ORG_USER_OVERFLOW_ERROR);
            }

            String nickName = appUserServer.findAppUserNickNameByUId(userId);
            if (StringUtils.isEmpty(nickName)) {
                return null;
            }
            organizationMember.setNickName(nickName);
        }
        try {
            organizationMemberMapper.insertSelective(organizationMember);
        } catch (Exception e) {
            throw new TaskException(ResultEnum.TASK_ORG_ADD_USER_ERROR, e);
        }
        return uId;
    }

    /**
     * 前端：添加组织成员
     *
     * @param form
     * @return
     */
    @Override
    public String addOrganizationMember(OrgUserForm form) {

        return saveOrganizationMember(form.getOrgId(), form.getUserId(), false);
    }

    /**
     * 获取团队的全部成员
     *
     * @param orgId
     * @return
     */
    @Override
    public List<OrganizationMemberVo> getOrganizationMembersOrgId(String orgId) {
        return organizationMemberMapper.selectOrganizationMembersOrgId(orgId);
    }
}
