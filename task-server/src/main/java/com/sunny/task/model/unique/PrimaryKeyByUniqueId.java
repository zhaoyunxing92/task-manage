package com.sunny.task.model.unique;


import com.sunny.task.model.BaseModel;

public class PrimaryKeyByUniqueId extends BaseModel<String> {
    private static final long serialVersionUID = 1784013551058637790L;
    private String uniqueId;

    private Long primaryKey;

    private Byte keyType;

    public PrimaryKeyByUniqueId() {
        super();
    }

    public PrimaryKeyByUniqueId(String uniqueId, Long primaryKey, Byte keyType) {
        this.uniqueId = uniqueId;
        this.primaryKey = primaryKey;
        this.keyType = keyType;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId == null ? null : uniqueId.trim();
    }

    public Long getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(Long primaryKey) {
        this.primaryKey = primaryKey;
    }

    public Byte getKeyType() {
        return keyType;
    }

    public void setKeyType(Byte keyType) {
        this.keyType = keyType;
    }

}
