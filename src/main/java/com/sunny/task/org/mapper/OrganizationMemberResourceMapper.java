package com.sunny.task.org.mapper;

import com.sunny.task.common.base.BaseMapper;
import com.sunny.task.org.model.OrganizationMemberResource;

public interface OrganizationMemberResourceMapper extends BaseMapper {
    int insert(OrganizationMemberResource record);

    int insertSelective(OrganizationMemberResource record);
}