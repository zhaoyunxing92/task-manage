package com.sunny.task.common.base;

/**
 * @author sunny
 * @className com.sunny.bugmanage.common.enums.ResultEnum
 * @date 2017-06-06 14:25
 * @description:
 */
public enum ResultEnum {
    /**
     * 成功
     */
    SUCCESS(0, "成功!"),

    /**
     * 注册成功
     */
    ADD_APP_USER_SUCCESS(0, "注册成功!"),

    /**
     * 查询用户异常 by account
     */
    SELECT_APP_USER_BY_ACCOUNT_REEOR(10000, "查询用户异常"),
    /**
     * 添加APP_USER_BY_ACCOUNT异常
     */
    ADD_APP_USER_BY_ACCOUNT_ERROR(10001, "创建账号异常"),
    /**
     * 账号已经存在
     */
    ADD_APP_USER_BY_ACCOUNT_EXIST_ACCOUNT(10002, "账号已经存在"),
    /**
     * 查询用户异常
     */
    SELECT_APP_USER_BY_EMAIL_ERROR(10003, "查询用户异常"),
    /**
     * 邮箱已经存在
     */
    ADD_APP_USER_BY_EMAIL_EXIST_EMAIL(10004, "邮箱已经存在"),
    /**
     * 创建账号异常
     */
    ADD_APP_USER_BY_EMAIL_ERROR(10005, "创建账号异常"),
    /**
     * 查询用户异常
     */
    SELECT_APP_USER_BY_MOBILE_ERROR(10006, "查询用户异常"),
    /**
     * 手机号已经存在
     */
    ADD_APP_USER_BY_MOBILE_EXIST_MOBILE(10007, "手机号已经存在"),
    /**
     * 创建账号异常
     */
    ADD_APP_USER_BY_MOBILE_ERROR(10008, "创建账号异常"),
    /**
     * 添加用户扩展异常
     */
    ADD_APP_USER_EXTEND_ERROR(10009, "添加用户扩展异常"),
    /**
     * 创建用户异常
     */
    ADD_APP_USER_ERROR(10010, "创建用户异常"),
    /**
     * 账号不存在
     */
    USER_NAME_NOT_EXIST(1, "账号不存在"),
    /**
     * 账号不存在
     */
    POSSWORD_ERROR(2, "密码错误"),
    /**
     * 注册用户异常
     */
    INSERT_APP_USER_ERROR(3, "注册用户异常"),
    /**
     * 账号存在
     */
    USER_NAME_EXIST(4, "账号已经存在"),
    /**
     * 权限不足，请联系管理员
     */
    PERMISSION_DENIED(5, "权限不足，请联系管理员"),
    /**
     * 参数异常
     */
    PARAMETER_ERROR(100, "参数异常!"),
    /**
     * 邮箱格式异常
     */
    EMAIL_FORMAT_ERROR(100, "邮箱格式异常"),
    /**
     * 手机格式异常
     */
    MOBILE_FORMAT_ERROR(100, "手机格式异常"),

    /**
     * 组织名称存在
     */
    ORG_NAME_EXIST(200, "组织名称存在"),
    /**
     * 组织名称不存在
     */
    ORG_NAME_NOT_EXIST(201, "组织名称不存在"),
    /**
     * 组织成员已经添加
     */
    ORG_USER_EXIST(202, "成员已经添加"),
    /**
     * 组织成员人员达到上限
     */
    ORG_USER_EXCEED_LIMIT(202, "组织成员人员达到上限"),
    /**
     * 组织项目个数达到上限
     */
    ORG_PRO_EXCEED_LIMIT(203, "组织项目个数达到上限"),
    /**
     * 项目成员达到上限
     */
    PRO_USER_EXCEED_LIMIT(300, "项目成员达到上限");
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
