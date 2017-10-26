package com.sunny.task.org.model;

import com.sunny.task.common.base.BaseModel;

public class OrganizationResource extends BaseModel<Long> {
    private static final long serialVersionUID = -7044103689952414837L;
    private String orgId;
    private String corpName;
    private String corpId;
    private String corpSecret;
    private Byte source;
    private String sourceName;
    private String ssoSecret;
    private String permanentCode;
    private Boolean isPrimary;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName == null ? null : corpName.trim();
    }

    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId == null ? null : corpId.trim();
    }

    public String getCorpSecret() {
        return corpSecret;
    }

    public void setCorpSecret(String corpSecret) {
        this.corpSecret = corpSecret == null ? null : corpSecret.trim();
    }

    public Byte getSource() {
        return source;
    }

    public void setSource(Byte source) {
        this.source = source;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName == null ? null : sourceName.trim();
    }

    public String getSsoSecret() {
        return ssoSecret;
    }

    public void setSsoSecret(String ssoSecret) {
        this.ssoSecret = ssoSecret == null ? null : ssoSecret.trim();
    }

    public String getPermanentCode() {
        return permanentCode;
    }

    public void setPermanentCode(String permanentCode) {
        this.permanentCode = permanentCode == null ? null : permanentCode.trim();
    }

    public Boolean getIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(Boolean isPrimary) {
        this.isPrimary = isPrimary;
    }
    
}
