package com.kingtree.timer.dao;

import com.kingtree.timer.entity.TaCompany;

public interface TaCompanyMapper {
    int deleteByPrimaryKey(String comid);

    int insert(TaCompany record);

    int insertSelective(TaCompany record);

    TaCompany selectByPrimaryKey(String comid);

    int updateByPrimaryKeySelective(TaCompany record);

    int updateByPrimaryKey(TaCompany record);
}