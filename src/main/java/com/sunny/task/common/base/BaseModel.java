package com.sunny.task.common.base;

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

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }
}
