package com.plf.student.service;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    Integer addUser(String username, String password);
}
