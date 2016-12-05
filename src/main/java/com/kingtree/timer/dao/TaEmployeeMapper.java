package com.kingtree.timer.dao;

import org.apache.ibatis.annotations.Param;

import com.kingtree.timer.entity.TaEmployee;

public interface TaEmployeeMapper {
	int deleteByPrimaryKey(String empid);

	int insert(TaEmployee record);

	int insertSelective(TaEmployee record);

	TaEmployee selectByPrimaryKey(String empid);

	int updateByPrimaryKeySelective(TaEmployee record);

	int updateByPrimaryKey(TaEmployee record);

	TaEmployee selectByUserId(@Param("userId") String userId);
}