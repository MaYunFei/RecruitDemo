package com.example.demo.service;


import com.example.demo.entity.Student;
import com.example.demo.entity.StudentJob;

import java.util.List;
import java.util.Map;

public interface StudentJobService {
    void addStudentJob(StudentJob studentJob);

    List<Student> queryStudent(int jobId);

    List<Map> queryJob(int studentId);
}
