package com.example.demo.dao;

import com.example.demo.entity.StudentJob;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 按方法名大小升序执行
public class StudentJobDaoTest {
    @Autowired
    private StudentJobDao studentJobDao;

    @Test
    public void queryStudent() {
    }

    @Test
    public void queryJob() {
    }

    @Test
    public void insertStudentJob() {
        StudentJob studentJob = new StudentJob();
        studentJob.setJobId(1);
        studentJob.setStudentId(19);
        studentJobDao.insertStudentJob(studentJob);
    }
}