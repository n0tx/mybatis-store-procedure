package com.riki.mybatis.service;

import com.riki.mybatis.mapper.UserMapper;
import com.riki.mybatis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void addUser(User user) {
        userMapper.insertUser(user);
    }
}
