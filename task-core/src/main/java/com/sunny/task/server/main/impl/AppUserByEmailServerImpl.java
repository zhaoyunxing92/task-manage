package com.sunny.task.server.main.impl;

import com.sunny.task.core.common.exception.TaskException;
import com.sunny.task.core.common.utils.StringUtils;
import com.sunny.task.mapper.systemUser.AppUserByEmailMapper;
import com.sunny.task.server.main.AppUserByEmailServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author sunny
 * @className com.sunny.task.server.main.impl.AppUserByEmailServerImpl
 * @date 2017-12-26 15:14
 * @description:
 */
@Service
public class AppUserByEmailServerImpl implements AppUserByEmailServer {
    @Autowired
    private AppUserByEmailMapper appUserByEmailMapper;

    @Override
    public String findAppUserUidByEmail(String email) throws TaskException {
        if (StringUtils.isBlank(email)) {
            return "";
        }
        return appUserByEmailMapper.selectAppUserUidByEmail(email);
    }

    /**
     * 添加根据邮箱查询用户id
     *
     * @param uId   uid
     * @param email 邮箱
     */
    @Override
    @Async
    public void saveAppUserByEmailKey(String uId, String email) {
        synchronized (this) {
            if (StringUtils.isEmail(email) && StringUtils.isBlank(findAppUserUidByEmail(email))) {
                appUserByEmailMapper.insertAppUserByEmailKey(uId, email);
            }
        }
    }
}
