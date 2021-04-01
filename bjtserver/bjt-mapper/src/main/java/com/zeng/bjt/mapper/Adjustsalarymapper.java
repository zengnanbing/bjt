package com.zeng.bjt.mapper;

import com.zeng.bjt.model.Adjustsalary;

public interface Adjustsalarymapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Adjustsalary record);

    int insertSelective(Adjustsalary record);

    Adjustsalary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Adjustsalary record);

    int updateByPrimaryKey(Adjustsalary record);
}