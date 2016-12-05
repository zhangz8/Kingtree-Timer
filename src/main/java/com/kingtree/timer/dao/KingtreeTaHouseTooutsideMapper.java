package com.kingtree.timer.dao;

import com.kingtree.timer.entity.KingtreeTaHouseTooutside;

public interface KingtreeTaHouseTooutsideMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(KingtreeTaHouseTooutside record);

	int insertSelective(KingtreeTaHouseTooutside record);

	KingtreeTaHouseTooutside selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(KingtreeTaHouseTooutside record);

	int updateByPrimaryKey(KingtreeTaHouseTooutside record);
}