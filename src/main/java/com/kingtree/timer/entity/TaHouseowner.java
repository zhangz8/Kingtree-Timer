package com.kingtree.timer.entity;

import java.util.Date;

public class TaHouseowner {
    private String hwid;

    private String owername;

    private String ownemobile;

    private String ownertel;

    private String adress;

    private String ownercard;

    private String ownercountry;

    private String ownerzip;

    private String other;

    private Date createdate;

    private Date modidate;

    private Date deldate;

    private String email;

    private String qq;

    private String wechat;

    private String purposehouseing;

    private Integer housecount;

    private Integer recommendnum;

    private String sex;

    private String maritalstatus;

    public String getHwid() {
        return hwid;
    }

    public void setHwid(String hwid) {
        this.hwid = hwid == null ? null : hwid.trim();
    }

    public String getOwername() {
        return owername;
    }

    public void setOwername(String owername) {
        this.owername = owername == null ? null : owername.trim();
    }

    public String getOwnemobile() {
        return ownemobile;
    }

    public void setOwnemobile(String ownemobile) {
        this.ownemobile = ownemobile == null ? null : ownemobile.trim();
    }

    public String getOwnertel() {
        return ownertel;
    }

    public void setOwnertel(String ownertel) {
        this.ownertel = ownertel == null ? null : ownertel.trim();
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress == null ? null : adress.trim();
    }

    public String getOwnercard() {
        return ownercard;
    }

    public void setOwnercard(String ownercard) {
        this.ownercard = ownercard == null ? null : ownercard.trim();
    }

    public String getOwnercountry() {
        return ownercountry;
    }

    public void setOwnercountry(String ownercountry) {
        this.ownercountry = ownercountry == null ? null : ownercountry.trim();
    }

    public String getOwnerzip() {
        return ownerzip;
    }

    public void setOwnerzip(String ownerzip) {
        this.ownerzip = ownerzip == null ? null : ownerzip.trim();
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getModidate() {
        return modidate;
    }

    public void setModidate(Date modidate) {
        this.modidate = modidate;
    }

    public Date getDeldate() {
        return deldate;
    }

    public void setDeldate(Date deldate) {
        this.deldate = deldate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public String getPurposehouseing() {
        return purposehouseing;
    }

    public void setPurposehouseing(String purposehouseing) {
        this.purposehouseing = purposehouseing == null ? null : purposehouseing.trim();
    }

    public Integer getHousecount() {
        return housecount;
    }

    public void setHousecount(Integer housecount) {
        this.housecount = housecount;
    }

    public Integer getRecommendnum() {
        return recommendnum;
    }

    public void setRecommendnum(Integer recommendnum) {
        this.recommendnum = recommendnum;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getMaritalstatus() {
        return maritalstatus;
    }

    public void setMaritalstatus(String maritalstatus) {
        this.maritalstatus = maritalstatus == null ? null : maritalstatus.trim();
    }
}