package com.kingtree.timer.dao;

import java.util.List;

import com.kingtree.timer.entity.TaAttachment;

public interface TaAttachmentMapper {
	int deleteByPrimaryKey(String attachmentid);

	int insert(TaAttachment record);

	int insertSelective(TaAttachment record);

	TaAttachment selectByPrimaryKey(String attachmentid);

	int updateByPrimaryKeySelective(TaAttachment record);

	int updateByPrimaryKey(TaAttachment record);

	List<TaAttachment> selectByBelongId(String belongId);
}