package com.kingtree.timer.entity;

import java.math.BigDecimal;
import java.util.Date;

public class TaAttachment {
    private String attachmentid;

    private String attachname;

    private String uploadip;

    private Date uploaddate;

    private BigDecimal attachsize;

    private String attachurl;

    private String smallurl;

    private String attachtype;

    private String belongtablename;

    private String belongid;

    private String phototype;

    private String empid;

    private String empname;

    private Date createtime;

    private Boolean flagdeleted;

    private String delperson;

    private Date deldate;

    private String emcsmallurl;

    public String getAttachmentid() {
        return attachmentid;
    }

    public void setAttachmentid(String attachmentid) {
        this.attachmentid = attachmentid == null ? null : attachmentid.trim();
    }

    public String getAttachname() {
        return attachname;
    }

    public void setAttachname(String attachname) {
        this.attachname = attachname == null ? null : attachname.trim();
    }

    public String getUploadip() {
        return uploadip;
    }

    public void setUploadip(String uploadip) {
        this.uploadip = uploadip == null ? null : uploadip.trim();
    }

    public Date getUploaddate() {
        return uploaddate;
    }

    public void setUploaddate(Date uploaddate) {
        this.uploaddate = uploaddate;
    }

    public BigDecimal getAttachsize() {
        return attachsize;
    }

    public void setAttachsize(BigDecimal attachsize) {
        this.attachsize = attachsize;
    }

    public String getAttachurl() {
        return attachurl;
    }

    public void setAttachurl(String attachurl) {
        this.attachurl = attachurl == null ? null : attachurl.trim();
    }

    public String getSmallurl() {
        return smallurl;
    }

    public void setSmallurl(String smallurl) {
        this.smallurl = smallurl == null ? null : smallurl.trim();
    }

    public String getAttachtype() {
        return attachtype;
    }

    public void setAttachtype(String attachtype) {
        this.attachtype = attachtype == null ? null : attachtype.trim();
    }

    public String getBelongtablename() {
        return belongtablename;
    }

    public void setBelongtablename(String belongtablename) {
        this.belongtablename = belongtablename == null ? null : belongtablename.trim();
    }

    public String getBelongid() {
        return belongid;
    }

    public void setBelongid(String belongid) {
        this.belongid = belongid == null ? null : belongid.trim();
    }

    public String getPhototype() {
        return phototype;
    }

    public void setPhototype(String phototype) {
        this.phototype = phototype == null ? null : phototype.trim();
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid == null ? null : empid.trim();
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname == null ? null : empname.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Boolean getFlagdeleted() {
        return flagdeleted;
    }

    public void setFlagdeleted(Boolean flagdeleted) {
        this.flagdeleted = flagdeleted;
    }

    public String getDelperson() {
        return delperson;
    }

    public void setDelperson(String delperson) {
        this.delperson = delperson == null ? null : delperson.trim();
    }

    public Date getDeldate() {
        return deldate;
    }

    public void setDeldate(Date deldate) {
        this.deldate = deldate;
    }

    public String getEmcsmallurl() {
        return emcsmallurl;
    }

    public void setEmcsmallurl(String emcsmallurl) {
        this.emcsmallurl = emcsmallurl == null ? null : emcsmallurl.trim();
    }
}