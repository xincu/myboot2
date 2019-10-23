package com.service.impl;

import com.dao.IUsers;
import com.entity.Users;
import com.service.IUsersService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@MapperScan(basePackages = "com.dao")
@Service("userService")

public class UsersService implements IUsersService{
    @Autowired
private IUsers is;
    public Users selectUser(){

        return null;
    }

}
