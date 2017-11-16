package com.sunny.task.result;

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
    LOGIN_SUCCESS(0, "登录成功"),
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
     * 注册账号可以
     */
    REG_APP_USER_ACCOUNT_NOT_EXIST(0, "ok"),
    /**
     * 创建用户异常
     */
    ADD_APP_USER_ERROR(10010, "创建用户异常"),
    /**
     * 注册账号已经存在
     */
    REG_APP_USER_ACCOUNT_EXIST(10011, "账号已经存在"),
    /**
     * 账号不存在
     */
    LOGIN_APP_USLOGINER_ACCOUNT_NOT_EXIST(10012, "账号不存在"),
    /**
     * 根据用户id查询用户异常
     */
    SELECT_APP_USER_BY_USERID_REEOR(10013, "查询用户异常"),
    /**
     * 账号锁定
     */
    APP_USER_LOCK_ERROR(10014, "账号锁定"),
    /**
     * 账号未激活
     */
    APP_USER_NOT_ACTIVATE_ERROR(10015, "账号未激活"),
    /**
     * 密码错误
     */
    APP_USER_PASSWORD_ERROR(10016, "密码错误"),
    /**
     * 邮箱格式不正确
     */
    EMAIL_FORMAT_ERROR(10017, "邮箱格式不正确"),
    /**
     * 手机格式不正确
     */
    MOBILE_FORMAT_ERROR(10018, "手机格式不正确"),
    /*=======================================组织模块========================================*/
    /**
     * 查询组织异常
     */
    TASK_ORG_SELECT_ERROR(10020, "查询组织异常"),
    /**
     * 查询组织异常
     */
    TASK_ORG_SELECT_NOT_EXIST_ERROR(10021, "组织不存在"),
    /**
     * 组织成员超限
     */
    TASK_ORG_USER_OVERFLOW_ERROR(10022, "组织成员超限"),
    /**
     * 创建组织异常
     */
    TASK_INSERT_ORG_ERROR(10023, "创建组织异常"),

     /*=======================================项目模块========================================*/
    /**
     * 添加项目异常
     */
    TASK_INSERT_PRO_ERROR(10200, "添加项目异常"),

    /**
     * 添加项目成员异常
     */
    TASK_INSERT_PRO_USER_ERROR(10201, "添加项目成员异常"),
    /**
     *  项目成员超限
     */
    TASK_ORG_PRO_USER_OVERFLOW(10202, "项目成员超限"),

    /*===================================== token ===============================================*/
    /**
     * 未知异常，请联系管理员
     */
    TASK_TOKEN_UNKNOWN_ERROR(1000, "未知异常，请联系管理员"),

    /**
     * token过时
     */
    TASK_TOKEN_EXPIRED_ERROR(1001, "token失效"),

    /**
     * 不支持的格式
     */
    TASK_TOKEN_UNSUPPORTED_ERROR(1002, "token不合法"),

    /**
     * token不合法
     */
    TASK_TOKEN_MALFORME_ERROR(1003, "token不合法"),

    /**
     * token签名异常
     */
    TASK_TOKEN_SIGNATURE_ERROR(1004, "token不合法"),

    /**
     * token不合法
     */
    TASK_TOKEN_ILLEGAL_ARGUMENT_ERROR(1005, "token不合法"),
    /**
     * token登录拒绝
     */
    TASK_TOKEN_LOGIN_REJECT_ERROR(1006, "请先登录"),

    /*============================== 系统级别 =================================================*/


    /**
     * 参数异常
     */
    PARAMETER_ERROR(2000, "参数错误！"),
    /**
     * 唯一键重复
     */
    DUPLICATE_KEY_EXCEPTION(2001,"重复数据：");

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
