package com.sunny.task.form.pro;

import com.sunny.task.form.BaseForm;
import com.sunny.task.valid.InsertGroup;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author sunny
 * @className com.sunny.task.form.pro.ProUserForm
 * @date 2017-11-15 17:48
 * @description:
 */
public class ProUserForm extends BaseForm<Long> {
    private static final long serialVersionUID = 2006600483227763742L;
    // private String orgId;
    @NotBlank(groups = {InsertGroup.class}, message = "请选择项目")
    private String proId;
    @NotNull(groups = {InsertGroup.class},message = "请选择添加成员")
    @Size(min = 1,groups = {InsertGroup.class},message = "至少选择一个加成员")
    private List<String> users;

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }
}
