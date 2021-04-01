package com.zeng.bjt.mapper;

import com.zeng.bjt.model.Employeetrain;

public interface Employeetrainmapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employeetrain record);

    int insertSelective(Employeetrain record);

    Employeetrain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employeetrain record);

    int updateByPrimaryKey(Employeetrain record);
}