package com.sunny.task.server.main;

import com.sunny.task.core.common.exception.TaskException;

/**
 * @author sunny
 * @className com.sunny.task.server.main.AppUserByAccountServer
 * @date 2017-12-26 14:54
 * @description:
 */
public interface AppUserByAccountServer {
    String findAppUserUidByAccount(String account) throws TaskException;

    /**
     * 添加根据用户名获取uid
     *
     * @param uId     用户uid
     * @param account 账号
     */
    void saveAppUserByAccountKey(String uId, String account);
}
