package com.kingtree.timer.dao;

import com.kingtree.timer.entity.TaBuildingUnit;

public interface TaBuildingUnitMapper {
    int deleteByPrimaryKey(String unitid);

    int insert(TaBuildingUnit record);

    int insertSelective(TaBuildingUnit record);

    TaBuildingUnit selectByPrimaryKey(String unitid);

    int updateByPrimaryKeySelective(TaBuildingUnit record);

    int updateByPrimaryKey(TaBuildingUnit record);
}