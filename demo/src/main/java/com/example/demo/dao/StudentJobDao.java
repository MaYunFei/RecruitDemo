package com.example.demo.dao;

import com.example.demo.entity.StudentJob;

import java.util.List;

public interface StudentJobDao {


    List<StudentJob> queryStudent(int jobId);

    List<StudentJob> queryJob(int studentId);

    int insertStudentJob(StudentJob studentJob);


}
