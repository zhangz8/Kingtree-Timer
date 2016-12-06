package com.kingtree.timer.service.vo;

import java.io.Serializable;
import java.util.Date;

import com.kingtree.timer.entity.TaPicearea;
import com.kingtree.timer.util.BeanUtil;

public class TaPiceareaVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -691077896836170184L;

	private int id;

	private String areaid;

	private String dsid;

	private String areano;

	private String areaname;

	private Date moddate;

	private String flagdeleted;

	private String flagtrashed;

	private String remark;

	private Date dxdate;

	private Double lngx;

	private Double laty;

	public TaPiceareaVO() {
	}

	public TaPiceareaVO(int id) {
		this.id = id;
	}

	public static TaPiceareaVO build(int id, TaPicearea taPicearea) {
		TaPiceareaVO taPiceareaVO = new TaPiceareaVO(id);
		BeanUtil.copyFields(taPiceareaVO, taPicearea);
		return taPiceareaVO;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAreaid() {
		return areaid;
	}

	public void setAreaid(String areaid) {
		this.areaid = areaid == null ? null : areaid.trim();
	}

	public String getDsid() {
		return dsid;
	}

	public void setDsid(String dsid) {
		this.dsid = dsid == null ? null : dsid.trim();
	}

	public String getAreano() {
		return areano;
	}

	public void setAreano(String areano) {
		this.areano = areano == null ? null : areano.trim();
	}

	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname == null ? null : areaname.trim();
	}

	public Date getModdate() {
		return moddate;
	}

	public void setModdate(Date moddate) {
		this.moddate = moddate;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public Date getDxdate() {
		return dxdate;
	}

	public void setDxdate(Date dxdate) {
		this.dxdate = dxdate;
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
}
