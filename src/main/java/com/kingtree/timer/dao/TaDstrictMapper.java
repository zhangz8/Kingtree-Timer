package com.kingtree.timer.dao;

import com.kingtree.timer.entity.TaDstrict;

public interface TaDstrictMapper {
    int deleteByPrimaryKey(String dsid);

    int insert(TaDstrict record);

    int insertSelective(TaDstrict record);

    TaDstrict selectByPrimaryKey(String dsid);

    int updateByPrimaryKeySelective(TaDstrict record);

    int updateByPrimaryKey(TaDstrict record);
}