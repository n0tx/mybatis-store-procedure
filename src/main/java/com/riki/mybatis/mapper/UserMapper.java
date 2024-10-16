package com.riki.mybatis.mapper;

import com.riki.mybatis.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    void insertUser(User user);

    List<User> getAllUsers();
}
