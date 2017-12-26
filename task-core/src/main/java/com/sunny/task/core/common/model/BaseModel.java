package com.sunny.task.core.common.model;


import com.sunny.task.core.common.context.TaskAppUserContext;

import java.io.Serializable;
import java.util.Date;

/**
 * @author sunny
 * @className com.sunny.task.base.BaseModel
 * @date 2017-10-15 18:17
 * @description:
 */
public class BaseModel<ID extends Serializable> implements Serializable {
    private static final long serialVersionUID = 720013901235423189L;

    private ID uId;

    private String creator;

    private Date creationDate;

    private String modifier;

    private Date modificationDate;

    private Integer vsersion;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public ID getuId() {
        return uId;
    }

    public void setuId(ID uId) {
        this.uId = uId;
    }

    public String getCreator() {
        return creator == null ? TaskAppUserContext.getuId() : creator;
    }

    public void setCreator(String creator) {

        this.creator = creator;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getModifier() {
        return modifier == null ? TaskAppUserContext.getuId() : modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public Integer getVsersion() {
        return vsersion;
    }

    public void setVsersion(Integer vsersion) {
        this.vsersion = vsersion;
    }
}
