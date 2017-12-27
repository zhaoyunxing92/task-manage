package com.sunny.task.server.main;

import com.sunny.task.controller.main.form.AppUserForm;
import com.sunny.task.core.common.exception.TaskException;
import com.sunny.task.model.systemUser.vo.AppUserVo;

/**
 * @author sunny
 * @className com.sunny.task.server.main.AppUserServer
 * @date 2017-12-26 15:42
 * @description:
 */
public interface AppUserServer {
    //未激活状态
    Integer NOT_ACTIVE_STATUS = 9;
    //正常状态
    Integer NORMAL_STATUS = 1;
    //账号锁定
    Integer LOCK_STATUS = 10;

    /**
     * 根据用户uid获取用户
     *
     * @param uId 用户uid
     * @return AppUserVo
     * @throws TaskException
     */
    AppUserVo findAppUserByUId(String uId) throws TaskException;

    /**
     * 添加用户
     *
     * @param form
     */
    void saveAppUser(AppUserForm form);

    /**
     * 检验用户id是否合法
     *
     * @param uId
     */
    Boolean checkUIdIsLegal(String uId);
}
