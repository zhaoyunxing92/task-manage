package com.sunny.task.mapper.user;


import com.sunny.task.exception.TaskException;
import com.sunny.task.model.user.AppUserByEmail;
import org.apache.ibatis.annotations.Param;

/**
 * @author sunny
 * @name AppUserByEmailMapper
 * @date 2017.11.29 17:38
 * @description:
 */
public interface AppUserByEmailMapper {
    /**
     * 根据主键email删除关联关系
     * @param email
     * @return
     * @throws TaskException
     */
    int deleteByPrimaryKey(String email) throws TaskException;

    /**
     * 添加邮箱关联关系
     * @param record
     * @return
     * @throws TaskException
     */
    int insertSelective(AppUserByEmail record) throws TaskException;

    /**
     *  根据主键查询关联关系
     * @param email
     * @return
     * @throws TaskException
     */
    AppUserByEmail selectByPrimaryKey(String email) throws TaskException;

    /**
     * 根据主键更新关联关系
     * @param record
     * @return
     * @throws TaskException
     */
    int updateByPrimaryKeySelective(AppUserByEmail record) throws TaskException;

    /**
     * 根据主键更新关联关系
     * @param record
     * @return
     * @throws TaskException
     */
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
