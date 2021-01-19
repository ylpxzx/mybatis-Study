package com.xzx.dao;

import com.xzx.pojo.User;
import com.xzx.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    @Test
    public void allUser() {
        // 获取所有用户数据

        // 获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 方式一：getMapper (推荐)
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();

        // 方式二： 不推荐使用
//        List<User> userList = sqlSession.selectList("com.xzx.dao.UserDao.getUserList");

        for (User user : userList) {
            System.out.println(user);
        }

        // 关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void getUserById() {
        // 根据ID查询用户

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 方式一：getMapper (推荐)
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();

    }

    // 测试采用map实现的查询操作 (推荐)
    @Test
    public void getUserIdByMap() {
        // 根据ID查询用户

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 方式一：getMapper (推荐)
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userid", 5);

        User user = mapper.getUserIdByMap(map);
        System.out.println(user);
        sqlSession.close();

    }

    // todo 增删改需要提交事务

    @Test
    public void addUser() {
        // 插入一个用户

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 方式一：getMapper (推荐)
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int res = mapper.addUser(new User(4, "倪浩", "147547"));
        if (res > 0) {
            System.out.println("插入成功！");
        }

        //提交事务
        sqlSession.commit();
        sqlSession.close();

    }


    // 测试采用map实现的插入操作 (推荐)
    @Test
    public void addUserByMap() {
        // 插入一个用户

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 方式一：getMapper (推荐)
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("userid", 5);
        map.put("username", "撒大苏打");
        map.put("password", "12851");

        mapper.addUserByMap(map);

        //提交事务
        sqlSession.commit();
        sqlSession.close();

    }


    @Test
    public void updateUser() {
        // 修改用户

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 方式一：getMapper (推荐)
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.updateUser(new User(5, "撒大苏打", "12851"));

        //提交事务
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void deleteUser() {
        // 删除用户

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 方式一：getMapper (推荐)
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.deleteUser(2);

        //提交事务
        sqlSession.commit();
        sqlSession.close();

    }

    // todo 模糊查询
    @Test
    public void getUserLike() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 方式一：getMapper (推荐)
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserLike("李");
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();

    }

}
