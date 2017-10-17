package com.sunny.task.user.service;

import com.sunny.task.user.model.AppUserByMobile;

/**
 * @author sunny
 * @className com.sunny.task.user.service.AppUserByMobileService
 * @date 2017-10-16 17:29
 * @description: 根据手机号查询用户
 */
public interface AppUserByMobileService {
    /**
     * 添加手机号搜索
     *
     * @param mobile
     * @param userId
     */
    void addAppUserByMobile(String mobile, Long userId);

    /**
     * 根据手机号查询
     *
     * @param mobile
     * @return
     */
    AppUserByMobile findAppUserByMobile(String mobile);

    /**
     * 根据手机号获取用户id
     *
     * @param mobile
     * @return
     */
    Long findAppUserIdByMobile(String mobile);
}
