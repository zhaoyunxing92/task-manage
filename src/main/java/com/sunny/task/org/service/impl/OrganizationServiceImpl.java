package com.sunny.task.org.service.impl;

import com.sunny.task.common.base.BaseFields;
import com.sunny.task.common.base.ResultEnum;
import com.sunny.task.common.context.TaskAppUserContext;
import com.sunny.task.common.utils.NullUtils;
import com.sunny.task.common.utils.UUIDUtills;
import com.sunny.task.core.exception.TaskException;
import com.sunny.task.org.form.OrgForm;
import com.sunny.task.org.form.OrgUserForm;
import com.sunny.task.org.mapper.OrganizationMapper;
import com.sunny.task.org.model.vo.OrganizationVo;
import com.sunny.task.org.service.OrganizationService;
import com.sunny.task.org.service.OrganizationUserService;
import com.sunny.task.unique.service.PrimaryKeyByUniqueIdService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sunny
 * @className com.sunny.task.org.service.impl.OrganizationServiceImpl
 * @date 2017-10-19 16:19
 * @description:
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private OrganizationMapper organizationMapper;
    @Autowired
    private OrganizationUserService organizationUserService;
    @Autowired
    private PrimaryKeyByUniqueIdService primaryKeyByUniqueIdService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrganizationVo addOrganization(OrgForm form) {
        String userUnquId;
        String unqId;
        OrganizationVo orgVo;
        try {
            userUnquId = TaskAppUserContext.getTaskUserUNQId();
            unqId = UUIDUtills.getPrefixUUID(BaseFields.TASK_ORG_PREFIX_UNQ_ID);
            orgVo = new OrganizationVo();
            BeanUtils.copyProperties(form, orgVo);
            orgVo.setUniqueId(unqId);
            orgVo.setOwnerId(userUnquId);
            organizationMapper.insertSelective(orgVo);
        } catch (TaskException e) {
            throw new TaskException(ResultEnum.TASK_INSERT_ORG_ERROR, e);
        }
        //添加成员
        Long orgId = orgVo.getId();
        addOrgUser(unqId, userUnquId);
        /**添加unq搜索*/
        primaryKeyByUniqueIdService.addPrimaryKeyByUniqueId(unqId, orgId, BaseFields.APP_ORG_TYPE);
        return orgVo;
    }

    private void addOrgUser(String unqId, String userId) {
        OrgUserForm userForm = new OrgUserForm();
        userForm.setOrgId(unqId);
        userForm.setUserId(userId);
        userForm.setDefaultAdd(Boolean.TRUE);//是默认添加
        organizationUserService.addOrgUser(userForm);
    }

    @Override
    public OrganizationVo getOrganizationDetail(String uId) {
        OrganizationVo orgVo;
        try {
            orgVo = organizationMapper.selectOrgDetailByUId(uId, TaskAppUserContext.getTaskUserUNQId());
        } catch (TaskException e) {
            throw new TaskException(ResultEnum.TASK_ORG_SELECT_ERROR, e);
        }
        //组织为空
        if (NullUtils.isNull(orgVo)) {
            throw new TaskException(ResultEnum.TASK_ORG_SELECT_NOT_EXIST_ERROR);
        }
        return orgVo;
    }

    @Override
    public List<OrganizationVo> getAppUserOrgsByUserId(String userId) {
        return organizationMapper.selectAppUserOrgsByUserId(userId);
    }
}
