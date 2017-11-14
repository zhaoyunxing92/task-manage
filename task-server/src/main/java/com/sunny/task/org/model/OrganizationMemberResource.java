package com.sunny.task.org.model;


import com.sunny.task.model.BaseModel;

public class OrganizationMemberResource extends BaseModel<Long> {
    private static final long serialVersionUID = 6357599978060349283L;
    private String orgId;
    private String userId;
    private String corpId;
    private String corpUserId;
    private String corpUserOpenid;
    private String corpUserName;
    private String corpUserEmail;
    private String corpUserMobile;
    private String corpUserOrgemail;
    private String corpUserAvatar;
    
    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId == null ? null : corpId.trim();
    }

    public String getCorpUserId() {
        return corpUserId;
    }

    public void setCorpUserId(String corpUserId) {
        this.corpUserId = corpUserId == null ? null : corpUserId.trim();
    }

    public String getCorpUserOpenid() {
        return corpUserOpenid;
    }

    public void setCorpUserOpenid(String corpUserOpenid) {
        this.corpUserOpenid = corpUserOpenid == null ? null : corpUserOpenid.trim();
    }

    public String getCorpUserName() {
        return corpUserName;
    }

    public void setCorpUserName(String corpUserName) {
        this.corpUserName = corpUserName == null ? null : corpUserName.trim();
    }

    public String getCorpUserEmail() {
        return corpUserEmail;
    }

    public void setCorpUserEmail(String corpUserEmail) {
        this.corpUserEmail = corpUserEmail == null ? null : corpUserEmail.trim();
    }

    public String getCorpUserMobile() {
        return corpUserMobile;
    }

    public void setCorpUserMobile(String corpUserMobile) {
        this.corpUserMobile = corpUserMobile == null ? null : corpUserMobile.trim();
    }

    public String getCorpUserOrgemail() {
        return corpUserOrgemail;
    }

    public void setCorpUserOrgemail(String corpUserOrgemail) {
        this.corpUserOrgemail = corpUserOrgemail == null ? null : corpUserOrgemail.trim();
    }

    public String getCorpUserAvatar() {
        return corpUserAvatar;
    }

    public void setCorpUserAvatar(String corpUserAvatar) {
        this.corpUserAvatar = corpUserAvatar == null ? null : corpUserAvatar.trim();
    }
}
