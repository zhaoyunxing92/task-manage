package com.sunny.task.model.systemUser;

import com.sunny.task.core.common.model.BaseModel;

public class AppUserConfig extends BaseModel<String> {

    private static final long serialVersionUID = -500516371096376906L;
    private Integer creatorOrgLimit;

    private Integer addOrgLimit;

    private String backgroundImage;

    public Integer getCreatorOrgLimit() {
        return creatorOrgLimit;
    }

    public void setCreatorOrgLimit(Integer creatorOrgLimit) {
        this.creatorOrgLimit = creatorOrgLimit;
    }

    public Integer getAddOrgLimit() {
        return addOrgLimit;
    }

    public void setAddOrgLimit(Integer addOrgLimit) {
        this.addOrgLimit = addOrgLimit;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage == null ? null : backgroundImage.trim();
    }
}
