package com.example.demo.service.impl;

import com.example.demo.dao.JobDao;
import com.example.demo.entity.Job;
import com.example.demo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {
	@Autowired
	private JobDao jobDao;

	@Override
	public List<Job> getJobList() {
		// 返回所有的Job信息
		return jobDao.queryJob();
	}

	@Override
	public Job getJobById(int jobId) {
		return jobDao.queryJobById(jobId);
	}

	@Transactional
	@Override
	public boolean addJob(Job job) {
		// 空值判断，主要是判断JobName不为空
		if (job.getName() != null && !"".equals(job.getName())) {
			// 设置默认值
			try {
				int effectedNum = jobDao.insertJob(job);
				if (effectedNum > 0) {
					return true;
				} else {
					throw new RuntimeException("添加Job信息失败!");
				}
			} catch (Exception e) {
				throw new RuntimeException("添加Job信息失败:" + e.toString());
			}
		} else {
			throw new RuntimeException("Job信息不能为空！");
		}
	}

	@Transactional
	@Override
	public boolean modifyJob(Job job) {
		// 空值判断，主要是JobId不为空
		if (job.getId() != null && job.getId() > 0) {
			// 设置默认值
//			job.setLastEditTime(new Date());
			try {
				// 更新Job信息
				int effectedNum = jobDao.updateJob(job);
				if (effectedNum > 0) {
					return true;
				} else {
					throw new RuntimeException("更新Job信息失败!");
				}
			} catch (Exception e) {
				throw new RuntimeException("更新Job信息失败:" + e.toString());
			}
		} else {
			throw new RuntimeException("Job信息不能为空！");
		}
	}

	@Transactional
	@Override
	public boolean deleteJob(int jobId) {
		if (jobId > 0) {
			try {
				// 删除Job信息
				int effectedNum = jobDao.deleteJob(jobId);
				if (effectedNum > 0) {
					return true;
				} else {
					throw new RuntimeException("删除Job信息失败!");
				}
			} catch (Exception e) {
				throw new RuntimeException("删除Job信息失败:" + e.toString());
			}
		} else {
			throw new RuntimeException("JobId不能为空！");
		}
	}

	@Override
	public List<Job> getJobByCompanyId(int companyId) {

		List<Job> jobList = jobDao.queryJobByCompanyId(companyId);

		return jobList;
	}
}
