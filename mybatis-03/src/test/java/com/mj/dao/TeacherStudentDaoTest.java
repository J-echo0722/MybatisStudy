package com.mj.dao;

import com.mj.dao.StudentMapper;
import com.mj.dao.TeacherMapper;
import com.mj.pojo.Student;
import com.mj.pojo.Teacher;
import com.mj.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author : MaJ
 * @date : 2021/11/17
 * @description ：测试类
 */
public class TeacherStudentDaoTest {

    /**
     * 多对一查询，多个学生对应一个老师
     */
    @Test
    public void testStudent() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        // 子查询，按照查询嵌套处理
        List<Student> studentList1 = mapper.getStudentList1();
        for (Student student : studentList1) {
            System.out.println(student);
        }

        System.out.println("----------------------------------------------------------------");

        // 按照结果嵌套处理
        List<Student> studentList2 = mapper.getStudentList2();
        for (Student student : studentList2) {
            System.out.println(student);
        }

        sqlSession.close();

    }

    /**
     * 一对多测试，一个老师对应多个学生
     */
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        // 按照结果嵌套处理
        // Teacher(id=1, name=马老师, students=[Student(id=1, name=小明, teacher=null), Student(id=2, name=小红, teacher=null), Student(id=3, name=小张, teacher=null), Student(id=4, name=小李, teacher=null), Student(id=5, name=小王, teacher=null)])
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);

        System.out.println("----------------------------------------------------------------");


        Teacher teacher1 = mapper.getTeacher1(1);
        System.out.println(teacher1);

        sqlSession.close();

    }

}
