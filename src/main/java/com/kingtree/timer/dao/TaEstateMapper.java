package com.kingtree.timer.dao;

import com.kingtree.timer.entity.TaEstate;

public interface TaEstateMapper {
    int deleteByPrimaryKey(String estateid);

    int insert(TaEstate record);

    int insertSelective(TaEstate record);

    TaEstate selectByPrimaryKey(String estateid);

    int updateByPrimaryKeySelective(TaEstate record);

    int updateByPrimaryKey(TaEstate record);
}