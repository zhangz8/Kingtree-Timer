package com.kingtree.timer.entity;

public class TaDstrict {
    private String dsid;

    private String areaid;

    private String districtno;

    private String dstrictname;

    private Double lngx;

    private Double laty;

    private String cdesc;

    public String getDsid() {
        return dsid;
    }

    public void setDsid(String dsid) {
        this.dsid = dsid == null ? null : dsid.trim();
    }

    public String getAreaid() {
        return areaid;
    }

    public void setAreaid(String areaid) {
        this.areaid = areaid == null ? null : areaid.trim();
    }

    public String getDistrictno() {
        return districtno;
    }

    public void setDistrictno(String districtno) {
        this.districtno = districtno == null ? null : districtno.trim();
    }

    public String getDstrictname() {
        return dstrictname;
    }

    public void setDstrictname(String dstrictname) {
        this.dstrictname = dstrictname == null ? null : dstrictname.trim();
    }

    public Double getLngx() {
        return lngx;
    }

    public void setLngx(Double lngx) {
        this.lngx = lngx;
    }

    public Double getLaty() {
        return laty;
    }

    public void setLaty(Double laty) {
        this.laty = laty;
    }

    public String getCdesc() {
        return cdesc;
    }

    public void setCdesc(String cdesc) {
        this.cdesc = cdesc == null ? null : cdesc.trim();
    }
}