package com.kingtree.timer.dao;

import com.kingtree.timer.entity.TaHouseowner;

public interface TaHouseownerMapper {
    int deleteByPrimaryKey(String hwid);

    int insert(TaHouseowner record);

    int insertSelective(TaHouseowner record);

    TaHouseowner selectByPrimaryKey(String hwid);

    int updateByPrimaryKeySelective(TaHouseowner record);

    int updateByPrimaryKey(TaHouseowner record);
}