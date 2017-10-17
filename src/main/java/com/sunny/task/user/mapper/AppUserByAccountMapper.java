package com.sunny.task.user.mapper;

import com.sunny.task.core.exception.TaskException;
import com.sunny.task.user.model.AppUserByAccount;

public interface AppUserByAccountMapper {
    int deleteByPrimaryKey(String account) throws TaskException;
    
    int insertSelective(AppUserByAccount record) throws TaskException;

    AppUserByAccount selectByPrimaryKey(String account) throws TaskException;

    int updateByPrimaryKeySelective(AppUserByAccount record) throws TaskException;

}
