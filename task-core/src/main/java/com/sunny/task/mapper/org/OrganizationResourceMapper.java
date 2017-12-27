package com.sunny.task.mapper.org;

import com.sunny.task.core.common.mapper.BaseMapper;
import com.sunny.task.model.org.OrganizationResource;

public interface OrganizationResourceMapper extends BaseMapper {
    int deleteByPrimaryKey(String sourceId);

    int insert(OrganizationResource record);

    int insertSelective(OrganizationResource record);

    OrganizationResource selectByPrimaryKey(String sourceId);

    int updateByPrimaryKeySelective(OrganizationResource record);

    int updateByPrimaryKey(OrganizationResource record);
}