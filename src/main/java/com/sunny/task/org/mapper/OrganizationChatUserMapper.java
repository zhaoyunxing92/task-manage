package com.sunny.task.org.mapper;

import com.sunny.task.common.base.BaseMapper;
import com.sunny.task.org.model.OrganizationChatUser;

public interface OrganizationChatUserMapper extends BaseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrganizationChatUser record);

    int insertSelective(OrganizationChatUser record);

    OrganizationChatUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrganizationChatUser record);

    int updateByPrimaryKey(OrganizationChatUser record);
}