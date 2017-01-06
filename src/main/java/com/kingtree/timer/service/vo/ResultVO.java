package com.kingtree.timer.service.vo;

import java.io.Serializable;
import java.util.List;

public class ResultVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3331861613647681466L;

	private int total;
	private List<ResultHouseVO> houses;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<ResultHouseVO> getHouses() {
		return houses;
	}

	public void setHouses(List<ResultHouseVO> houses) {
		this.houses = houses;
	}

}
