package com.kingtree.timer.dao;

import com.kingtree.timer.entity.KingtreeTaSystemuser;

public interface KingtreeTaSystemuserMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(KingtreeTaSystemuser record);

	int insertSelective(KingtreeTaSystemuser record);

	KingtreeTaSystemuser selectByPrimaryKey(Integer id);

	KingtreeTaSystemuser selectByUserId(String userId);

	int updateByPrimaryKeySelective(KingtreeTaSystemuser record);

	int updateByPrimaryKey(KingtreeTaSystemuser record);
}