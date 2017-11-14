package com.sunny.task.exception;


import com.sunny.task.result.ResultEnum;

/**
 * @author sunny
 * @className com.sunny.task.core.exception.TaskException
 * @date 2017-10-16 10:24
 * @description:
 */
public class TaskException extends RuntimeException {
    private static final long serialVersionUID = 4218386660227272072L;
    private Integer code;

    public TaskException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public TaskException(String msg) {
        super(msg);
    }

    public TaskException(ResultEnum resultEnum, Throwable cause) {

        super(cause.getMessage() + resultEnum.getMsg(), cause);
        this.code = resultEnum.getCode();
    }

    public TaskException(Integer code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public TaskException(ResultEnum resultEnum, Object obj) {
        super(resultEnum.getMsg() + obj);
        this.code = resultEnum.getCode();
    }

    public TaskException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
