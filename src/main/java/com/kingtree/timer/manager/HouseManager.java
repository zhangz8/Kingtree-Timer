package com.kingtree.timer.manager;

import java.util.List;

import com.kingtree.timer.manager.bo.HouseBO;

public interface HouseManager {

	/**
	 * 获取房子信息
	 * 
	 * @param houseId
	 * @return
	 */
	HouseBO get(String houseId);

	/**
	 * 获取房子信息
	 * 
	 * @param start
	 * @param length
	 * @return
	 */
	List<HouseBO> gets(int start, int length);

	/**
	 * 处理房子信息
	 * 
	 * @param houseVO
	 */
	void process(List<HouseBO> houseVOList);

}
