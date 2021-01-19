package com.xzx.dao;

import com.xzx.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    // 查询全部用户
    List<User> getUserList();

    // todo 增删改查

    //根据id查询用户
    User getUserById(int id);

    // 通过Map实现根据id查询用户 (推荐)
    User getUserIdByMap(Map<String, Object> map);

    // 插入一个用户
    int addUser(User user);

    // 通过Map实现插入一个用户 (推荐)
    int addUserByMap(Map<String, Object> map);

    // 修改用户
    int updateUser(User user);

    //删除用户
    int deleteUser(int id);

    // 模糊查询like
    List<User> getUserLike(String value);

}
