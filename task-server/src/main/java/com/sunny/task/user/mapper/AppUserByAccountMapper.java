package com.sunny.task.user.mapper;


import com.sunny.task.exception.TaskException;
import com.sunny.task.user.model.AppUserByAccount;
import org.apache.ibatis.annotations.Param;

public interface AppUserByAccountMapper {
    int deleteByPrimaryKey(String account) throws TaskException;

    int insertSelective(AppUserByAccount record) throws TaskException;

    AppUserByAccount selectByPrimaryKey(String account) throws TaskException;

    int updateByPrimaryKeySelective(AppUserByAccount record) throws TaskException;

    /**
     * 查询用户id
     *
     * @param account
     * @return
     * @throws TaskException
     */
    Long selectAppUserIdByPrimaryKey(@Param("account") String account) throws TaskException;
}
