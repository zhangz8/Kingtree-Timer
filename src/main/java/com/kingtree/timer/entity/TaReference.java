package com.kingtree.timer.entity;

import java.util.Date;

public class TaReference {
    private String refid;

    private String pid;

    private String refname;

    private String refnamecn;

    private String itemno;

    private String itemvalue;

    private String iteminfo;

    private Date moddate;

    private String flagtrashed;

    private String flagdeleted;

    private String flagallowmod;

    private String flagallowdel;

    public String getRefid() {
        return refid;
    }

    public void setRefid(String refid) {
        this.refid = refid == null ? null : refid.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getRefname() {
        return refname;
    }

    public void setRefname(String refname) {
        this.refname = refname == null ? null : refname.trim();
    }

    public String getRefnamecn() {
        return refnamecn;
    }

    public void setRefnamecn(String refnamecn) {
        this.refnamecn = refnamecn == null ? null : refnamecn.trim();
    }

    public String getItemno() {
        return itemno;
    }

    public void setItemno(String itemno) {
        this.itemno = itemno == null ? null : itemno.trim();
    }

    public String getItemvalue() {
        return itemvalue;
    }

    public void setItemvalue(String itemvalue) {
        this.itemvalue = itemvalue == null ? null : itemvalue.trim();
    }

    public String getIteminfo() {
        return iteminfo;
    }

    public void setIteminfo(String iteminfo) {
        this.iteminfo = iteminfo == null ? null : iteminfo.trim();
    }

    public Date getModdate() {
        return moddate;
    }

    public void setModdate(Date moddate) {
        this.moddate = moddate;
    }

    public String getFlagtrashed() {
        return flagtrashed;
    }

    public void setFlagtrashed(String flagtrashed) {
        this.flagtrashed = flagtrashed == null ? null : flagtrashed.trim();
    }

    public String getFlagdeleted() {
        return flagdeleted;
    }

    public void setFlagdeleted(String flagdeleted) {
        this.flagdeleted = flagdeleted == null ? null : flagdeleted.trim();
    }

    public String getFlagallowmod() {
        return flagallowmod;
    }

    public void setFlagallowmod(String flagallowmod) {
        this.flagallowmod = flagallowmod == null ? null : flagallowmod.trim();
    }

    public String getFlagallowdel() {
        return flagallowdel;
    }

    public void setFlagallowdel(String flagallowdel) {
        this.flagallowdel = flagallowdel == null ? null : flagallowdel.trim();
    }
}