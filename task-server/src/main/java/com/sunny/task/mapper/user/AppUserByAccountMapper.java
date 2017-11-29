package com.sunny.task.mapper.user;


import com.sunny.task.exception.TaskException;
import com.sunny.task.model.user.AppUserByAccount;
import org.apache.ibatis.annotations.Param;

/**
 * @author sunny
 * @name AppUserByAccountMapper
 * @date 2017.11.29 17:35
 * @description:
 */
public interface AppUserByAccountMapper {
    /**
     * 根据账号删除关联关系
     *
     * @param account
     * @return
     * @throws TaskException
     */
    int deleteByPrimaryKey(String account) throws TaskException;

    /**
     * 添加关联关系
     * @param record
     * @return
     * @throws TaskException
     */
    int insertSelective(AppUserByAccount record) throws TaskException;

    /**
     * 根据主键account获取关联关系
     * @param account
     * @return
     * @throws TaskException
     */
    AppUserByAccount selectByPrimaryKey(String account) throws TaskException;

    /**
     * 根据主键 account 更新关联关系
     * @param record
     * @return
     * @throws TaskException
     */
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
