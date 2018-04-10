package com.example.demo.service.impl;

import com.example.demo.dao.MajorDao;
import com.example.demo.entity.Major;
import com.example.demo.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MajorServiceImpl implements MajorService {
	@Autowired
	private MajorDao majorDao;

	@Override
	public List<Major> getMajorList() {
		// 返回所有的Major信息
		return majorDao.queryMajor();
	}

	@Override
	public Major getMajorById(int majorId) {
		return majorDao.queryMajorById(majorId);
	}

	@Transactional
	@Override
	public boolean addMajor(Major major) {
		// 空值判断，主要是判断MajorName不为空
		if (major.getName() != null && !"".equals(major.getName())) {
			// 设置默认值
			try {
				int effectedNum = majorDao.insertMajor(major);
				if (effectedNum > 0) {
					return true;
				} else {
					throw new RuntimeException("添加Major信息失败!");
				}
			} catch (Exception e) {
				throw new RuntimeException("添加Major信息失败:" + e.toString());
			}
		} else {
			throw new RuntimeException("Major信息不能为空！");
		}
	}

	@Transactional
	@Override
	public boolean modifyMajor(Major major) {
		// 空值判断，主要是MajorId不为空
		if (major.getId() != null && major.getId() > 0) {
			// 设置默认值
//			major.setLastEditTime(new Date());
			try {
				// 更新Major信息
				int effectedNum = majorDao.updateMajor(major);
				if (effectedNum > 0) {
					return true;
				} else {
					throw new RuntimeException("更新Major信息失败!");
				}
			} catch (Exception e) {
				throw new RuntimeException("更新Major信息失败:" + e.toString());
			}
		} else {
			throw new RuntimeException("Major信息不能为空！");
		}
	}

	@Transactional
	@Override
	public boolean deleteMajor(int majorId) {
		if (majorId > 0) {
			try {
				// 删除Major信息
				int effectedNum = majorDao.deleteMajor(majorId);
				if (effectedNum > 0) {
					return true;
				} else {
					throw new RuntimeException("删除Major信息失败!");
				}
			} catch (Exception e) {
				throw new RuntimeException("删除Major信息失败:" + e.toString());
			}
		} else {
			throw new RuntimeException("MajorId不能为空！");
		}
	}
}
