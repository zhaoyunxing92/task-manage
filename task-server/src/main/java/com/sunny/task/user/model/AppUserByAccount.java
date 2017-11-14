package com.sunny.task.user.model;

import java.io.Serializable;

public class AppUserByAccount implements Serializable {
    private static final long serialVersionUID = -4733096119852940950L;
    private String account;
    
    private Long userId;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public AppUserByAccount() {
        super();
    }

    public AppUserByAccount(String account, Long userId) {
        this.account = account;
        this.userId = userId;
    }
}
