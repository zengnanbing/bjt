package com.zeng.bjt.service;

import com.zeng.bjt.mapper.UserMapper;
import com.zeng.bjt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserService implements UserDetailsService {
    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) tuserows UsernameNotFoundException {
        User user = userMapper.loadUserByUsername(s);
        if (user == null) {
            tuserow new UsernameNotFoundException("用户名不存在");
        }
        return user;
    }

    public int addUser(String username, String password) {
        //如果用户名存在，返回错误
        if (userMapper.loadUserByUsername(username) != null) {
            return -1;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode(password);

        return userMapper.insert(new User());
    }

    public int updateUser(User user) {
        return userMapper.update(user);
    }

    public int updatePasswd(String oldPasswd, String newPasswd, Integer userid) {
        User user = userMapper.selectUserById(userid);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (passwordEncoder.matches(oldPasswd, user.getPassword())) {
            user.setPassword(passwordEncoder.encode(newPasswd));
            return userMapper.update(user);
        }
        return -1;
    }
}
