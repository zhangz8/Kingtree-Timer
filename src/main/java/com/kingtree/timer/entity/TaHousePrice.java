package com.kingtree.timer.entity;

import java.math.BigDecimal;
import java.util.Date;

public class TaHousePrice {
    private String hsid;

    private String houseid;

    private BigDecimal sellprice;

    private BigDecimal rentprice;

    private BigDecimal pricebase;

    private BigDecimal sellpricechange;

    private BigDecimal rentpricechange;

    private String sellunitname;

    private String rentunitname;

    private BigDecimal sellpriceunit;

    private BigDecimal rentpriceunit;

    private BigDecimal sellpriceline;

    private BigDecimal rentpriceline;

    private String propertytax;

    private String sellpropertybuy;

    private String sellpropertycommiss;

    private String rentpropertybuy;

    private String rentpropertycommiss;

    private Date createdate;

    private Date modidate;

    private Date deldate;

    private String ohter;

    private BigDecimal assignmentfee;

    public String getHsid() {
        return hsid;
    }

    public void setHsid(String hsid) {
        this.hsid = hsid == null ? null : hsid.trim();
    }

    public String getHouseid() {
        return houseid;
    }

    public void setHouseid(String houseid) {
        this.houseid = houseid == null ? null : houseid.trim();
    }

    public BigDecimal getSellprice() {
        return sellprice;
    }

    public void setSellprice(BigDecimal sellprice) {
        this.sellprice = sellprice;
    }

    public BigDecimal getRentprice() {
        return rentprice;
    }

    public void setRentprice(BigDecimal rentprice) {
        this.rentprice = rentprice;
    }

    public BigDecimal getPricebase() {
        return pricebase;
    }

    public void setPricebase(BigDecimal pricebase) {
        this.pricebase = pricebase;
    }

    public BigDecimal getSellpricechange() {
        return sellpricechange;
    }

    public void setSellpricechange(BigDecimal sellpricechange) {
        this.sellpricechange = sellpricechange;
    }

    public BigDecimal getRentpricechange() {
        return rentpricechange;
    }

    public void setRentpricechange(BigDecimal rentpricechange) {
        this.rentpricechange = rentpricechange;
    }

    public String getSellunitname() {
        return sellunitname;
    }

    public void setSellunitname(String sellunitname) {
        this.sellunitname = sellunitname == null ? null : sellunitname.trim();
    }

    public String getRentunitname() {
        return rentunitname;
    }

    public void setRentunitname(String rentunitname) {
        this.rentunitname = rentunitname == null ? null : rentunitname.trim();
    }

    public BigDecimal getSellpriceunit() {
        return sellpriceunit;
    }

    public void setSellpriceunit(BigDecimal sellpriceunit) {
        this.sellpriceunit = sellpriceunit;
    }

    public BigDecimal getRentpriceunit() {
        return rentpriceunit;
    }

    public void setRentpriceunit(BigDecimal rentpriceunit) {
        this.rentpriceunit = rentpriceunit;
    }

    public BigDecimal getSellpriceline() {
        return sellpriceline;
    }

    public void setSellpriceline(BigDecimal sellpriceline) {
        this.sellpriceline = sellpriceline;
    }

    public BigDecimal getRentpriceline() {
        return rentpriceline;
    }

    public void setRentpriceline(BigDecimal rentpriceline) {
        this.rentpriceline = rentpriceline;
    }

    public String getPropertytax() {
        return propertytax;
    }

    public void setPropertytax(String propertytax) {
        this.propertytax = propertytax == null ? null : propertytax.trim();
    }

    public String getSellpropertybuy() {
        return sellpropertybuy;
    }

    public void setSellpropertybuy(String sellpropertybuy) {
        this.sellpropertybuy = sellpropertybuy == null ? null : sellpropertybuy.trim();
    }

    public String getSellpropertycommiss() {
        return sellpropertycommiss;
    }

    public void setSellpropertycommiss(String sellpropertycommiss) {
        this.sellpropertycommiss = sellpropertycommiss == null ? null : sellpropertycommiss.trim();
    }

    public String getRentpropertybuy() {
        return rentpropertybuy;
    }

    public void setRentpropertybuy(String rentpropertybuy) {
        this.rentpropertybuy = rentpropertybuy == null ? null : rentpropertybuy.trim();
    }

    public String getRentpropertycommiss() {
        return rentpropertycommiss;
    }

    public void setRentpropertycommiss(String rentpropertycommiss) {
        this.rentpropertycommiss = rentpropertycommiss == null ? null : rentpropertycommiss.trim();
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

    public String getOhter() {
        return ohter;
    }

    public void setOhter(String ohter) {
        this.ohter = ohter == null ? null : ohter.trim();
    }

    public BigDecimal getAssignmentfee() {
        return assignmentfee;
    }

    public void setAssignmentfee(BigDecimal assignmentfee) {
        this.assignmentfee = assignmentfee;
    }
}