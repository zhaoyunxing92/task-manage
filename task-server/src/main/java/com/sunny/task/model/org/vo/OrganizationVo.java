package com.sunny.task.model.org.vo;

import com.sunny.task.model.org.Organization;

/**
 * @author sunny
 * @className com.sunny.task.model.org.vo.OrganizationVo
 * @date 2017-10-19 16:20
 * @description:
 */
public class OrganizationVo extends Organization {
    private static final long serialVersionUID = 5442409641295438134L;
    /**
     * 组织人员总数
     */
    private int userCount;
    /**
     * 项目个数
     */
    private int proCount;

    private String iconUrl;
    /**
     * 是否管理员
     */
    private Boolean isAdmin;

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    public int getProCount() {
        return proCount;
    }

    public void setProCount(int proCount) {
        this.proCount = proCount;
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
}
