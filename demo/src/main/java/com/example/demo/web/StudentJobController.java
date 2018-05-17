package com.example.demo.web;

import com.example.demo.entity.StudentJob;
import com.example.demo.handler.SuccessHandle;
import com.example.demo.service.StudentJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/student_job")
public class StudentJobController {
    @Autowired
    private StudentJobService studentJobService;

    /**
     * 提交 简历
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    private Map add(int student_id, int job_id) {
        StudentJob studentJob = new StudentJob();
        studentJob.setStudentId(student_id);
        studentJob.setJobId(job_id);
        studentJobService.addStudentJob(studentJob);
        return SuccessHandle.success("投递成功");
    }

    /**
     * 获得这个工作下的投递人
     */
    @RequestMapping(value = "/getStudent/{job_id}", method = RequestMethod.GET)
    private Map getStudent(@PathVariable(value = "job_id") int job_id) {
        return SuccessHandle.success(studentJobService.queryStudent(job_id));
    }


    /**
     * 获得这个学生投递的工作
     */
    @RequestMapping(value = "/getJob/{student_id}", method = RequestMethod.GET)
    private Map getJob(@PathVariable(value = "student_id") int student_id) {
        return SuccessHandle.success(studentJobService.queryJob(student_id));
    }

}
