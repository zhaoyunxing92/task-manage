package com.sunny.task.common.base;

import java.io.Serializable;

/**
 * @author sunny
 * @className com.sunny.task.common.base.BaseFields
 * @date 2017-10-16 11:19
 * @description:
 */
public class BaseFields implements Serializable {
    private static final long serialVersionUID = 5633217122325857943L;

    public static String DEFAULT_PASSWORD = "{taks/null}";
    /**
     * 用户唯一id 前缀
     */
    public final static String app_user_prefix_unq_id = "task";
    /**
     * cookie 的key
     */
    public final static String app_user_cookie_key = "task_user_token";

}
