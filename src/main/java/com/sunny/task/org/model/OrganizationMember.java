package com.sunny.task.org.model;

import com.sunny.task.common.base.BaseModel;

public class OrganizationMember extends BaseModel<Long> {

    private Long orgId;

    private Long userId;

    private String nickName;

    private String position;

    private Boolean manager;

    private String remark;

    private Byte status;

    private Boolean hideEmail;

    private Boolean hideMobile;

    private Boolean rejectTask;

    private Boolean rejectEmailMsg;

    private Boolean hideAll;


    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public Boolean getManager() {
        return manager;
    }

    public void setManager(Boolean manager) {
        this.manager = manager;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Boolean getHideEmail() {
        return hideEmail;
    }

    public void setHideEmail(Boolean hideEmail) {
        this.hideEmail = hideEmail;
    }

    public Boolean getHideMobile() {
        return hideMobile;
    }

    public void setHideMobile(Boolean hideMobile) {
        this.hideMobile = hideMobile;
    }

    public Boolean getRejectTask() {
        return rejectTask;
    }

    public void setRejectTask(Boolean rejectTask) {
        this.rejectTask = rejectTask;
    }

    public Boolean getRejectEmailMsg() {
        return rejectEmailMsg;
    }

    public void setRejectEmailMsg(Boolean rejectEmailMsg) {
        this.rejectEmailMsg = rejectEmailMsg;
    }

    public Boolean getHideAll() {
        return hideAll;
    }

    public void setHideAll(Boolean hideAll) {
        this.hideAll = hideAll;
    }

}
