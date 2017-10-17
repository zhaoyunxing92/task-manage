package com.sunny.task.user.mapper;

import com.sunny.task.core.exception.TaskException;
import com.sunny.task.user.model.AppUserByEmail;

public interface AppUserByEmailMapper {
    int deleteByPrimaryKey(String email) throws TaskException;

    int insertSelective(AppUserByEmail record) throws TaskException;

    AppUserByEmail selectByPrimaryKey(String email) throws TaskException;

    int updateByPrimaryKeySelective(AppUserByEmail record) throws TaskException;

    int updateByPrimaryKey(AppUserByEmail record) throws TaskException;
}
