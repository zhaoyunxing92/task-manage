package com.sunny.task.form.pro;

import com.sunny.task.form.BaseForm;
import com.sunny.task.valid.InsertGroup;
import com.sunny.task.valid.UpdateGroup;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author sunny
 * @className com.sunny.task.form.pro.ProVsersionForm
 * @date 2017-11-17 10:46
 * @description:
 */
public class ProVsersionForm extends BaseForm<Long> {
    private static final long serialVersionUID = 6679582838238133654L;
    @NotBlank(groups = {InsertGroup.class}, message = "请选择项目")
    private String proId;
    @NotBlank(groups = {InsertGroup.class}, message = "请输入版本名称")
    @Length(max = 10, groups = {InsertGroup.class, UpdateGroup.class}, message = "版本名称最多{max}个字符")
    private String name;
    @Length(max = 450, groups = {InsertGroup.class,UpdateGroup.class}, message = "版本简介最多{max}个字符")
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
