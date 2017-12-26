package com.sunny.task.core.common.context;

import java.io.Serializable;

/**
 * @author sunny
 * @className com.sunny.task.core.common.context.TaskAppUser
 * @date 2017-12-26 16:32
 * @description:
 */
public class TaskAppUser implements Serializable {
    private static final long serialVersionUID = -300501928735175883L;
    /**
     * 用户唯一id
     */
    private String uId;
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

    /**
     * 昵称
     */
    private String nickName;

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
