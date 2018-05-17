package com.example.demo.service.impl;

import com.example.demo.dao.CompanyDao;
import com.example.demo.dao.JobDao;
import com.example.demo.dao.StudentDao;
import com.example.demo.dao.StudentJobDao;
import com.example.demo.entity.Company;
import com.example.demo.entity.Job;
import com.example.demo.entity.Student;
import com.example.demo.entity.StudentJob;
import com.example.demo.service.StudentJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentJobServiceImpl implements StudentJobService {
    @Autowired
    private StudentJobDao studentJobDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private JobDao jobDao;

    @Autowired
    private CompanyDao companyDao;

    @Transactional
    @Override
    public void addStudentJob(StudentJob studentJob) {
        Integer studentId = studentJob.getStudentId();


        List<StudentJob> studentJobs = studentJobDao.queryJob(studentId);
        if (!studentJobs.isEmpty()) {
            for (StudentJob job : studentJobs) {
                if (job.getJobId().equals(studentJob.getJobId()))
                    throw new RuntimeException("已经投递");
            }
        }

        studentJobDao.insertStudentJob(studentJob);

    }

    @Override
    public List<Student> queryStudent(int jobId) {
        List<Student> studentList = new ArrayList<>();
        List<StudentJob> studentJobs = studentJobDao.queryStudent(jobId);

        for (StudentJob studentJob : studentJobs) {
            Student student = studentDao.queryStudentById(studentJob.getStudentId());
            if (student != null) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    @Override
    public List<Map> queryJob(int studentId) {
        List<Map> jobList = new ArrayList<>();
        List<StudentJob> studentJobs = studentJobDao.queryJob(studentId);
        for (StudentJob studentJob : studentJobs) {
            Job job = jobDao.queryJobById(studentJob.getJobId());
            if (job != null) {
                Company company = companyDao.queryCompanyById(Integer.parseInt(job.getCompanyId()));
                if (company != null) {
                    Map<String, Object> map = new HashMap<>();
                    map.put("job", job);
                    map.put("company", company);
                    jobList.add(map);
                }
            }

        }
        return jobList;
    }
}
