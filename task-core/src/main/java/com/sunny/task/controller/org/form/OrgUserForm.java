package com.sunny.task.controller.org.form;

import com.sunny.task.core.common.form.BaseForm;
import com.sunny.task.core.common.valid.InsertGroup;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @author sunny
 * @className com.sunny.task.controller.org.form.OrgUserForm
 * @date 2017-12-27 23:16
 * @description:
 */
public class OrgUserForm extends BaseForm {
    private static final long serialVersionUID = 3062091633114192858L;
    /**
     * 组织id
     */
    @NotBlank(message = "请选择组织", groups = {InsertGroup.class})
    @NotNull(message = "字段 [组织] 必填", groups = {InsertGroup.class})
    private String orgId;
    /**
     * 用户id
     */
    @NotBlank(message = "请选择用户", groups = {InsertGroup.class})
    @NotNull(message = "字段 [用户] 必填", groups = {InsertGroup.class})
    private String userId;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
