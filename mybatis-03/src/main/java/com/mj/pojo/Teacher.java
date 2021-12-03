package com.mj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author : MaJ
 * @date : 2021/11/15
 * @description ：老师实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    private Integer id;

    private String name;

    private List<Student> students;
}
