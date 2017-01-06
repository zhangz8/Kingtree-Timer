package com.kingtree.timer.service.vo;

import java.io.Serializable;

public class IndexicalHouseVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8449196245978838205L;

	private String houseId;
	private String houseAddress;
	private String houseName;
	private String housePrice;
	private String houseDesc;

	private String communityId;
	private String communityName;
	private String communityDesc;

	private String hostName;
	private String hostTel;

	private String brokerName;
	private String brokerTel;

	private String block;

	public String getHouseId() {
		return houseId;
	}

	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}

	public String getHouseAddress() {
		return houseAddress;
	}

	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
	}

	public String getHouseDesc() {
		return houseDesc;
	}

	public void setHouseDesc(String houseDesc) {
		this.houseDesc = houseDesc;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public String getHousePrice() {
		return housePrice;
	}

	public void setHousePrice(String housePrice) {
		this.housePrice = housePrice;
	}

	public String getCommunityId() {
		return communityId;
	}

	public void setCommunityId(String communityId) {
		this.communityId = communityId;
	}

	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

	public String getCommunityDesc() {
		return communityDesc;
	}

	public void setCommunityDesc(String communityDesc) {
		this.communityDesc = communityDesc;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getHostTel() {
		return hostTel;
	}

	public void setHostTel(String hostTel) {
		this.hostTel = hostTel;
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

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

}
