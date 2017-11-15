package com.sunny.task.service.user;

import com.sunny.task.model.user.AppUserByEmail;

/**
 * @author sunny
 * @className com.sunny.task.service.user.AppUserByEmailService
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

    /**
     * 根据邮箱获取用户id
     * @param email
     * @return
     */
    Long findAppUserIdByEmail(String email);
}
