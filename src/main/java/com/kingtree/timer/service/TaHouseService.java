package com.kingtree.timer.service;

import java.util.List;

import com.kingtree.timer.entity.TaHouse;

public interface TaHouseService {

	List<TaHouse> get(TaHouse taHouse, int start, int length);

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
	List<TaHouse> getOutSide(int start, int length);
}
