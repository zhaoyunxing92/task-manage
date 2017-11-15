package com.sunny.task.service.org.impl;

import com.sunny.task.contaxt.TaskManageUser;
import com.sunny.task.exception.TaskException;
import com.sunny.task.form.org.OrgUserForm;
import com.sunny.task.mapper.org.OrganizationMemberMapper;
import com.sunny.task.model.org.OrganizationMember;
import com.sunny.task.model.org.vo.OrganizationVo;
import com.sunny.task.service.org.OrganizationService;
import com.sunny.task.service.org.OrganizationUserService;
import com.sunny.task.result.ResultEnum;
import com.sunny.task.utils.NullUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sunny
 * @className com.sunny.task.service.org.impl.OrganizationUserServiceImpl
 * @date 2017-10-20 10:07
 * @description:
 */
@Service
public class OrganizationUserServiceImpl implements OrganizationUserService {
    @Autowired
    private OrganizationMemberMapper organizationMemberMapper;

    @Autowired
    private OrganizationService organizationService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TaskManageUser addOrgUser(OrgUserForm form) {
        OrganizationMember orgUser = new OrganizationMember();
        //是否自动添加
        if (!form.getDefaultAdd()) {
            OrganizationVo orgVo = organizationService.getOrganizationDetail(form.getOrgId());
            if(NullUtils.isNull(orgVo)){

            }
            if (orgVo.getUserCount() > orgVo.getMemberLimit()) {
                throw new TaskException(ResultEnum.TASK_ORG_USER_OVERFLOW_ERROR);
            }
        }else{
            orgUser.setManager(Boolean.TRUE);
        }
        BeanUtils.copyProperties(form, orgUser);
        organizationMemberMapper.insertSelective(orgUser);
        TaskManageUser user=new TaskManageUser();
        user.setUid(form.getUid());
        user.setId(form.getId());
        return user;
    }
}
