package com.kingtree.timer.dao;

import com.kingtree.timer.entity.TaBuilding;

public interface TaBuildingMapper {
    int deleteByPrimaryKey(String buildingid);

    int insert(TaBuilding record);

    int insertSelective(TaBuilding record);

    TaBuilding selectByPrimaryKey(String buildingid);

    int updateByPrimaryKeySelective(TaBuilding record);

    int updateByPrimaryKey(TaBuilding record);
}