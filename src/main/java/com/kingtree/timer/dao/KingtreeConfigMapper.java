package com.kingtree.timer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kingtree.timer.entity.KingtreeConfig;

public interface KingtreeConfigMapper {
	int deleteByPrimaryKey(String id);

	int insert(KingtreeConfig record);

	int insertSelective(KingtreeConfig record);

	KingtreeConfig selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(KingtreeConfig record);

	int updateByPrimaryKey(KingtreeConfig record);

	List<KingtreeConfig> selectByGroupId(@Param("groupId") String groupId);
}