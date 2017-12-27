package com.sunny.task.server.main;

import com.sunny.task.core.common.exception.TaskException;

/**
 * @author sunny
 * @className com.sunny.task.server.main.AppUserByEmailServer
 * @date 2017-12-26 15:12
 * @description:
 */
public interface AppUserByEmailServer {
    /**
     * 根据邮箱获取用户uid
     *
     * @param email 邮箱
     * @return 用户uid
     * @throws TaskException
     */
    String findAppUserUidByEmail(String email) throws TaskException;

    /**
     * 添加根据邮箱查询用户id
     *
     * @param uId   uid
     * @param email 邮箱
     */
    void saveAppUserByEmailKey(String uId, String email);

}
