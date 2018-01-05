package com.sunny.task.model.project;

import com.sunny.task.core.common.model.BaseModel;

public class ProjectUser extends BaseModel<String> {
    
    private static final long serialVersionUID = -8602107934368516058L;
    private String orgId;

    private String proId;

    private String userId;

    private Byte status;

    private Boolean manager;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId == null ? null : proId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Boolean getManager() {
        return manager;
    }

    public void setManager(Boolean manager) {
        this.manager = manager;
    }
    
}
