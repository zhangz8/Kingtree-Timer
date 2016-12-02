package com.kingtree.timer.entity;

import java.util.Date;

public class TaBuilding {
    private String buildingid;

    private String estateid;

    private String buildingname;

    private String floorstart;

    private String floorend;

    private String floorall;

    private String countt;

    private String counth;

    private String cellstart;

    private String cellend;

    private String cell;

    private String unitrules;

    private String flagdeleted;

    private String flagtrashed;

    private Date moddate;

    private Date exdate;

    private String floorrule;

    private String startfloornumrange;

    private String endfloornumrange;

    private String startfloorletterrange;

    private String endfloorletterrange;

    private String roomrule;

    private String startnumrange;

    private String endnumrange;

    private String startletterrange;

    private String endletterrange;

    private Byte useroomrule;

    private Byte usefloorrule;

    private Byte isusermoomno;

    private String roomvalidityrule;

    private Integer room;

    public String getBuildingid() {
        return buildingid;
    }

    public void setBuildingid(String buildingid) {
        this.buildingid = buildingid == null ? null : buildingid.trim();
    }

    public String getEstateid() {
        return estateid;
    }

    public void setEstateid(String estateid) {
        this.estateid = estateid == null ? null : estateid.trim();
    }

    public String getBuildingname() {
        return buildingname;
    }

    public void setBuildingname(String buildingname) {
        this.buildingname = buildingname == null ? null : buildingname.trim();
    }

    public String getFloorstart() {
        return floorstart;
    }

    public void setFloorstart(String floorstart) {
        this.floorstart = floorstart == null ? null : floorstart.trim();
    }

    public String getFloorend() {
        return floorend;
    }

    public void setFloorend(String floorend) {
        this.floorend = floorend == null ? null : floorend.trim();
    }

    public String getFloorall() {
        return floorall;
    }

    public void setFloorall(String floorall) {
        this.floorall = floorall == null ? null : floorall.trim();
    }

    public String getCountt() {
        return countt;
    }

    public void setCountt(String countt) {
        this.countt = countt == null ? null : countt.trim();
    }

    public String getCounth() {
        return counth;
    }

    public void setCounth(String counth) {
        this.counth = counth == null ? null : counth.trim();
    }

    public String getCellstart() {
        return cellstart;
    }

    public void setCellstart(String cellstart) {
        this.cellstart = cellstart == null ? null : cellstart.trim();
    }

    public String getCellend() {
        return cellend;
    }

    public void setCellend(String cellend) {
        this.cellend = cellend == null ? null : cellend.trim();
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell == null ? null : cell.trim();
    }

    public String getUnitrules() {
        return unitrules;
    }

    public void setUnitrules(String unitrules) {
        this.unitrules = unitrules == null ? null : unitrules.trim();
    }

    public String getFlagdeleted() {
        return flagdeleted;
    }

    public void setFlagdeleted(String flagdeleted) {
        this.flagdeleted = flagdeleted == null ? null : flagdeleted.trim();
    }

    public String getFlagtrashed() {
        return flagtrashed;
    }

    public void setFlagtrashed(String flagtrashed) {
        this.flagtrashed = flagtrashed == null ? null : flagtrashed.trim();
    }

    public Date getModdate() {
        return moddate;
    }

    public void setModdate(Date moddate) {
        this.moddate = moddate;
    }

    public Date getExdate() {
        return exdate;
    }

    public void setExdate(Date exdate) {
        this.exdate = exdate;
    }

    public String getFloorrule() {
        return floorrule;
    }

    public void setFloorrule(String floorrule) {
        this.floorrule = floorrule == null ? null : floorrule.trim();
    }

    public String getStartfloornumrange() {
        return startfloornumrange;
    }

    public void setStartfloornumrange(String startfloornumrange) {
        this.startfloornumrange = startfloornumrange == null ? null : startfloornumrange.trim();
    }

    public String getEndfloornumrange() {
        return endfloornumrange;
    }

    public void setEndfloornumrange(String endfloornumrange) {
        this.endfloornumrange = endfloornumrange == null ? null : endfloornumrange.trim();
    }

    public String getStartfloorletterrange() {
        return startfloorletterrange;
    }

    public void setStartfloorletterrange(String startfloorletterrange) {
        this.startfloorletterrange = startfloorletterrange == null ? null : startfloorletterrange.trim();
    }

    public String getEndfloorletterrange() {
        return endfloorletterrange;
    }

    public void setEndfloorletterrange(String endfloorletterrange) {
        this.endfloorletterrange = endfloorletterrange == null ? null : endfloorletterrange.trim();
    }

    public String getRoomrule() {
        return roomrule;
    }

    public void setRoomrule(String roomrule) {
        this.roomrule = roomrule == null ? null : roomrule.trim();
    }

    public String getStartnumrange() {
        return startnumrange;
    }

    public void setStartnumrange(String startnumrange) {
        this.startnumrange = startnumrange == null ? null : startnumrange.trim();
    }

    public String getEndnumrange() {
        return endnumrange;
    }

    public void setEndnumrange(String endnumrange) {
        this.endnumrange = endnumrange == null ? null : endnumrange.trim();
    }

    public String getStartletterrange() {
        return startletterrange;
    }

    public void setStartletterrange(String startletterrange) {
        this.startletterrange = startletterrange == null ? null : startletterrange.trim();
    }

    public String getEndletterrange() {
        return endletterrange;
    }

    public void setEndletterrange(String endletterrange) {
        this.endletterrange = endletterrange == null ? null : endletterrange.trim();
    }

    public Byte getUseroomrule() {
        return useroomrule;
    }

    public void setUseroomrule(Byte useroomrule) {
        this.useroomrule = useroomrule;
    }

    public Byte getUsefloorrule() {
        return usefloorrule;
    }

    public void setUsefloorrule(Byte usefloorrule) {
        this.usefloorrule = usefloorrule;
    }

    public Byte getIsusermoomno() {
        return isusermoomno;
    }

    public void setIsusermoomno(Byte isusermoomno) {
        this.isusermoomno = isusermoomno;
    }

    public String getRoomvalidityrule() {
        return roomvalidityrule;
    }

    public void setRoomvalidityrule(String roomvalidityrule) {
        this.roomvalidityrule = roomvalidityrule == null ? null : roomvalidityrule.trim();
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }
}