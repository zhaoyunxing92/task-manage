package com.sunny.task.mapper.org;

import com.sunny.task.core.common.mapper.BaseMapper;
import com.sunny.task.model.org.OrganizationMemberResource;

public interface OrganizationMemberResourceMapper extends BaseMapper {
    int deleteByPrimaryKey(String orgUId);

    int insert(OrganizationMemberResource record);

    int insertSelective(OrganizationMemberResource record);

    OrganizationMemberResource selectByPrimaryKey(String orgUId);

    int updateByPrimaryKeySelective(OrganizationMemberResource record);

    int updateByPrimaryKey(OrganizationMemberResource record);
}