package com.sunny.task.org.model.vo;

import com.sunny.task.org.model.Organization;

/**
 * @author sunny
 * @className com.sunny.task.org.model.vo.OrganizationVo
 * @date 2017-10-19 16:20
 * @description:
 */
public class OrganizationVo extends Organization {
    private static final long serialVersionUID = 5442409641295438134L;
    /**
     * 组织人员总数
     */
    private int userCount = 0;

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }
}
