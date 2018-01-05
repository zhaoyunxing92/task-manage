package com.sunny.task.model.project;

import com.sunny.task.core.common.model.BaseModel;

public class ProjectVersion extends BaseModel<String> {

    private static final long serialVersionUID = -8431062423144648084L;
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
