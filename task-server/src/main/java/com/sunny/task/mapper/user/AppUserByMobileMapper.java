package com.sunny.task.mapper.user;


import com.sunny.task.exception.TaskException;
import com.sunny.task.model.user.AppUserByMobile;
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
