package com.sunny.task.controller.org.form;

import com.sunny.task.core.common.form.BaseForm;
import com.sunny.task.core.common.valid.InsertGroup;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @author sunny
 * @className com.sunny.task.controller.org.form.OrgForm
 * @date 2017-12-27 15:01
 * @description:
 */
public class OrgForm extends BaseForm {
    private static final long serialVersionUID = -4037799868216262844L;
    /**
     * 组织名称
     */
    @NotNull(message = "字段 [名称] 必填", groups = {InsertGroup.class})
    @NotBlank(message = "请输入团队名称", groups = {InsertGroup.class})
    @Length(min = 1, max = 30, message = "团队名称长度在{min}~{max}字符之间", groups = {InsertGroup.class})
    private String name;
    /**
     * 组织简介
     */
    @NotNull(message = "字段 [简介] 必填", groups = {InsertGroup.class})
    @NotBlank(message = "请输入团队简介", groups = {InsertGroup.class})
    @Length(min = 1, max = 50, message = "团队简介{min}~{max}字符之间", groups = {InsertGroup.class})
    private String intro;
    /**
     * 地址
     */
    @Length(min = 1, max = 500, message = "团队地址{min}~{max}字符之间", groups = {InsertGroup.class})
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
