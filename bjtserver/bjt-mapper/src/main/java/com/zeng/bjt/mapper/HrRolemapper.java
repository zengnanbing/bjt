package com.zeng.bjt.mapper;

import com.zeng.bjt.model.userRole;

public interface userRolemapper {
    int deleteByPrimaryKey(Integer id);

    int insert(userRole record);

    int insertSelective(userRole record);

    userRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(userRole record);

    int updateByPrimaryKey(userRole record);
}