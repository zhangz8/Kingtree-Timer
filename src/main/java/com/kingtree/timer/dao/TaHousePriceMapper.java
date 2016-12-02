package com.kingtree.timer.dao;

import org.apache.ibatis.annotations.Param;

import com.kingtree.timer.entity.TaHousePrice;

public interface TaHousePriceMapper {
	int deleteByPrimaryKey(String hsid);

	int insert(TaHousePrice record);

	int insertSelective(TaHousePrice record);

	TaHousePrice selectByPrimaryKey(String hsid);

	int updateByPrimaryKeySelective(TaHousePrice record);

	int updateByPrimaryKey(TaHousePrice record);

	TaHousePrice selectByHouseId(@Param("houseId") String houseId);
}