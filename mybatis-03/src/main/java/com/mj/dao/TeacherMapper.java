package com.mj.dao;

import com.mj.pojo.Teacher;
import org.apache.ibatis.annotations.Param;


/**
 * @author : MaJ
 * @date : 2021/11/8
 * @description ：一对多测试，一个老师对应多个学生
 */
public interface TeacherMapper {

    Teacher getTeacher1(@Param("tid") Integer id);

    Teacher getTeacher(@Param("tid") Integer id);

}
