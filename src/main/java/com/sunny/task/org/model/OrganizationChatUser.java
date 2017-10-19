package com.sunny.task.org.model;

import com.sunny.task.common.base.BaseModel;

import java.util.Date;

public class OrganizationChatUser extends BaseModel<Long> {

    private Long orgId;

    private String name;

    private Long userId;

    private String chatId;

    private Boolean manager;

    private Byte status;

    private Byte addWay;

    private Long creator;

    private Date creationDate;

    private Long modifier;

    private Date modificationDate;


    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
