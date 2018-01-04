package com.sunny.task.model.org.vo;

import com.sunny.task.model.org.Organization;

/**
 * @author sunny
 * @className com.sunny.task.model.org.vo.OrganizationVo
 * @date 2017-12-27 22:32
 * @description:
 */
public class OrganizationVo extends Organization {
    private static final long serialVersionUID = -6520011746139240964L;

    /**
     * 组织人员总数
     */
    private int userCount;
    /**
     * 组织成员
     */
    private String userIdList;

    
    private String iconUrl;
    /**
     * 是否管理员
     */
    private Boolean isAdmin;
    /**
     * 团队拥有者
     */
    private String owner;

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

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

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
}
