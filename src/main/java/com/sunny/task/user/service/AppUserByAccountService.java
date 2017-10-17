package com.sunny.task.user.service;

import com.sunny.task.user.model.AppUserByAccount;

/**
 * @author sunny
 * @className com.sunny.task.user.service.AppUserByAccountService
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
}
