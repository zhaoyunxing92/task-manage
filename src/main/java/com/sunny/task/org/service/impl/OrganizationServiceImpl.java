package com.sunny.task.org.service.impl;

import com.sunny.task.org.form.OrgForm;
import com.sunny.task.org.mapper.OrganizationMapper;
import com.sunny.task.org.model.vo.OrganizationVo;
import com.sunny.task.org.service.OrganizationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public OrganizationVo addOrganization(OrgForm form) {
        OrganizationVo orgVo = new OrganizationVo();
        BeanUtils.copyProperties(form, orgVo);
        //organizationMapper.insertSelective(orgVo);
        return orgVo;
    }
}
