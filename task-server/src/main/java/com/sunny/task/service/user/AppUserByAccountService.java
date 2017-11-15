package com.sunny.task.service.user;

import com.sunny.task.model.user.AppUserByAccount;

/**
 * @author sunny
 * @className com.sunny.task.service.user.AppUserByAccountService
 * @date 2017-10-16 16:18
 * @description:
 */
public interface AppUserByAccountService {
    /**
     * 添加账号搜索
     *
     * @param account
     * @param userId
     */
    void addAppUserByAccount(String account, Long userId);

    /**
     * 根据账户查询  AppUserByAccount
     *
     * @param account
     * @return
     */
    AppUserByAccount findAppUserByAccount(String account);

    /**
     * 根据账号查询用户id
     * @param account
     * @return
     */
    Long findAppUserIdByAccount(String account);
}
