package com.xzx.dao;

import com.xzx.pojo.User;
import com.xzx.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserMapperTest {
    @Test
    public void allUser() {
        // 获取所有用户数据

        // 获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 方式一：getMapper (推荐)
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(1);

        // 方式二： 不推荐使用
//        List<User> userList = sqlSession.selectList("com.xzx.dao.UserDao.getUserList");

        System.out.println(user);
        // 关闭SqlSession
        sqlSession.close();
    }

}
