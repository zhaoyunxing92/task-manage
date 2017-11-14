package com.sunny.task.exception;


import com.sunny.task.result.ResultEnum;

/**
 * @author sunny
 * @className com.sunny.task.core.exception.TaskUserAuthException
 * @date 2017-10-17 17:29
 * @description:
 */
public class TaskUserAuthException extends TaskException {
    private static final long serialVersionUID = -1182078597578630183L;

    public TaskUserAuthException(ResultEnum resultEnum) {
        super(resultEnum);
    }

}
