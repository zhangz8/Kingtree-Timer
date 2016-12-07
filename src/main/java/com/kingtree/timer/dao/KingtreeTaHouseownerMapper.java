package com.kingtree.timer.dao;

import com.kingtree.timer.entity.KingtreeTaHouseowner;

public interface KingtreeTaHouseownerMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(KingtreeTaHouseowner record);

	int insertSelective(KingtreeTaHouseowner record);

	KingtreeTaHouseowner selectByPrimaryKey(Integer id);

	KingtreeTaHouseowner selectByHoseownerId(String houseownerId);

	int updateByPrimaryKeySelective(KingtreeTaHouseowner record);

	int updateByPrimaryKey(KingtreeTaHouseowner record);
}