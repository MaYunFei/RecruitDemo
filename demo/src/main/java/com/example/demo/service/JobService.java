package com.example.demo.service;


import com.example.demo.entity.Job;

import java.util.List;

public interface JobService {

	/**
	 * 获取Job列表
	 * 
	 * @return
	 */
	List<Job> getJobList();

	/**
	 * 通过JobId获取Job信息
	 * 
	 * @param JobId
	 * @return
	 */
	Job getJobById(int JobId);

	/**
	 * 增加Job信息
	 * 
	 * @param Job
	 * @return
	 */
	boolean addJob(Job Job);

	/**
	 * 修改Job信息
	 * 
	 * @param Job
	 * @return
	 */
	boolean modifyJob(Job Job);

	/**
	 * 删除Job信息
	 * 
	 * @param JobId
	 * @return
	 */
	boolean deleteJob(int JobId);

}
