package com.sunny.task.controller.project.form;

import com.sunny.task.core.common.form.BaseForm;
import com.sunny.task.core.common.valid.InsertGroup;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @author sunny
 * @className com.sunny.task.controller.project.form.ProjectForm
 * @date 2017-12-28 13:13
 * @description:
 */
public class ProjectForm extends BaseForm {
    private static final long serialVersionUID = -7740986332152746059L;

    /**
     * 组织id
     */
    @NotBlank(message = "请选择组织", groups = {InsertGroup.class})
    @NotNull(message = "字段 [组织] 必填", groups = {InsertGroup.class})
    private String orgId;
    /**
     * 项目管理员
     */
    @NotBlank(message = "请选择项目管理员", groups = {InsertGroup.class})
    @NotNull(message = "字段 [用户] 必填", groups = {InsertGroup.class})
    private String ownerId;
    /**
     * 项目名称
     */
    @NotNull(message = "字段 [名称] 必填", groups = {InsertGroup.class})
    @NotBlank(message = "请输入项目名称", groups = {InsertGroup.class})
    @Length(min = 1, max = 30, message = "团队项目长度在{min}~{max}字符之间", groups = {InsertGroup.class})
    private String name;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
