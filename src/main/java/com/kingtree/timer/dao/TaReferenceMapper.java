package com.kingtree.timer.dao;

import com.kingtree.timer.entity.TaReference;

public interface TaReferenceMapper {
    int deleteByPrimaryKey(String refid);

    int insert(TaReference record);

    int insertSelective(TaReference record);

    TaReference selectByPrimaryKey(String refid);

    int updateByPrimaryKeySelective(TaReference record);

    int updateByPrimaryKey(TaReference record);
}