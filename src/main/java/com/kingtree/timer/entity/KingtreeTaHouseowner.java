package com.kingtree.timer.entity;

import java.util.Date;

public class KingtreeTaHouseowner {
    private Integer id;

    private String houseownerId;

    private Date gmtCreate;

    private Date gmtModified;

    private Boolean isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHouseownerId() {
        return houseownerId;
    }

    public void setHouseownerId(String houseownerId) {
        this.houseownerId = houseownerId == null ? null : houseownerId.trim();
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