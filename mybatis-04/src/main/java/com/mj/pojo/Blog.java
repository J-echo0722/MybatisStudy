package com.mj.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author : MaJ
 * @date : 2021/11/19
 * @description ：Blog 实体类 对应表 mybatis.blog
 */
@Data
public class Blog {
    private Long id;
    private String title;
    private String author;
    private Long views;
    private Date createTime;
    private Date updateTime;
}
