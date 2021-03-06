package com.sunny.task.core.common.context;

import java.io.Serializable;

/**
 * @author sunny
 * @className com.sunny.task.core.common.context.TaskAppUser
 * @date 2017-10-18 15:49
 * @description: TaskAppUserContext
 */
public class TaskAppUserContext implements Serializable {
    private static final long serialVersionUID = -3161739774742781590L;

    private TaskAppUserContext() {
        super();
    }

    /**
     * 用户唯一id
     */
    private static String uId;
    /**
     * 昵称
     */
    private static String nickName;

    public static String getuId() {
        return uId;
    }

    public static synchronized void setuId(String uId) {
        TaskAppUserContext.uId = uId;
    }

    public static String getNickName() {
        return nickName;
    }

    public static synchronized void setNickName(String nickName) {
        TaskAppUserContext.nickName = nickName;
    }
}
