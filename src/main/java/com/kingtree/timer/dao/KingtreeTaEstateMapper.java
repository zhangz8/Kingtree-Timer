package com.kingtree.timer.dao;

import com.kingtree.timer.entity.KingtreeTaEstate;

public interface KingtreeTaEstateMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(KingtreeTaEstate record);

	int insertSelective(KingtreeTaEstate record);

	KingtreeTaEstate selectByPrimaryKey(Integer id);

	KingtreeTaEstate selectByEstateId(String estateId);

	int updateByPrimaryKeySelective(KingtreeTaEstate record);

	int updateByPrimaryKey(KingtreeTaEstate record);
}