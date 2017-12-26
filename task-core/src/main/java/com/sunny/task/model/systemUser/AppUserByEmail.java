package com.sunny.task.model.systemUser;

import com.sunny.task.core.common.model.BaseModel;

public class AppUserByEmail extends BaseModel<String> {
    private static final long serialVersionUID = -8949234806791508675L;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

}
