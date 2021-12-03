package com.mj.dao;

import com.mj.pojo.User;
import com.mj.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

/**
 * @author : MaJ
 * @date : 2021/11/8
 * @description ：测试类
 */
public class UserDaoTest {
    private Logger logger = Logger.getLogger(UserDaoTest.class);

    @Test
    public void getUserList() {
        // 1. 获得 SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 2. 获取mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 3. 执行SQL
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }

        // 4. 关闭 SqlSession
        sqlSession.close();
    }

    @Test
    public void testLog4j() {
        logger.info("info：进入了testLog4j");
        logger.debug("debug：进入了testLog4j");
        logger.error("error：进入了testLog4j");
    }

}
