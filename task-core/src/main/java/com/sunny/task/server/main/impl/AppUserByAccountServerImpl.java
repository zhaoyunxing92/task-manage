package com.sunny.task.server.main.impl;

import com.sunny.task.core.common.exception.TaskException;
import com.sunny.task.core.common.result.ResultEnum;
import com.sunny.task.core.common.utils.StringUtils;
import com.sunny.task.mapper.systemUser.AppUserByAccountMapper;
import com.sunny.task.server.main.AppUserByAccountServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sunny
 * @className com.sunny.task.server.main.impl.AppUserByAccountServerImpl
 * @date 2017-12-26 14:55
 * @description:
 */
@Service
public class AppUserByAccountServerImpl implements AppUserByAccountServer {
    @Autowired
    private AppUserByAccountMapper appUserByAccountMapper;

    @Override
    public String findAppUserUidByAccount(String account) {
        if (StringUtils.isBlank(account)) {
            return "";
        }
        return appUserByAccountMapper.selectAppUserUidByAccount(account);
    }

    /**
     * 添加根据用户名获取uid
     *
     * @param uId     用户uid
     * @param account 账号
     */
    @Override
    public synchronized void saveAppUserByAccountKey(String uId, String account) {
        if (StringUtils.isBlank(findAppUserUidByAccount(account))) {
            try {
                appUserByAccountMapper.insertAppUserByAccountKey(uId, account);
            } catch (Exception e) {
                throw new TaskException(ResultEnum.ADD_APP_USER_BY_ACCOUNT_ERROR, e.getLocalizedMessage());
            }
        }
    }

}
