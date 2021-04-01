package com.zeng.bjt.mapper;

import com.zeng.bjt.model.Msgcontent;

public interface Msgcontentmapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Msgcontent record);

    int insertSelective(Msgcontent record);

    Msgcontent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Msgcontent record);

    int updateByPrimaryKey(Msgcontent record);
}