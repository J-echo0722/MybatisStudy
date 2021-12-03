package com.mj.dao;

import com.mj.pojo.Blog;
import com.mj.pojo.PageHelper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : MaJ
 * @date : 2021/11/19
 * @description ：blogMapper 接口
 */
public interface BlogMapper {

    Blog selectById(@Param("id") Long id);

    List<Blog> selectBlogListByPage(@Param("model") Blog blog, @Param("page") PageHelper pageHelper);

    int insert(@Param("model") Blog blog);

    int update(@Param("model") Blog blog);

}
