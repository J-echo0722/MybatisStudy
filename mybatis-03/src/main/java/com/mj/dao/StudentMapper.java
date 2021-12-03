package com.mj.dao;

import com.mj.pojo.Student;

import java.util.List;

/**
 * @author : MaJ
 * @date : 2021/11/8
 * @description ：学生 mapper 接口，主要是 多对一 测试，多个学生对应一个老师
 */
public interface StudentMapper {

    /**
     * 子查询，查询嵌套处理
     */
    List<Student> getStudentList1();

    /**
     * 联合查询，结果嵌套处理
     */
    List<Student> getStudentList2();

}
