package com.kingtree.timer.dao;

import com.kingtree.timer.entity.KingtreeTaDepartment;

public interface KingtreeTaDepartmentMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(KingtreeTaDepartment record);

	int insertSelective(KingtreeTaDepartment record);

	KingtreeTaDepartment selectByPrimaryKey(Integer id);

	KingtreeTaDepartment selectByDepartmentId(String deptId);

	int updateByPrimaryKeySelective(KingtreeTaDepartment record);

	int updateByPrimaryKey(KingtreeTaDepartment record);
}