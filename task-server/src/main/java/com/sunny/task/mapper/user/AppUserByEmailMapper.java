package com.sunny.task.mapper.user;


import com.sunny.task.exception.TaskException;
import com.sunny.task.model.user.AppUserByEmail;
import org.apache.ibatis.annotations.Param;

public interface AppUserByEmailMapper {
    int deleteByPrimaryKey(String email) throws TaskException;

    int insertSelective(AppUserByEmail record) throws TaskException;

    AppUserByEmail selectByPrimaryKey(String email) throws TaskException;

    int updateByPrimaryKeySelective(AppUserByEmail record) throws TaskException;

    int updateByPrimaryKey(AppUserByEmail record) throws TaskException;

    /**
     * 根据邮箱获取用户id
     *
     * @param email
     * @return
     * @throws TaskException
     */
    Long selectAppUserIdByEmail(@Param("email") String email) throws TaskException;
}