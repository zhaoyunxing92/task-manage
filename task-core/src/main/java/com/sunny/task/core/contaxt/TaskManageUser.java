package com.sunny.task.core.contaxt;

import java.io.Serializable;

/**
 * @author sunny
 * @className com.sunny.task.core.common.base.TaskManageUser
 * @date 2017-10-17 15:03
 * @description:
 */
public class TaskManageUser implements Serializable {
    private static final long serialVersionUID = -7945319474936493809L;

    private Long id;
    /**
     * 用户唯一id
     */
    private String uid;
    /**
     * 性别
     */
    private Byte sex;

    /**
     * 头像
     */
    private String avatar;
    /**
     * 账号
     */
    private String account;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private String mobile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
