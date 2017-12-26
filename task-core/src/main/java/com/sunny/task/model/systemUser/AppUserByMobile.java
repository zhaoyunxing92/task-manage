package com.sunny.task.model.systemUser;

import com.sunny.task.core.common.model.BaseModel;

public class AppUserByMobile extends BaseModel<String> {
    private static final long serialVersionUID = -572299821174956773L;
    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

}
