package com.zeng.bjt.mapper;

import com.zeng.bjt.model.Oplog;

public interface Oplogmapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Oplog record);

    int insertSelective(Oplog record);

    Oplog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Oplog record);

    int updateByPrimaryKey(Oplog record);
}