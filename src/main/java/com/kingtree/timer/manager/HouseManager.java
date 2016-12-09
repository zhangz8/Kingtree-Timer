package com.kingtree.timer.manager;

import java.sql.Timestamp;
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
	void processPublish(List<HouseBO> houseVOList, String baseFilePath);

	/**
	 * 获取下架房子
	 * 
	 * @param start
	 * @param length
	 * @return
	 */
	List<HouseBO> getsOffLine(int start, int length);

	void processOffLine(List<HouseBO> offLineHoseBOList, String baseFilePath);

	List<HouseBO> getsRefresh(Timestamp start, Timestamp end);

	void processRefresh(List<HouseBO> refreshHoseBOList, String baseFilePath);

}
