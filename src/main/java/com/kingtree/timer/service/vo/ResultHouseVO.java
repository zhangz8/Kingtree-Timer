package com.kingtree.timer.service.vo;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

import com.kingtree.timer.util.ConstantsUtil;

public class ResultHouseVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3485851996538122454L;

	private String houseId;
	private String houseImg;
	private String houseName;
	private String brokerName;
	private String brokerTel;
	private String layout;
	private String address;
	private String communityName;

	public ResultHouseVO(TaHouseVO house, TaEstateVO estate, TaSystemUserVO user) {
		this.houseId = house.getHouseid();
		this.address = estate.getAddress();
		this.brokerTel = user.getMobile();
		this.brokerName = user.getUsername();
		this.communityName = estate.getEstatename();
		this.houseName = house.getTitle();
		this.houseImg = StringUtils.isBlank(house.getCoverphoto()) ? "" : (ConstantsUtil.IMAGE_SERVER + house.getCoverphoto());
		this.layout = house.getCountf() + "室" + house.getCountt() + "厅" + house.getCountw() + "卫";
	}

	public ResultHouseVO() {
	}

	public String getHouseId() {
		return houseId;
	}

	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}

	public String getHouseImg() {
		return houseImg;
	}

	public void setHouseImg(String houseImg) {
		this.houseImg = houseImg;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public String getBrokerName() {
		return brokerName;
	}

	public void setBrokerName(String brokerName) {
		this.brokerName = brokerName;
	}

	public String getBrokerTel() {
		return brokerTel;
	}

	public void setBrokerTel(String brokerTel) {
		this.brokerTel = brokerTel;
	}

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

}
