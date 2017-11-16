package com.sunny.task.form.pro;

import com.sunny.task.form.BaseForm;
import com.sunny.task.valid.InsertGroup;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author sunny
 * @className com.sunny.task.form.pro.ProForm
 * @date 2017-11-15 11:19
 * @description:
 */
public class ProForm extends BaseForm<String> {

    private static final long serialVersionUID = 6241448254703170963L;

    // @NotNull(groups = {InsertGroup.class}, message = "[orgId]不能为空")
    @NotBlank(groups = {InsertGroup.class}, message = "请选择组织")
    private String orgId;

    // @NotNull(groups = {InsertGroup.class}, message = "[name]不能为空")
    @NotBlank(groups = {InsertGroup.class}, message = "请输入项目名称")
    @Length(max = 15, message = "项目名称最长{max}个字符")
    private String name;

    //@NotNull(groups = {InsertGroup.class}, message = "[ownerId]不能为空")
    @NotBlank(groups = {InsertGroup.class}, message = "请选择项目的拥有者")
    private String ownerId;

    @Length(max = 80, message = "项目简介最长{max}个字符")
    private String intro;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
