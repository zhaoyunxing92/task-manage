package com.sunny.task.user.form;

import com.sunny.task.common.base.BaseForm;
import com.sunny.task.common.valid.InsertGroup;
import com.sunny.task.common.valid.LoginGroup;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author sunny
 * @className com.sunny.task.user.form.AppUserForm
 * @date 2017-10-16 11:00
 * @description:
 */
public class AppUserForm extends BaseForm<String> {
    private static final long serialVersionUID = -7715706622306629962L;
    /**
     * 用户名
     */
    @Length(max = 50, message = "账号最长50位", groups = {InsertGroup.class})
    @NotNull(message = "请输入账号", groups = {LoginGroup.class})
    @NotBlank(message = "请输入账号", groups = {LoginGroup.class})
    private String account;
    /**
     * 密码
     */
    @NotNull(message = "请输入密码", groups = {InsertGroup.class, LoginGroup.class})
    @NotBlank(message = "请输入密码", groups = {LoginGroup.class})
    @Length(max = 50, min = 6, message = "密码长度在6-50位字符", groups = {InsertGroup.class})
    private String password;

    /**
     * 邮箱
     */
    @NotNull(message = "请输入邮箱", groups = {InsertGroup.class})
    @Length(max = 128, min = 3, message = "邮箱长度{min}~{max}位字符", groups = {InsertGroup.class})
    @Pattern(regexp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)$", message = "请输入正确的邮箱地址", groups = {InsertGroup.class})
    private String email;

    /**
     * 手机号
     */
    @Pattern(regexp = "^1[34578]\\d{9}$", message = "请输入正确的手机号", groups = {InsertGroup.class})
    private String mobile;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }
}
