package com.sunny.task.mapper.systemUser;

import com.sunny.task.core.common.mapper.BaseMapper;
import com.sunny.task.model.systemUser.AppUserConfig;

public interface AppUserConfigMapper extends BaseMapper {
    int deleteByPrimaryKey(String uId);

    int insert(AppUserConfig record);

    int insertSelective(AppUserConfig record);

    AppUserConfig selectByPrimaryKey(String uId);

    int updateByPrimaryKeySelective(AppUserConfig record);

    int updateByPrimaryKey(AppUserConfig record);
}