package com.sunny.task.user.service.impl;

import com.sunny.task.common.base.ResultEnum;
import com.sunny.task.common.utils.NullUtils;
import com.sunny.task.common.utils.StringUtils;
import com.sunny.task.core.exception.TaskException;
import com.sunny.task.user.mapper.AppUserByEmailMapper;
import com.sunny.task.user.model.AppUserByEmail;
import com.sunny.task.user.service.AppUserByEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sunny
 * @className com.sunny.task.user.service.impl.AppUserByEmailServiceImpl
 * @date 2017-10-16 16:53
 * @description: 根据邮箱查询用户
 */
@Service
public class AppUserByEmailServiceImpl implements AppUserByEmailService {
    @Autowired
    private AppUserByEmailMapper appUserByEmailMapper;

    @Override
    public void addAppUserByEmail(String email, Long userId) {
        AppUserByEmail appUserByEmail = findAppUserByEmail(email);
        System.out.println(NullUtils.isNotNull(appUserByEmail));
        if (NullUtils.isNotNull(appUserByEmail)) {
            throw new TaskException(ResultEnum.ADD_APP_USER_BY_EMAIL_EXIST_EMAIL);
        }

        try {
            appUserByEmail = new AppUserByEmail(email, userId);
            appUserByEmailMapper.insertSelective(appUserByEmail);
        } catch (TaskException e) {
            throw new TaskException(ResultEnum.ADD_APP_USER_BY_EMAIL_ERROR, e);
        }
    }

    @Override
    public AppUserByEmail findAppUserByEmail(String email) {
        if (!StringUtils.isEmail(email)) {
            throw new TaskException(ResultEnum.EMAIL_FORMAT_ERROR);
        }
        try {
            return appUserByEmailMapper.selectByPrimaryKey(email);
        } catch (TaskException e) {
            throw new TaskException(ResultEnum.SELECT_APP_USER_BY_EMAIL_ERROR, e);
        }
    }

    @Override
    public Long findAppUserIdByEmail(String email) {
        try {
            return appUserByEmailMapper.selectAppUserIdByEmail(email);
        } catch (TaskException e) {
            throw new TaskException(ResultEnum.SELECT_APP_USER_BY_EMAIL_ERROR, e);
        }
    }
}
