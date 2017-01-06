package com.kingtree.timer.service;

import java.sql.Timestamp;

import com.kingtree.timer.service.exception.IndexException;

public interface IndexService {

	/**
	 * 创建索引
	 * 
	 * @param updateTime
	 * @throws IndexException
	 */
	void createIndex(Timestamp updateTime) throws IndexException;

	/**
	 * 更新索引<br>
	 * 1、查找修改时间大于updateTime房源 <br>
	 * 2、删除索引 <br>
	 * 3、增加索引<br>
	 * 
	 * @param updateTime
	 * @throws IndexException
	 */
	void updateIndex(Timestamp updateTime) throws IndexException;

}
