package com.sunny.task.model.org;


import com.sunny.task.model.BaseModel;

public class OrganizationApp extends BaseModel<Long> {
    private static final long serialVersionUID = 1417039304954361862L;

    private String uniqueId;

    private String orgId;

    private String appId;

    private String appName;

    private String appDesc;

    private String appHomeUrl;

    private String appPcHomeUrl;

    private String iconFileId;

    private Boolean isUse;

    private Byte status;

    private Boolean isPrimary;

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId == null ? null : uniqueId.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public String getAppDesc() {
        return appDesc;
    }

    public void setAppDesc(String appDesc) {
        this.appDesc = appDesc == null ? null : appDesc.trim();
    }

    public String getAppHomeUrl() {
        return appHomeUrl;
    }

    public void setAppHomeUrl(String appHomeUrl) {
        this.appHomeUrl = appHomeUrl == null ? null : appHomeUrl.trim();
    }

    public String getAppPcHomeUrl() {
        return appPcHomeUrl;
    }

    public void setAppPcHomeUrl(String appPcHomeUrl) {
        this.appPcHomeUrl = appPcHomeUrl == null ? null : appPcHomeUrl.trim();
    }

    public String getIconFileId() {
        return iconFileId;
    }

    public void setIconFileId(String iconFileId) {
        this.iconFileId = iconFileId == null ? null : iconFileId.trim();
    }

    public Boolean getIsUse() {
        return isUse;
    }

    public void setIsUse(Boolean isUse) {
        this.isUse = isUse;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Boolean getIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(Boolean isPrimary) {
        this.isPrimary = isPrimary;
    }

}
