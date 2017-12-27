package com.sunny.task.server.main.impl;

import com.sunny.task.controller.main.form.AppUserForm;
import com.sunny.task.core.common.exception.TaskException;
import com.sunny.task.core.common.result.ResultEnum;
import com.sunny.task.mapper.systemUser.AppUserMapper;
import com.sunny.task.model.systemUser.AppUser;
import com.sunny.task.model.systemUser.vo.AppUserVo;
import com.sunny.task.server.main.AppUserByAccountServer;
import com.sunny.task.server.main.AppUserByEmailServer;
import com.sunny.task.server.main.AppUserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sunny
 * @className com.sunny.task.server.main.impl.AppUserServerImpl
 * @date 2017-12-26 15:46
 * @description:
 */
@Service
public class AppUserServerImpl implements AppUserServer {
    @Autowired
    private AppUserMapper appUserMapper;
    @Autowired
    private AppUserByAccountServer appUserByAccountServer;
    @Autowired
    private AppUserByEmailServer appUserByEmailServer;

    @Override
    public AppUserVo findAppUserByUId(String uId) throws TaskException {
        return appUserMapper.selectAppUserByUId(uId);
    }

    /**
     * 添加用户
     *
     * @param form
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveAppUser(AppUserForm form) {

        try {
            AppUser appUser = new AppUser();
            String account = form.getAccount();
            // BeanUtils.copyProperties(form, appUser);
            String uId = form.getuId();
            String password = form.getPassword();
            String email = form.getEmail();
            appUser.setId(uId);
            appUser.setCreator(uId);
            appUser.setPassword2(password);
            appUser.setPassword1(password);
            appUser.setEmail(email);
            appUser.setAccount(account);
            appUser.setNickName(account);
            appUser.setStatus(AppUserServer.NOT_ACTIVE_STATUS);
            appUserMapper.insertSelective(appUser);
            //插入查询表 
            appUserByAccountServer.saveAppUserByAccountKey(uId, account);
            appUserByEmailServer.saveAppUserByEmailKey(uId, email);
        } catch (Exception ex) {
            throw new TaskException(ResultEnum.ADD_APP_USER_BY_ACCOUNT_ERROR, ex);
        }

//        AppUserExtend appUserExtend = new AppUserExtend();
//        appUserExtend.setuId(uId);
//        appUserExtend.setCreator(uId);
//        appUserExtend.setModifier(uId);
//        appUserExtendMapper.insertSelective(appUserExtend);

    }

    /**
     * 检验用户id是否合法
     *
     * @param uId
     */
    @Override
    public Boolean checkUIdIsLegal(String uId) {
        return 1 == appUserMapper.selectAppUserCount(uId);
    }
}
