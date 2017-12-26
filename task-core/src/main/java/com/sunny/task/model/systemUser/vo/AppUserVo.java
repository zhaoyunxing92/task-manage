package com.sunny.task.model.systemUser.vo;

import com.sunny.task.model.systemUser.AppUser;

/**
 * @author sunny
 * @date 2017.12.25 22:59
 * @description:
 */
public class AppUserVo extends AppUser {
    private static final long serialVersionUID = 6897813446316171854L;
    /**
     * 简介
     */
    private String bio;
    /**
     * 地址
     */
    private String address;

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
