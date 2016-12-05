package com.kingtree.timer.dao;

import com.kingtree.timer.entity.TaDepartment;

public interface TaDepartmentMapper {
    int deleteByPrimaryKey(String deptid);

    int insert(TaDepartment record);

    int insertSelective(TaDepartment record);

    TaDepartment selectByPrimaryKey(String deptid);

    int updateByPrimaryKeySelective(TaDepartment record);

    int updateByPrimaryKey(TaDepartment record);
}