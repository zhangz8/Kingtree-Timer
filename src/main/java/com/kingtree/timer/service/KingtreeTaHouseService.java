package com.kingtree.timer.service;

import java.sql.Timestamp;
import java.util.List;

import com.kingtree.timer.entity.TaHouse;
import com.kingtree.timer.service.vo.IndexicalHouseVO;
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

	int add(TaHouseVO taHouse);

	/**
	 * 获取下架房子
	 * 
	 * @param start
	 * @param length
	 * @return
	 */
	List<TaHouseVO> getOffLine(int start, int length);

	void remove(int kingtreeHouseId);

	/**
	 * 获取更新经纪人的房源
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	List<TaHouseVO> getRefreshBroker(Timestamp start, Timestamp end);

	/**
	 * 获取房源
	 * 
	 * @param updateTime 时间大于等于
	 * @param start
	 * @param limit
	 * @return
	 */
	List<TaHouse> get(Timestamp updateTime, int start, int length);

	/**
	 * 查询全部房源
	 * 
	 * @param start
	 * @param length
	 * @return
	 */
	List<TaHouse> query(int start, int length);

	int count();

	IndexicalHouseVO get(TaHouse house);
}
