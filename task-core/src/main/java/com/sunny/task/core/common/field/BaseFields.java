package com.sunny.task.core.common.field;

import java.io.Serializable;

/**
 * @author sunny
 * @className com.sunny.task.core.common.base.BaseFields
 * @date 2017-10-16 11:19
 * @description:
 */
public class BaseFields implements Serializable {
    private static final long serialVersionUID = 5633217122325857943L;

    public static String DEFAULT_PASSWORD = "{taks/null}";
    /**
     * 1=用户,2=团队,3=微应用,4=chat,5=project
     */
    public final static Byte APP_USER_TYPE = 1;
    /**
     * 团队
     */
    public final static Byte APP_ORG_TYPE = 2;
    /**
     * 微应用
     */
    public final static Byte APP_ORG_APP_TYPE = 3;
    /**
     * 群
     */
    public final static Byte APP_ORG_CHAT_TYPE = 4;
    /**
     * project
     */
    public final static Byte APP_ORG_PROJECT_TYPE = 5;


    /**
     * 用户唯一id 前缀
     */
    public final static String APP_USER_PREFIX_UNQ_ID = "task";

    public final static String TASK_ORG_PREFIX_UNQ_ID = "org";
    /**
     * cookie 的key
     */
    public final static String APP_USER_COOKIE_KEY = "task_user_token";
    /**
     * 发送激活账号邮箱模板
     */
    public final static String TASK_EMAIL_ACTIVE_ACCOUNT_TMP = "email/active-account-email.ftl";

    /**
     * 发送激活账号邮箱主题
     */
    public final static String TASK_EMAIL_ACTIVE_ACCOUNT_THEME = "欢迎使用task";

    /**
     * 激活成功回调url
     */
    public final static String task_email_active_assount_success_back_url = "";

    /**
     * 激活失败回调url
     */
    public final static String task_email_active_assount_error_back_url = "";

    /**
     * 服务器地址
     */
    public final static String task_email_host = "http://localhost:8088/task/";

}
