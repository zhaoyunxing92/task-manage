package com.sunny.task.server.main.impl;

import com.sunny.task.core.common.exception.TaskException;
import com.sunny.task.core.common.result.ResultEnum;
import com.sunny.task.core.common.utils.StringUtils;
import com.sunny.task.mapper.systemUser.AppUserByEmailMapper;
import com.sunny.task.server.main.AppUserByEmailServer;
import com.sunny.task.server.main.AppUserServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @author sunny
 * @className com.sunny.task.server.main.impl.AppUserByEmailServerImpl
 * @date 2017-12-26 15:14
 * @description:
 */
@Service
public class AppUserByEmailServerImpl implements AppUserByEmailServer {
    private final static Logger logger = LoggerFactory.getLogger(AppUserByEmailServerImpl.class);
    @Autowired
    private AppUserByEmailMapper appUserByEmailMapper;
    @Autowired
    @Lazy //懒加载解决循环引用问题
    private AppUserServer appUserServer;

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
    public synchronized void saveAppUserByEmailKey(String uId, String email) {

        if (StringUtils.isEmail(email) && StringUtils.isBlank(findAppUserUidByEmail(email))) {
            try {
                appUserByEmailMapper.insertAppUserByEmailKey(uId, email);
            } catch (Exception e) {
                throw new TaskException(ResultEnum.ADD_APP_USER_BY_EMAIL_ERROR, e.getLocalizedMessage());
            }

        }
    }
}
