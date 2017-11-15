package com.sunny.task.model.user;


import com.sunny.task.model.BaseModel;

public class AppUser extends BaseModel<Long> {

    private static final long serialVersionUID = -7797677924926964137L;
    private String uniqueId;

    private String account;

    private String email;

    private String mobile;

    private String pin;

    private Long iconFileId;

    private String openId;

    private String password1;

    private String password2;

    private String nickName;

    private Integer status;

    private Integer creatorOrgLimit;

    private Integer addOrgLimit;

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId == null ? null : uniqueId.trim();
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

    public Long getIconFileId() {
        return iconFileId;
    }

    public void setIconFileId(Long iconFileId) {
        this.iconFileId = iconFileId;
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

    public Integer getCreatorOrgLimit() {
        return creatorOrgLimit;
    }

    public void setCreatorOrgLimit(Integer creatorOrgLimit) {
        this.creatorOrgLimit = creatorOrgLimit;
    }

    public Integer getAddOrgLimit() {
        return addOrgLimit;
    }

    public void setAddOrgLimit(Integer addOrgLimit) {
        this.addOrgLimit = addOrgLimit;
    }
    
}
