package com.sunny.task.mapper.org;

import com.sunny.task.core.common.mapper.BaseMapper;
import com.sunny.task.model.org.Organization;

public interface OrganizationMapper extends BaseMapper {
    int deleteByPrimaryKey(String id);

    int insert(Organization record);

    int insertSelective(Organization record);

    Organization selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKey(Organization record);
}