package com.sunny.task.user.service;

import com.sunny.task.user.model.AppUserByEmail;

/**
 * @author sunny
 * @className com.sunny.task.user.service.AppUserByEmailService
 * @date 2017-10-16 16:53
 * @description:
 */
public interface AppUserByEmailService {
    /**
     * 添加邮箱搜索
     *
     * @param email
     * @param userId
     */
    void addAppUserByEmail(String email, Long userId);

    /**
     * 根据邮箱搜索
     *
     * @param email
     * @return
     */
    AppUserByEmail findAppUserByEmail(String email);
}
