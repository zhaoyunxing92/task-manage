package com.sunny.task.server.main;

import com.sunny.task.core.common.exception.TaskException;

/**
 * @author sunny
 * @className com.sunny.task.server.main.AppUserByMobileServer
 * @date 2017-12-26 15:21
 * @description:
 */
public interface AppUserByMobileServer {
    /**
     * 根据手机号获取用户uid
     *
     * @param mobile 手机号
     * @return 用户uid
     * @throws TaskException
     */
    String findAppUserUidByMobile(String mobile) throws TaskException;

    /**
     * 添加根据手机号查询用户uid
     *
     * @param uId    用户uid
     * @param mobile 手机号
     */
    void saveAppUserByMobileKey(String uId, String mobile);
}
