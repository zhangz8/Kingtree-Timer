package com.kingtree.timer.dao;

import com.kingtree.timer.entity.KingtreeTaPicearea;

public interface KingtreeTaPiceareaMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(KingtreeTaPicearea record);

	int insertSelective(KingtreeTaPicearea record);

	KingtreeTaPicearea selectByPrimaryKey(Integer id);

	KingtreeTaPicearea selectByPiceareaId(String piceareaId);

	int updateByPrimaryKeySelective(KingtreeTaPicearea record);

	int updateByPrimaryKey(KingtreeTaPicearea record);
}