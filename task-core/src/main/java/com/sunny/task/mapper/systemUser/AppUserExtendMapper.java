package com.sunny.task.mapper.systemUser;

import com.sunny.task.core.common.mapper.BaseMapper;
import com.sunny.task.model.systemUser.AppUserExtend;

public interface AppUserExtendMapper extends BaseMapper {
    int deleteByPrimaryKey(String uId);

    int insert(AppUserExtend record);

    int insertSelective(AppUserExtend record);

    AppUserExtend selectByPrimaryKey(String uId);

    int updateByPrimaryKeySelective(AppUserExtend record);

    int updateByPrimaryKey(AppUserExtend record);
}