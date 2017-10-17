package com.sunny.task.user.service.impl;

import com.sunny.task.common.base.ResultEnum;
import com.sunny.task.common.utils.NullUtil;
import com.sunny.task.common.utils.StringUtils;
import com.sunny.task.core.exception.TaskException;
import com.sunny.task.user.mapper.AppUserByMobileMapper;
import com.sunny.task.user.model.AppUserByMobile;
import com.sunny.task.user.service.AppUserByMobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sunny
 * @className com.sunny.task.user.service.impl.AppUserByMobileServiceImpl
 * @date 2017-10-16 17:30
 * @description:
 */
@Service
public class AppUserByMobileServiceImpl implements AppUserByMobileService {
    @Autowired
    private AppUserByMobileMapper appUserByMobileMapper;

    @Override
    public void addAppUserByMobile(String mobile, Long userId) {
        AppUserByMobile appUserByMobile = findAppUserByMobile(mobile);

        if (NullUtil.isNotNull(appUserByMobile)) {
            throw new TaskException(ResultEnum.ADD_APP_USER_BY_MOBILE_EXIST_MOBILE);
        }

        try {
            appUserByMobile = new AppUserByMobile(mobile, userId);
            appUserByMobileMapper.insertSelective(appUserByMobile);
        } catch (TaskException e) {
            throw new TaskException(ResultEnum.ADD_APP_USER_BY_MOBILE_ERROR, e);
        }
    }

    @Override
    public AppUserByMobile findAppUserByMobile(String mobile) {
        if (!StringUtils.isMobile(mobile)) {
            throw new TaskException(ResultEnum.MOBILE_FORMAT_ERROR);
        }

        try {
            return appUserByMobileMapper.selectByPrimaryKey(mobile);
        } catch (TaskException e) {
            throw new TaskException(ResultEnum.SELECT_APP_USER_BY_MOBILE_ERROR, e);
        }
    }
}
