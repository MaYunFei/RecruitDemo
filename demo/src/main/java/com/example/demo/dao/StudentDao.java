package com.example.demo.dao;

import com.example.demo.entity.Student;

import java.util.List;

public interface StudentDao {
    /**
     * 列出Company列表
     *
     * @return CompanyList
     */
    List<Student> queryStudent();

    /**
     * 根据Id列出具体Student
     *
     * @return Student
     */
    Student queryStudentById(int StudentId);

    /**
     * 插入Student信息
     *
     * @param Student
     * @return
     */
    int insertStudent(Student Student);

    /**
     * 更新Student信息
     *
     * @param Student
     * @return
     */
    int updateStudent(Student Student);

    /**
     * 删除Student信息
     *
     * @param StudentId
     * @return
     */
    int deleteStudent(int StudentId);


    Student queryStudentByPassword(String number, String password);
}
