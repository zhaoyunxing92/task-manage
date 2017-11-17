package com.sunny.task.model.project;

import com.sunny.task.model.BaseModel;

public class ProjectVersion extends BaseModel<Long> {
    private static final long serialVersionUID = -2011219527496597000L;
    private String proId;
    private String name;
    private String intro;

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId == null ? null : proId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

}
