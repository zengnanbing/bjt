package com.zeng.bjt.web.controller;

import com.zeng.bjt.model.RespBean;
import com.zeng.bjt.model.User;
import com.zeng.bjt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    UserService userService;

    @GetMapping("/info")
    public User getCurrentUser(Authentication authentication) {
        return (User) authentication.getPrincipal();
    }

    @PutMapping("/info")
    public RespBean updateUser(@RequestBody User user, Authentication authentication) {
        if (userService.updateUser(user) == 1) {
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user, authentication.getCredentials(), authentication.getAuthorities()));
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @PutMapping("/pass")
    public RespBean updatePasswd(@RequestBody Map<String, Object> info) {
        String oldPasswd = (String) info.get("oldpass");
        String newPasswd = (String) info.get("newpass");
        Integer userid = (Integer) info.get("userid");
        if (userService.updatePasswd(oldPasswd,newPasswd,userid) == 1){
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

}
