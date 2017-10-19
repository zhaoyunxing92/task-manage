package com.sunny.task.org.mapper;

import com.sunny.task.common.base.BaseMapper;
import com.sunny.task.org.model.OrganizationMember;

public interface OrganizationMemberMapper extends BaseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrganizationMember record);

    int insertSelective(OrganizationMember record);

    OrganizationMember selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrganizationMember record);

    int updateByPrimaryKey(OrganizationMember record);
}