package com.mj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : MaJ
 * @date : 2021/11/15
 * @description ：学生实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private Integer id;

    private String name;
    /**
     * 学生关联一个老师
     */
    private Teacher teacher;
}
