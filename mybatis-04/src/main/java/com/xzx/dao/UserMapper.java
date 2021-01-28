package com.xzx.dao;

import com.xzx.pojo.User;

public interface UserMapper {
    //根据id查询用户
    User getUserById(int id);
}
