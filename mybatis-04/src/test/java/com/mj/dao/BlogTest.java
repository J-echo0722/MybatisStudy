package com.mj.dao;

import com.mj.pojo.Blog;
import com.mj.pojo.PageHelper;
import com.mj.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * @author : MaJ
 * @date : 2021/11/19
 * @description ：Blog 测试类
 */
public class BlogTest {
    @Test
    public void selectByID() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = mapper.selectById(1L);
        System.out.println(blog);

        sqlSession.close();
    }

    @Test
    public void selectListByPage() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        PageHelper page = new PageHelper();
        page.setStart(0);
        page.setPageSize(4);
        List<Blog> blogs = mapper.selectBlogListByPage(new Blog(), page);

        System.out.println(blogs);

        sqlSession.close();
    }

    @Test
    public void insert() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog insertDo = new Blog();
        insertDo.setAuthor("小红");
        insertDo.setTitle("hhh");
        insertDo.setViews(12L);

        int insert = mapper.insert(insertDo);
        System.out.println(insert);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void update() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog updateDo = new Blog();
        updateDo.setId(1L);
        updateDo.setAuthor("小小小");
        updateDo.setTitle("new new new");
        updateDo.setViews(1L);

        int update = mapper.update(updateDo);
        System.out.println(update);

        sqlSession.commit();
        sqlSession.close();
    }
}
