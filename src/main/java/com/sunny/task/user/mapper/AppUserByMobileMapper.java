package com.sunny.task.user.mapper;

import com.sunny.task.core.exception.TaskException;
import com.sunny.task.user.model.AppUserByMobile;

public interface AppUserByMobileMapper {
    int deleteByPrimaryKey(String mobile) throws TaskException;

    int insertSelective(AppUserByMobile record) throws TaskException;

    AppUserByMobile selectByPrimaryKey(String mobile) throws TaskException;

    int updateByPrimaryKeySelective(AppUserByMobile record) throws TaskException;

}
