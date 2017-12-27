package com.sunny.task.model.org;

import com.sunny.task.core.common.model.BaseModel;

public class OrganizationMemberResource extends BaseModel {
    private String orgUId;

    private String corpUserId;

    private String corpUserOpenid;

    public String getOrgUId() {
        return orgUId;
    }

    public void setOrgUId(String orgUId) {
        this.orgUId = orgUId == null ? null : orgUId.trim();
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
}