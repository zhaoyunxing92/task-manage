package com.sunny.task.form.pro;

import com.sunny.task.form.BaseForm;
import com.sunny.task.valid.DeleteGroup;
import com.sunny.task.valid.InsertGroup;
import com.sunny.task.valid.UpdateGroup;
import org.hibernate.validator.constraints.Length;
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
    @NotBlank(groups = {InsertGroup.class, DeleteGroup.class, UpdateGroup.class}, message = "请选择项目")
    private String proId;
    /*用户id*/
    @NotBlank(groups = {InsertGroup.class, DeleteGroup.class, UpdateGroup.class}, message = "请选择成员")
    private String userId;
    /*成员姓名*/
    @Length(max = 10, groups = {UpdateGroup.class}, message = "姓名最多{max}个字符")
    private String name;

    /*备注*/
    @Length(max = 50, groups = {UpdateGroup.class}, message = "备注最多{max}个字符")
    private String remark;
    @NotNull(groups = {InsertGroup.class, DeleteGroup.class}, message = "请选择添加成员")
    @Size(min = 1, groups = {InsertGroup.class, DeleteGroup.class}, message = "至少选择一个加成员")
    private List<String> userIds;

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public List<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<String> userIds) {
        this.userIds = userIds;
    }
}
