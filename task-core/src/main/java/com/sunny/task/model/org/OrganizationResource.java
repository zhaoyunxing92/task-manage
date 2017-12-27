package com.sunny.task.model.org;

import com.sunny.task.core.common.model.BaseModel;

public class OrganizationResource extends BaseModel<String> {
    private static final long serialVersionUID = -4366565934293888591L;
    private String sourceId;

    private String orgId;

    private Byte sourceType;

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId == null ? null : sourceId.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public Byte getSourceType() {
        return sourceType;
    }

    public void setSourceType(Byte sourceType) {
        this.sourceType = sourceType;
    }

}
