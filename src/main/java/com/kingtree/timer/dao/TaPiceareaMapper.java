package com.kingtree.timer.dao;

import com.kingtree.timer.entity.TaPicearea;

public interface TaPiceareaMapper {
    int deleteByPrimaryKey(String areaid);

    int insert(TaPicearea record);

    int insertSelective(TaPicearea record);

    TaPicearea selectByPrimaryKey(String areaid);

    int updateByPrimaryKeySelective(TaPicearea record);

    int updateByPrimaryKey(TaPicearea record);
}