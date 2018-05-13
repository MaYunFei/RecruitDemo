package com.example.demo.dao;

import com.example.demo.entity.Job;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 按方法名大小升序执行
public class JobDaoTest {

    //通过spring容器注入Dao的实现类
    @Autowired
    private JobDao jobDao;

    @Test
    public void queryJob() {
        List<Job> jobs = jobDao.queryJob();
        for (int i = 0; i < jobs.size(); i++) {
            System.out.println(jobs.get(i));
        }
    }

    @Test
    public void queryJobById() {
    }

    @Test
    public void insertJob() {
        Job job = new Job();
        job.setCompanyId("2");
        job.setName("Android 开发工程师");
        jobDao.insertJob(job);
    }

    @Test
    public void updateJob() {
    }

    @Test
    public void deleteJob() {
    }
}