package com.zeng.bjt.mapper;

import com.zeng.bjt.model.Role;
import com.zeng.bjt.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteById(Integer id);

    int insert(User user);

    int insertSelective(User record);

    User selectUserById(Integer userid);

    int updateByIdSelective(User record);

    int updateById(User record);

    User loadUserByUsername(String s);

    List<Role> getUserRolesById(Integer id);

    List<User> getAllUser(@Param("userid") Integer userid,@Param("keywords") String keywords);

    List<User> getAllUserExceptCurrentUser(Integer id);
    Integer updatePasswd(@Param("userid") Integer userid, @Param("encodePass") String encodePass);

    Integer updateUserface(@Param("url") String url, @Param("id") Integer id);






}
