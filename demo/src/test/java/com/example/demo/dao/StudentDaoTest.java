package com.example.demo.dao;

import com.example.demo.entity.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 按方法名大小升序执行
public class StudentDaoTest {

    //通过spring容器注入Dao的实现类
    @Autowired
    private StudentDao studentDao;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insertStudent() {
        Student student = new Student();
        student.setPassword("1234563");
        student.setId(null);
        student.setNumber("1510157839");
        studentDao.insertStudent(student);
        System.out.println(student.getId()+"  "+student.getPassword());
    }

    @Test
    public void queryStudentByNumber() {
        Student student = studentDao.queryStudentByNumber("15101578395");
        if (student == null){
            System.out.println("未查到此人");
        }else {
            System.out.println(student);
        }
    }
    @Test
    public void queryStudentByPassword() {
        Student student = studentDao.queryStudentByPassword("1234","");
        if (student == null){
            System.out.println("null ======");
        }else {
            System.out.println(student);
        }
    }

    @Test
    public void updateStudent() {
        Student student = studentDao.queryStudentByNumber("15101578395");
        student.setSchoolId("2");

        studentDao.updateStudent(student);
    }
}