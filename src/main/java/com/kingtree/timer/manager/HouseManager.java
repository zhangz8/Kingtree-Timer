package com.kingtree.timer.manager;

import java.util.List;

import com.kingtree.timer.manager.vo.HouseVO;

public interface HouseManager {

	/**
	 * @param houseId
	 * @return
	 */
	HouseVO get(String houseId);

	/**
	 * @param start
	 * @param length
	 * @return
	 */
	List<HouseVO> gets(int start, int length);

}
