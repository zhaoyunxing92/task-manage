package com.sunny.task.controller.project.form;

import com.sunny.task.core.common.form.BaseForm;
import com.sunny.task.core.common.valid.InsertGroup;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @author sunny
 * @className com.sunny.task.controller.project.form.ProjectVsersion
 * @date 2018-01-05 14:10
 * @description: 项目版本id
 */
public class ProjectVsersionForm extends BaseForm {
    private static final long serialVersionUID = -5923344182363447269L;
    /**
     * 项目id
     */
    @NotNull(message = "字段 [项目] 必填", groups = {InsertGroup.class})
    @NotBlank(message = "请输入项目名称", groups = {InsertGroup.class})
    private String proId;
    /**
     * 项目版本名称 (15字段)
     */
    @NotNull(message = "字段 [名称] 必填", groups = {InsertGroup.class})
    @NotBlank(message = "请输入项目版本名称", groups = {InsertGroup.class})
    @Length(min = 1, max = 15, message = "项目版本名称长度在{min}~{max}字符之间", groups = {InsertGroup.class})
    private String name;
    /**
     * 项目版本简介（500字段）
     */
    @Length(min = 1, max = 500, message = "项目版本简介长度在{min}~{max}字符之间", groups = {InsertGroup.class})
    private String intro;

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

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
}
