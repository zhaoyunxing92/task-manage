package com.sunny.task.model.project.vo;

import com.sunny.task.model.project.Project;

/**
 * @author sunny
 * @className com.sunny.task.model.project.vo.ProjectVo
 * @date 2018-01-05 00:43
 * @description:
 */
public class ProjectVo extends Project {
    private static final long serialVersionUID = -4696324481145809117L;
    /**
     * 是项目理员
     */
    private Boolean isAdmin;
    /**
     * 项目拥有者
     */
    private String owner;
    /**
     * 项目人员总数
     */
    private int userCount;
    /**
     * 项目人成员
     */
    private String userIdList;

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    public String getUserIdList() {
        return userIdList;
    }

    public void setUserIdList(String userIdList) {
        this.userIdList = userIdList;
    }
}
