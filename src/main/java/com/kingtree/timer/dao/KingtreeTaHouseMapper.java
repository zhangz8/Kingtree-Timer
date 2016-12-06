package com.kingtree.timer.dao;

import com.kingtree.timer.entity.KingtreeTaHouse;

public interface KingtreeTaHouseMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(KingtreeTaHouse record);

	int insertSelective(KingtreeTaHouse record);

	KingtreeTaHouse selectByPrimaryKey(Integer id);

	KingtreeTaHouse selectByHouseId(String houseId);

	int updateByPrimaryKeySelective(KingtreeTaHouse record);

	int updateByPrimaryKey(KingtreeTaHouse record);
}