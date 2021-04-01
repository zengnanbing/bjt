package com.zeng.bjt.mapper;

import com.zeng.bjt.model.Sysmsg;

public interface Sysmsgmapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sysmsg record);

    int insertSelective(Sysmsg record);

    Sysmsg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sysmsg record);

    int updateByPrimaryKey(Sysmsg record);
}