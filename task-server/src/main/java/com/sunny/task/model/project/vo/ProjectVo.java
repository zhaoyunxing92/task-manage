package com.sunny.task.model.project.vo;

import com.sunny.task.model.project.Project;

/**
 * @author sunny
 * @className com.sunny.task.model.project.vo.ProjectVo
 * @date 2017-11-15 11:29
 * @description:
 */
public class ProjectVo extends Project {
    private static final long serialVersionUID = -4696324481145809117L;
    /**
     * 项目头像
     */
    private String iconUrl;
    /**
     * 成员个数
     */
    private Integer userCount;
    
    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }
}
