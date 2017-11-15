package com.sunny.task.model.user.vo;

import com.sunny.task.model.user.AppUser;

import java.util.Date;

/**
 * @author sunny
 * @className com.sunny.task.model.user.vo.AppUserVo
 * @date 2017-10-16 10:07
 * @description:
 */
public class AppUserVo extends AppUser {
    private static final long serialVersionUID = 2114273821991151649L;

    /**
     * 头像
     */
    private String avatar;
    /**
     * 性别
     */
    private Byte sex;
    /**
     * 生日
     */
    private Date birthdate;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 城市
     */
    private String city;
    /**
     * 简介
     */
    private String bio;
    /**
     * 地址
     */
    private String address;
    /**
     * 个人博客
     */
    private String blogUrl;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

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

    public String getBlogUrl() {
        return blogUrl;
    }

    public void setBlogUrl(String blogUrl) {
        this.blogUrl = blogUrl;
    }
}
