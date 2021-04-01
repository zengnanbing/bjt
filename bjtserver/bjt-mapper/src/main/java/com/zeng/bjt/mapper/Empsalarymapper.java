package com.zeng.bjt.mapper;

import com.zeng.bjt.model.Empsalary;

public interface Empsalarymapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Empsalary record);

    int insertSelective(Empsalary record);

    Empsalary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Empsalary record);

    int updateByPrimaryKey(Empsalary record);
}