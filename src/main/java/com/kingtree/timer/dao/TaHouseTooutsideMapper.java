package com.kingtree.timer.dao;

import com.kingtree.timer.entity.TaHouseTooutside;

public interface TaHouseTooutsideMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(TaHouseTooutside record);

	int insertSelective(TaHouseTooutside record);

	TaHouseTooutside selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(TaHouseTooutside record);

	int updateByPrimaryKey(TaHouseTooutside record);
}