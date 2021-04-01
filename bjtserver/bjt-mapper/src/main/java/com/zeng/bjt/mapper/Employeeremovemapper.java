package com.zeng.bjt.mapper;

import com.zeng.bjt.model.Employeeremove;

public interface Employeeremovemapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employeeremove record);

    int insertSelective(Employeeremove record);

    Employeeremove selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employeeremove record);

    int updateByPrimaryKey(Employeeremove record);
}