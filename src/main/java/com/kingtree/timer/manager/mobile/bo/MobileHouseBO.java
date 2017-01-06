package com.kingtree.timer.manager.mobile.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.kingtree.timer.service.vo.TaEstateVO;
import com.kingtree.timer.service.vo.TaHouseVO;
import com.kingtree.timer.service.vo.TaSystemUserVO;
import com.kingtree.timer.util.ConstantsUtil;

public class MobileHouseBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2120751397399691227L;
	private List<String> innerImgs = new ArrayList<String>();
	private String layoutImg;
	private List<String> contractImgs = new ArrayList<String>();;
	private TaHouseVO house;
	private TaEstateVO estate;
	private TaSystemUserVO user;

	public MobileHouseBO() {
	}

	public MobileHouseBO(TaHouseVO house, TaEstateVO estate, TaSystemUserVO user) {
		this.house = house;
		this.estate = estate;
		this.user = user;
		this.layoutImg = house.getLayoutImg();
		for (String str : house.getInnerImgList()) {
			innerImgs.add(ConstantsUtil.IMAGE_SERVER + str);
		}
	}

	public List<String> getInnerImgs() {
		return innerImgs;
	}

	public void setInnerImgs(List<String> innerImgs) {
		this.innerImgs = innerImgs;
	}

	public String getLayoutImg() {
		return layoutImg;
	}

	public void setLayoutImg(String layoutImg) {
		this.layoutImg = layoutImg;
	}

	public TaEstateVO getEstate() {
		return estate;
	}

	public void setEstate(TaEstateVO estate) {
		this.estate = estate;
	}

	public TaSystemUserVO getUser() {
		return user;
	}

	public void setUser(TaSystemUserVO user) {
		this.user = user;
	}

	public List<String> getContractImgs() {
		return contractImgs;
	}

	public void setContractImgs(List<String> contractImgs) {
		this.contractImgs = contractImgs;
	}

	public TaHouseVO getHouse() {
		return house;
	}

	public void setHouse(TaHouseVO house) {
		this.house = house;
	}
}
