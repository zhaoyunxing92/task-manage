package com.sunny.task.model.systemUser;

import com.sunny.task.core.common.model.BaseModel;

public class AppUserByAccount extends BaseModel<String> {
    private static final long serialVersionUID = -4688920974430214083L;
    private String account;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }
    
}
