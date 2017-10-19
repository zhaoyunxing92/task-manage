package com.sunny.task.org.mapper;

import com.sunny.task.common.base.BaseMapper;
import com.sunny.task.org.model.OrganizationResource;

public interface OrganizationResourceMapper extends BaseMapper {
    int insert(OrganizationResource record);

    int insertSelective(OrganizationResource record);
}