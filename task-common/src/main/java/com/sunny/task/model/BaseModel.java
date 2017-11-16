package com.sunny.task.model;


import com.sunny.task.context.TaskAppUserContext;

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
    private ID id;

    private String uId;

    private Long creator;

    private Date creationDate;

    private Long modifier;

    private Date modificationDate;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public Long getCreator() {
        return creator == null ? TaskAppUserContext.getTaskUserId() : creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Date getCreationDate() {
        return creationDate == null ? new Date() : creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getModifier() {
        return modifier == null ? TaskAppUserContext.getTaskUserId() : modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public Date getModificationDate() {
        return modificationDate == null ? new Date() : modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }
}
