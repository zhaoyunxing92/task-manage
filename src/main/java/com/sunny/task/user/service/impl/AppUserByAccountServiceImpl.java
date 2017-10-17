package com.sunny.task.user.service.impl;

import com.sunny.task.common.base.ResultEnum;
import com.sunny.task.common.utils.NullUtil;
import com.sunny.task.core.exception.TaskException;
import com.sunny.task.user.mapper.AppUserByAccountMapper;
import com.sunny.task.user.model.AppUserByAccount;
import com.sunny.task.user.service.AppUserByAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sunny
 * @className com.sunny.task.user.service.impl.AppUserByAccountServiceImpl
 * @date 2017-10-16 16:19
 * @description:
 */
@Service
public class AppUserByAccountServiceImpl implements AppUserByAccountService {
    @Autowired
    private AppUserByAccountMapper appUserByAccountMapper;

    @Override
    public void addAppUserByAccount(String account, Long userId) {
        AppUserByAccount appUserByAccount = findAppUserByAccount(account);

        if (NullUtil.isNotNull(appUserByAccount)) {
            throw new TaskException(ResultEnum.ADD_APP_USER_BY_ACCOUNT_EXIST_ACCOUNT);
        }
           
        try {
            appUserByAccount = new AppUserByAccount(account, userId);
            appUserByAccountMapper.insertSelective(appUserByAccount);
        } catch (TaskException e) {
            throw new TaskException(ResultEnum.ADD_APP_USER_BY_ACCOUNT_ERROR, e);
        }
    }

    @Override
    public AppUserByAccount findAppUserByAccount(String account) {
        try {
            return appUserByAccountMapper.selectByPrimaryKey(account);
        } catch (TaskException e) {
            throw new TaskException(ResultEnum.SELECT_APP_USER_BY_ACCOUNT_REEOR, e);
        }
    }
}
