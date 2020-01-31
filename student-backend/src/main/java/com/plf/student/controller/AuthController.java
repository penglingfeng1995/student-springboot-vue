package com.plf.student.controller;

import com.plf.student.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("auth")
@Slf4j
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping("isLogin")
    public Map<String, Object> isLogin() {
        Map<String, Object> result = new HashMap<>();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            result.put("isLogin", false);
            return result;
        }
        result.put("isLogin", true);
        result.put("username", authentication.getPrincipal());
        return result;
    }

    @RequestMapping("login")
    public Map<String, Object> login(String username, String password) {
        Map<String, Object> result = new HashMap<>(2);
        UserDetails userDetails = null;
        try {
            userDetails = userService.loadUserByUsername(username);
        } catch (UsernameNotFoundException e) {
            String msg = "用户 " + username + " 不存在";
            log.error(msg);
            result.put("status", false);
            result.put("msg", msg);
            return result;
        }
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());
        try {
            authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(token);
            result.put("status", true);
            result.put("msg", "登录成功");
        } catch (AuthenticationException e) {
            log.error("认证错误" + username);
            result.put("status", false);
            result.put("msg", "密码错误");
        }
        return result;
    }

    @RequestMapping("register")
    public Map<String, Object> register(String username, String password) {
        Map<String, Object> result = new HashMap<>();
        Integer count = userService.addUser(username, password);
        if (count != 0) {
            result.put("status", true);
        } else {
            result.put("status", false);
        }
        return result;
    }
}
