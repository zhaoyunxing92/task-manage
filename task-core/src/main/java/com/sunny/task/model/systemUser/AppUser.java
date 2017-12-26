package com.sunny.task.model.systemUser;

import com.sunny.task.core.common.model.BaseModel;

/**
 * @author sunny
 * @date 2017.12.25 22:59
 * @description:
 */
public class AppUser extends BaseModel<String> {

    private static final long serialVersionUID = 656392810641075024L;

    private String id;

    private String account;

    private String email;

    private String mobile;

    private String pin;

    private String iconFileId;

    private String openId;

    private String password1;

    private String password2;

    private String nickName;

    private Integer status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin == null ? null : pin.trim();
    }

    public String getIconFileId() {
        return iconFileId;
    }

    public void setIconFileId(String iconFileId) {
        this.iconFileId = iconFileId == null ? null : iconFileId.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1 == null ? null : password1.trim();
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2 == null ? null : password2.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
