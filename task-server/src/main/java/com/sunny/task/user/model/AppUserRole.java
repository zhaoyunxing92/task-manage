package com.sunny.task.user.model;


import com.sunny.task.model.BaseModel;

public class AppUserRole extends BaseModel<Long> {
    private static final long serialVersionUID = 4632871468913507271L;
    private Long userId;

    private Long roleId;

    private Byte status;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

}
