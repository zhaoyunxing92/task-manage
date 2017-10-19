package com.sunny.task.org.mapper;

import com.sunny.task.common.base.BaseMapper;
import com.sunny.task.org.model.OrganizationApp;

public interface OrganizationAppMapper extends BaseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrganizationApp record);

    int insertSelective(OrganizationApp record);

    OrganizationApp selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrganizationApp record);

    int updateByPrimaryKey(OrganizationApp record);
}