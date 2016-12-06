package com.kingtree.timer.entity;

import java.util.Date;

public class KingtreeTaPicearea {
    private Integer id;

    private String piceareaId;

    private Date gmtCreate;

    private Date gmtModified;

    private Boolean isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPiceareaId() {
        return piceareaId;
    }

    public void setPiceareaId(String piceareaId) {
        this.piceareaId = piceareaId == null ? null : piceareaId.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
}