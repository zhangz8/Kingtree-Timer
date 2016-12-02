package com.kingtree.timer.entity;

import java.util.Date;

public class TaBuildingUnit {
    private String unitid;

    private String buildingid;

    private String unitname;

    private Date createtime;

    private Integer unitsort;

    public String getUnitid() {
        return unitid;
    }

    public void setUnitid(String unitid) {
        this.unitid = unitid == null ? null : unitid.trim();
    }

    public String getBuildingid() {
        return buildingid;
    }

    public void setBuildingid(String buildingid) {
        this.buildingid = buildingid == null ? null : buildingid.trim();
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname == null ? null : unitname.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getUnitsort() {
        return unitsort;
    }

    public void setUnitsort(Integer unitsort) {
        this.unitsort = unitsort;
    }
}