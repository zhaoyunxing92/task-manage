package com.sunny.task.org.mapper;

import com.sunny.task.common.base.BaseMapper;
import com.sunny.task.org.model.OrganizationChat;

public interface OrganizationChatMapper extends BaseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrganizationChat record);

    int insertSelective(OrganizationChat record);

    OrganizationChat selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrganizationChat record);

    int updateByPrimaryKey(OrganizationChat record);
}