package com.sunny.task.common.base;

import java.io.Serializable;

/**
 * @author sunny
 * @className com.sunny.task.common.base.AppUserStatus
 * @date 2017-10-17 16:12
 * @description:
 */
public class AppUserStatus implements Serializable {
    private static final long serialVersionUID = 7457600815536295842L;
    /**
     * 删除状态--注销
     */
    public final static Integer DEL_STATUS = 0;
    /**
     * 正常状态
     */
    public final static Integer NORMALITY_STATUS = 1;
    //modifier
    /**
     * 修改密码状态
     */
    public final static Integer MODIFIER_PWD_STATUS = 2;

    /**
     * 未激活状态   lock
     */
    public final static Integer NOT_ACTIVATE_STATUS = 9;
    /**
     * 账号锁定
     */
    public final static Integer ACCOUNT_LOCK_STATUS = 16;
}
