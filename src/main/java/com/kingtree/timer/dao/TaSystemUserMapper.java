package com.kingtree.timer.dao;

import com.kingtree.timer.entity.TaSystemUser;

public interface TaSystemUserMapper {
    int deleteByPrimaryKey(String uid);

    int insert(TaSystemUser record);

    int insertSelective(TaSystemUser record);

    TaSystemUser selectByPrimaryKey(String uid);

    int updateByPrimaryKeySelective(TaSystemUser record);

    int updateByPrimaryKey(TaSystemUser record);
}