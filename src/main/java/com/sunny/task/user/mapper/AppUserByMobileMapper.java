package com.sunny.task.user.mapper;

import com.sunny.task.core.exception.TaskException;
import com.sunny.task.user.model.AppUserByMobile;
import org.apache.ibatis.annotations.Param;

public interface AppUserByMobileMapper {
    int deleteByPrimaryKey(String mobile) throws TaskException;

    int insertSelective(AppUserByMobile record) throws TaskException;

    AppUserByMobile selectByPrimaryKey(String mobile) throws TaskException;

    int updateByPrimaryKeySelective(AppUserByMobile record) throws TaskException;

    /**
     * 根据手机号获取用户id
     *
     * @param mobile
     * @return
     * @throws TaskException
     */
    Long selectAppUserIdByMobile(@Param("mobile") String mobile) throws TaskException;
}