package com.mj.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author : MaJ
 * @date : 2021/11/8
 * @description ：工厂模式  sqlSessionFactory --> sqlSession
 */
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            // 使用 Mybatis 第一步：获取 SqlSessionFactory 对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取 SqlSession 的实例，该实例包含了面向数据库执行 SQL 命令所需的所有方法
     */
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }

}
