package com.sunny.task.org.model;

import com.sunny.task.common.base.BaseModel;

public class OrganizationChatUser extends BaseModel<Long> {
    private static final long serialVersionUID = 5708935860551922438L;
    private String orgId;

    private String name;

    private String userId;

    private String chatId;

    private Boolean manager;

    private Byte status;

    private Byte addWay;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId == null ? null : chatId.trim();
    }

    public Boolean getManager() {
        return manager;
    }

    public void setManager(Boolean manager) {
        this.manager = manager;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getAddWay() {
        return addWay;
    }

    public void setAddWay(Byte addWay) {
        this.addWay = addWay;
    }

}
