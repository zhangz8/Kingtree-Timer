package com.kingtree.timer.service;

import java.util.List;

import com.kingtree.timer.entity.TaHouse;
import com.kingtree.timer.service.vo.TaHouseVO;

public interface KingtreeTaHouseService {

	List<TaHouseVO> get(TaHouse taHouse, int start, int length);

	int count(TaHouse taHouse);

	/**
	 * 统计发布到外网的房源
	 * 
	 * @return
	 */
	int countOutSide();

	/**
	 * 获取发布到外网的房源
	 * 
	 * @param start
	 * @param length
	 * @return
	 */
	List<TaHouseVO> getOutSide(int start, int length);

	TaHouseVO get(String houseId);
}
