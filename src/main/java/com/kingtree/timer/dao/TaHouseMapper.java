package com.kingtree.timer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kingtree.timer.entity.TaHouse;

public interface TaHouseMapper {
	int deleteByPrimaryKey(String houseid);

	int insert(TaHouse record);

	int insertSelective(TaHouse record);

	TaHouse selectByPrimaryKey(String houseid);

	int updateByPrimaryKeySelective(TaHouse record);

	int updateByPrimaryKey(TaHouse record);

	List<TaHouse> selectBySelective(@Param("taHouse") TaHouse taHouse, @Param("start") int start, @Param("length") int length);

	int countBySelective(@Param("taHouse") TaHouse taHouse);
}