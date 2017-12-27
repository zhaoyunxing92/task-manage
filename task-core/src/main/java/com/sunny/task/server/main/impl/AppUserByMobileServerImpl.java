package com.sunny.task.server.main.impl;

import com.sunny.task.core.common.exception.TaskException;
import com.sunny.task.core.common.result.ResultEnum;
import com.sunny.task.core.common.utils.StringUtils;
import com.sunny.task.mapper.systemUser.AppUserByMobileMapper;
import com.sunny.task.server.main.AppUserByMobileServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author sunny
 * @className com.sunny.task.server.main.impl.AppUserByMobileServerImpl
 * @date 2017-12-26 15:22
 * @description:
 */
@Service
public class AppUserByMobileServerImpl implements AppUserByMobileServer {
    private final static Logger logger = LoggerFactory.getLogger(AppUserByAccountServerImpl.class);
    @Autowired
    private AppUserByMobileMapper appUserByMobileMapper;

    @Override
    public String findAppUserUidByMobile(String mobile) throws TaskException {
        if (StringUtils.isBlank(mobile)) {
            return "";
        }
        return appUserByMobileMapper.selectAppUserUidByMobile(mobile);
    }

    /**
     * 添加根据手机号查询用户uid
     *
     * @param uId    用户uid
     * @param mobile 手机号
     */
    @Override
    @Async
    public void saveAppUserByMobileKey(String uId, String mobile) {
        if (StringUtils.isMobile(mobile) && StringUtils.isBlank(findAppUserUidByMobile(mobile))) {
            try {
                appUserByMobileMapper.insertAppUserByMobileKey(uId, mobile);
            } catch (Exception e) {
                throw new TaskException(ResultEnum.ADD_APP_USER_BY_MOBILE_ERROR, e.getLocalizedMessage());
            }
        }
    }
}
