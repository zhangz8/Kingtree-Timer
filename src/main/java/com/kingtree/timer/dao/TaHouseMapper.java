package com.kingtree.timer.dao;

import java.sql.Timestamp;
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

	int countByTooutside();

	List<TaHouse> selectByTooutside(@Param("start") int start, @Param("length") int length);

	List<TaHouse> selectOffLine(@Param("start") int start, @Param("length") int length);

	List<TaHouse> selectRefreshBroker(@Param("start") Timestamp start, @Param("end") Timestamp end);

	List<TaHouse> selectByUpdateTime(@Param("updateTime") Timestamp updateTime, @Param("start") int start, @Param("length") int length);

	List<TaHouse> selectAllEffeciveHouse(@Param("start") int start, @Param("length") int length);

	int count();

}