package com.sunny.task.form.form;


import com.sunny.task.form.BaseForm;
import com.sunny.task.valid.InsertGroup;
import com.sunny.task.valid.UpdateGroup;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author sunny
 * @className com.sunny.task.org.form.OrgForm
 * @date 2017-10-19 16:21
 * @description:
 */
public class OrgForm extends BaseForm<Long> {
    private static final long serialVersionUID = -2414512249993296592L;
    /**
     * 团队名称
     */
    @NotBlank(message = "请输入团队名称", groups = {InsertGroup.class})
    @NotNull(message = "字段[name]必填", groups = {InsertGroup.class})
    @Length(min = 3, max = 10, message = "团队名称在{min}-{max}个字符之间", groups = {InsertGroup.class})
    @Pattern(regexp = "^([A-Za-z]|[\\u4E00-\\u9FA5])+$", message = "团队名称只能包含汉字和字母", groups = {InsertGroup.class})
    private String name;
    /**
     * 组织描述
     */
    @Length(max = 450, message = "团队名描述{min}-{max}个字符之间", groups = {UpdateGroup.class})
    private String description;
    /**
     * 简介
     */
    @Length(max = 50, message = "团队名简介{min}-{max}个字符之间", groups = {UpdateGroup.class})
    private String intro;
    /**
     * 地址
     */
    @Length(max = 450, message = "团队地址{min}-{max}个字符之间", groups = {UpdateGroup.class})
    private String address;
    /**
     * 是否公开
     */
    private Boolean open;

    /**
     * 是否自动加入
     */
    private Boolean autoAdd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public Boolean getAutoAdd() {
        return autoAdd;
    }

    public void setAutoAdd(Boolean autoAdd) {
        this.autoAdd = autoAdd;
    }
}
