package com.sunny.task.server.org.impl;

import com.sunny.task.controller.org.form.OrgForm;
import com.sunny.task.core.common.context.TaskAppUserContext;
import com.sunny.task.core.common.exception.TaskException;
import com.sunny.task.core.common.result.ResultEnum;
import com.sunny.task.core.common.utils.UUIDUtills;
import com.sunny.task.mapper.org.OrganizationMapper;
import com.sunny.task.model.org.Organization;
import com.sunny.task.model.org.vo.OrganizationVo;
import com.sunny.task.server.org.OrganizationMemberServer;
import com.sunny.task.server.org.OrganizationServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sunny
 * @className com.sunny.task.server.org.impl.OrganizationServerImpl
 * @date 2017-12-27 15:02
 * @description:
 */
@Service
public class OrganizationServerImpl implements OrganizationServer {
    @Autowired
    private OrganizationMapper organizationMapper;
    @Autowired
    private OrganizationMemberServer organizationMemberServer;

    /**
     * 创建组织
     *
     * @param form
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String addOrganization(OrgForm form) {
        String uId;
        try {
            String userUId = TaskAppUserContext.getuId();

            uId = UUIDUtills.getUUID(OrganizationServer.ORG_UID_PREFIX);
            Organization organization = new Organization();
            organization.setName(form.getName());
            organization.setuId(uId);
            organization.setIntro(form.getIntro());
            organization.setAddress(form.getAddress());
            organization.setOwnerId(userUId);
            organization.setCreator(userUId);
            organizationMapper.insertSelective(organization);
            //添加成员
            organizationMemberServer.saveOrganizationMemberAuto(uId, userUId);
        } catch (Exception ex) {
            throw new TaskException(ResultEnum.TASK_INSERT_ORG_ERROR, ex);
        }
        return uId;
    }

    @Override
    public OrganizationVo findOrganizationById(String id) {
        return organizationMapper.selectOrganizationById(id, TaskAppUserContext.getuId());
    }

    /**
     * 获取当前登录人的组织列表
     * @return
     */
    @Override
    public List<OrganizationVo> getOrganizationByUserUId() {

     
        return organizationMapper.selectOrganizationByUserUId(TaskAppUserContext.getuId());
    }
}
