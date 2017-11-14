package com.sunny.task.user.model;

import java.io.Serializable;

public class AppUserByMobile implements Serializable {
    private static final long serialVersionUID = -7020344517015807189L;
    private String mobile;

    private Long userId;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public AppUserByMobile() {
        super();
    }

    public AppUserByMobile(String mobile, Long userId) {
        this.mobile = mobile;
        this.userId = userId;
    }
}
