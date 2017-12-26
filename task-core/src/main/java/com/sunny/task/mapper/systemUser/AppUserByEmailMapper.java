package com.sunny.task.mapper.systemUser;

import com.sunny.task.core.common.exception.TaskException;
import com.sunny.task.core.common.mapper.BaseMapper;
import com.sunny.task.model.systemUser.AppUserByEmail;
import org.apache.ibatis.annotations.Param;

public interface AppUserByEmailMapper extends BaseMapper<AppUserByEmail, String> {
    /**
     * 根据邮箱获取用户uid
     *
     * @param email 邮箱
     * @return 用户uid
     */
    String selectAppUserUidByEmail(String email);

    /**
     * 添加根据邮箱查看uid方法
     *
     * @param uId   用户uid
     * @param email 邮箱
     */
    void insertAppUserByEmailKey(@Param("uId") String uId, @Param("email") String email) throws TaskException;
}
