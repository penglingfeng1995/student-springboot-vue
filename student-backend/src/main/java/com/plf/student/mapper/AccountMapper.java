package com.plf.student.mapper;

import com.plf.student.model.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMapper {
    Account getAccountByUsername(@Param("username") String username);

    Integer addUser(@Param("username") String username,@Param("password") String password);
}
