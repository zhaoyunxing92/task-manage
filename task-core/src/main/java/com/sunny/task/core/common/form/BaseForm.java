package com.sunny.task.core.common.form;


import com.sunny.task.core.common.utils.StringUtils;
import com.sunny.task.core.common.valid.SelectGroup;
import com.sunny.task.core.common.valid.UpdateGroup;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author sunny
 * @date 2017-03-31 17:01
 * @description 基础form
 */
public class BaseForm implements Serializable {

    private static final long serialVersionUID = 634044498033223687L;
    /**
     * uid
     */
    @NotBlank(message = "请输入id", groups = {UpdateGroup.class})
    private String uId;
    /**
     * 每页显示多少
     */
    @NotNull(message = "请输入每页显示多少条数据", groups = {SelectGroup.class})
    @Max(value = 10, message = "每页最多显示10条数据", groups = {SelectGroup.class})
    private Integer item;
    /**
     * 当前第几页
     */
    @NotNull(message = "请输入当前第几页", groups = {SelectGroup.class})
    @Min(value = 1, message = "当前页最小值是1", groups = {SelectGroup.class})
    private Integer pg;
    //TODO:修改的时候禁止修改状态为127(删除状态)
    @Max(value = 126, message = "状态最大是126", groups = {UpdateGroup.class})
    private Byte status;
    /**
     * 模糊查询使用的key
     */
    private String key;

    /**
     * 是否模糊查询
     */
    private Boolean funzzy;

    /**
     * 自动添加
     */
    private Boolean autoAdd;

    public Integer getItem() {
        if (item <= 0) {
            item = 10;
        }
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public Integer getPg() {
        if (pg <= 0) {
            pg = 1;
        }
        return (pg - 1) * this.item;
    }

    public void setPg(Integer pg) {
        this.pg = pg;
    }


    public String getKey() {

        return StringUtils.isBlank(key) ? null : this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public Boolean getFunzzy() {
        return funzzy == null ? this.funzzy = true : this.funzzy;
    }

    public void setFunzzy(Boolean funzzy) {
        this.funzzy = funzzy;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Boolean getAutoAdd() {
        return autoAdd;
    }

    public void setAutoAdd(Boolean autoAdd) {
        this.autoAdd = autoAdd;
    }
}
