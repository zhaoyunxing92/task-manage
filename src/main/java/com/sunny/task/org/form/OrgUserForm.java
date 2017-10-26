package com.sunny.task.org.form;

import com.sunny.task.common.base.BaseForm;
import com.sunny.task.common.valid.InsertGroup;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * @author sunny
 * @className com.sunny.task.org.form.OrgUserForm
 * @date 2017-10-20 10:17
 * @description:
 */
public class OrgUserForm extends BaseForm<Long> {
    private static final long serialVersionUID = 6304204742994794757L;
    /**
     * 组织id
     */
    @NotNull(message = "请输入组织id", groups = {InsertGroup.class})
    private String orgId;
    /**
     * 用户id
     */
    @NotNull(message = "请输入组织成员id", groups = {InsertGroup.class})
    private String userId;
    /**
     * 昵称
     */
    @Max(value = 10, message = "昵称应该在{min}~{max}个字符之间", groups = {InsertGroup.class})
    private String nickName;
    /**
     * 职位信息
     */
    @Max(value = 30, message = "职位信息最多{value}个字符", groups = {InsertGroup.class})
    private String position;
    /**
     * 备注
     */
    @Max(value = 50, message = "备注最多{value}个字符", groups = {InsertGroup.class})
    private String remark;
    /**
     * 默认添加
     */
    private Boolean defaultAdd;


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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getDefaultAdd() {
        return defaultAdd;
    }

    public void setDefaultAdd(Boolean defaultAdd) {
        this.defaultAdd = defaultAdd;
    }
}
