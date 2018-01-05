package com.sunny.task.controller.project.form;

import com.sunny.task.core.common.form.BaseForm;
import com.sunny.task.core.common.valid.InsertGroup;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author sunny
 * @className com.sunny.task.controller.project.form.ProjectUserForm
 * @date 2017-12-28 13:46
 * @description:
 */
public class ProjectUserForm extends BaseForm {
    private static final long serialVersionUID = 2210860086371950841L;

//    /**
//     * 组织id
//     */
//    @NotBlank(message = "请选择组织", groups = {InsertGroup.class})
//    @NotNull(message = "字段 [组织] 必填", groups = {InsertGroup.class})
//    private String orgId;

    /**
     * 项目id
     */
    @NotBlank(message = "请选择项目", groups = {InsertGroup.class})
    @NotNull(message = "字段 [项目] 必填", groups = {InsertGroup.class})
    private String proId;
    /**
     * 项目成员
     */
    @NotNull(message = "字段 [用户] 必填", groups = {InsertGroup.class})
    @Size(message = "至少选择一个用户", min = 1, groups = {InsertGroup.class})
    private String[] userIds;

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String[] getUserIds() {
        return userIds;
    }

    public void setUserIds(String[] userIds) {
        this.userIds = userIds;
    }
}
