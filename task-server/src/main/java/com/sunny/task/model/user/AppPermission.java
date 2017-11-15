package com.sunny.task.model.user;


import com.sunny.task.model.BaseModel;

import java.util.Date;

public class AppPermission extends BaseModel<Long> {

    private static final long serialVersionUID = -7256062954110676648L;
    private String uniqueId;

    private String name;

    private String url;

    private String permissionDesc;

    private Byte status;

    private Boolean system;

    private Long creator;

    private Date creationDate;

    private Long modifier;

    private Date modificationDate;
    
    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId == null ? null : uniqueId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getPermissionDesc() {
        return permissionDesc;
    }

    public void setPermissionDesc(String permissionDesc) {
        this.permissionDesc = permissionDesc == null ? null : permissionDesc.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Boolean getSystem() {
        return system;
    }

    public void setSystem(Boolean system) {
        this.system = system;
    }

}
