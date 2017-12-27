package com.sunny.task.model.org;

import com.sunny.task.core.common.model.BaseModel;

public class OrganizationMemberResource extends BaseModel<String> {
    private static final long serialVersionUID = 3394444887257624826L;
    private String orgUserUId;

    private String corpUserId;

    private String corpUserOpenid;

    public String getOrgUserUId() {
        return orgUserUId;
    }

    public void setOrgUserUId(String orgUserUId) {
        this.orgUserUId = orgUserUId == null ? null : orgUserUId.trim();
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
