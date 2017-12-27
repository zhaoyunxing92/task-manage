package com.sunny.task.model.systemUser;

import com.sunny.task.core.common.model.BaseModel;

public class AppUserMapId extends BaseModel<String> {
    private static final long serialVersionUID = -3854041634622071686L;
    private String mapId;

    public String getMapId() {
        return mapId;
    }

    public void setMapId(String mapId) {
        this.mapId = mapId == null ? null : mapId.trim();
    }
}
