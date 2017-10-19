package com.sunny.task.org.model;

import com.sunny.task.common.base.BaseModel;

import java.util.Date;

public class OrganizationChat extends BaseModel<Long> {

    private Long orgId;

    private String projectId;

    private Long ownerId;

    private String chatId;

    private Long iconFileId;

    private String chatName;

    private String chatDesc;

    private Byte chatType;

    private Boolean autoAdd;

    private Integer memberLimit;

    private String defaultMsg;

    private Date creationDate;

    private Long modifier;

    private Date modificationDate;


    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId == null ? null : chatId.trim();
    }

    public Long getIconFileId() {
        return iconFileId;
    }

    public void setIconFileId(Long iconFileId) {
        this.iconFileId = iconFileId;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName == null ? null : chatName.trim();
    }

    public String getChatDesc() {
        return chatDesc;
    }

    public void setChatDesc(String chatDesc) {
        this.chatDesc = chatDesc == null ? null : chatDesc.trim();
    }

    public Byte getChatType() {
        return chatType;
    }

    public void setChatType(Byte chatType) {
        this.chatType = chatType;
    }

    public Boolean getAutoAdd() {
        return autoAdd;
    }

    public void setAutoAdd(Boolean autoAdd) {
        this.autoAdd = autoAdd;
    }

    public Integer getMemberLimit() {
        return memberLimit;
    }

    public void setMemberLimit(Integer memberLimit) {
        this.memberLimit = memberLimit;
    }

    public String getDefaultMsg() {
        return defaultMsg;
    }

    public void setDefaultMsg(String defaultMsg) {
        this.defaultMsg = defaultMsg == null ? null : defaultMsg.trim();
    }

}
