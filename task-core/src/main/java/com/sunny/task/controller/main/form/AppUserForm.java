package com.sunny.task.controller.main.form;

import com.sunny.task.core.common.form.BaseForm;
import com.sunny.task.core.common.valid.InsertGroup;
import com.sunny.task.core.common.valid.LoginGroup;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author sunny
 * @className com.sunny.task.controller.main.form.AppUserForm
 * @date 2017-12-25 22:35
 * @description:
 */
public class AppUserForm extends BaseForm {
    private static final long serialVersionUID = -5093416432003674784L;
    /**
     * 账号
     */
    @NotBlank(message = "请输入账号", groups = {LoginGroup.class, InsertGroup.class})
    @NotNull(message = "字段 [account] 必填", groups = {LoginGroup.class, InsertGroup.class})
    @Length(max = 50, message = "账号最长{max}位字符", groups = {InsertGroup.class})
    private String account;
    /**
     * 密码
     */
    @NotBlank(message = "请输入密码", groups = {LoginGroup.class, InsertGroup.class})
    @NotNull(message = "字段 [password] 必填", groups = {LoginGroup.class, InsertGroup.class})
    @Length(max = 50, min = 6, message = "密码长度在{min}-{max}位字符", groups = {InsertGroup.class})
    private String password;
    /**
     * 邮箱
     */
    @NotBlank(message = "请输入邮箱", groups = {InsertGroup.class})
    @NotNull(message = "字段 [email] 必填", groups = {InsertGroup.class})
    @Length(max = 100, min = 3, message = "邮箱长度{min}~{max}位字符", groups = {InsertGroup.class})
    @Pattern(regexp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)$", message = "请输入正确的邮箱地址", groups = {InsertGroup.class})
    private String email;
    
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
