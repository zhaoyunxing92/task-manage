package com.sunny.task.service.user.impl;


import com.sunny.task.exception.TaskException;
import com.sunny.task.result.ResultEnum;
import com.sunny.task.mapper.user.AppUserByMobileMapper;
import com.sunny.task.model.user.AppUserByMobile;
import com.sunny.task.service.user.AppUserByMobileService;
import com.sunny.task.utils.NullUtils;
import com.sunny.task.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sunny
 * @className com.sunny.task.service.user.impl.AppUserByMobileServiceImpl
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

        if (NullUtils.isNotNull(appUserByMobile)) {
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

    @Override
    public Long findAppUserIdByMobile(String mobile) {
        try {
            return appUserByMobileMapper.selectAppUserIdByMobile(mobile);
        } catch (TaskException e) {
            throw new TaskException(ResultEnum.SELECT_APP_USER_BY_MOBILE_ERROR, e);
        }
    }
}
