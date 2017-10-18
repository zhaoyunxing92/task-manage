package com.sunny.task.common.context;

import java.io.Serializable;

/**
 * @author sunny
 * @className com.sunny.task.common.context.TaskAppUser
 * @date 2017-10-18 15:49
 * @description: TaskAppUserContext
 */
public class TaskAppUserContext implements Serializable {
    private static final long serialVersionUID = -3161739774742781590L;

    private TaskAppUserContext() {
        super();
    }

    /**
     * 用户id
     */
    static Long taskUserId;
    /**
     * 用户唯一id
     */
    static String taskUserUNQId;

    public static Long getTaskUserId() {
        return taskUserId == null ? 0L : taskUserId;
    }

    public static String getTaskUserUNQId() {
        return taskUserUNQId == null ? "" : taskUserUNQId;
    }

    public static void setTaskUserId(Long taskUserId) {
        TaskAppUserContext.taskUserId = taskUserId;
    }

    public static void setTaskUserUNQId(String taskUserUNQId) {
        TaskAppUserContext.taskUserUNQId = taskUserUNQId;
    }
}
