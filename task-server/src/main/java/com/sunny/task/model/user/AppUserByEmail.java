package com.sunny.task.model.user;

import java.io.Serializable;

public class AppUserByEmail implements Serializable {
    private static final long serialVersionUID = 8147611031987962855L;
    private String email;

    private Long userId;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public AppUserByEmail() {
        super();
    }

    public AppUserByEmail(String email, Long userId) {
        this.email = email;
        this.userId = userId;
    }
}
