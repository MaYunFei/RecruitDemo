package com.example.demo.dao;

import com.example.demo.entity.Job;

import java.util.List;

public interface JobDao {
    /**
     * 列出Job列表
     *
     * @return JobList
     */
    List<Job> queryJob();

    /**
     * 根据Id列出具体Job
     *
     * @return Job
     */
    Job queryJobById(int JobId);

    /**
     * 插入Job信息
     *
     * @param Job
     * @return
     */
    int insertJob(Job Job);

    /**
     * 更新Job信息
     *
     * @param Job
     * @return
     */
    int updateJob(Job Job);

    /**
     * 删除Job信息
     *
     * @param JobId
     * @return
     */
    int deleteJob(int JobId);

    List<Job> queryJobByCompanyId(int companyId);
}
