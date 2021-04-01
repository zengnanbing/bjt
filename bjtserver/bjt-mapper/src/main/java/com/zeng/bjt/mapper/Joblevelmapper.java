package com.zeng.bjt.mapper;

import com.zeng.bjt.model.Joblevel;

public interface Joblevelmapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Joblevel record);

    int insertSelective(Joblevel record);

    Joblevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Joblevel record);

    int updateByPrimaryKey(Joblevel record);
}