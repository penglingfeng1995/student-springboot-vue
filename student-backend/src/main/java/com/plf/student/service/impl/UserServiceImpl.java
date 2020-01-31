package com.plf.student.service.impl;

import com.plf.student.mapper.AccountMapper;
import com.plf.student.model.Account;
import com.plf.student.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountMapper.getAccountByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        return new User(account.getUsername(), account.getPassword(), Collections.emptyList());
    }

    @Override
    public Integer addUser(String username, String password) {
        return accountMapper.addUser(username,passwordEncoder.encode(password));
    }
}
