package com.sunny.task.org.model;

import com.sunny.task.common.base.BaseModel;

public class OrganizationApp extends BaseModel<Long> {

    private String uniqueId;

    private Long orgId;

    private Long appId;

    private String appName;

    private String appDesc;

    private String appHomeUrl;

    private String appPcHomeUrl;

    private Long iconFileId;

    private Boolean isUse;

    private Byte status;

    private Boolean isPrimary;

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId == null ? null : uniqueId.trim();
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
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

    public Long getIconFileId() {
        return iconFileId;
    }

    public void setIconFileId(Long iconFileId) {
        this.iconFileId = iconFileId;
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
