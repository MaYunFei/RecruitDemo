package com.example.demo.service.impl;

import com.example.demo.dao.SchoolDao;
import com.example.demo.entity.School;
import com.example.demo.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {
	@Autowired
	private SchoolDao schoolDao;

	@Override
	public List<School> getSchoolList() {
		// 返回所有的School信息
		return schoolDao.querySchool();
	}

	@Override
	public School getSchoolById(int schoolId) {
		return schoolDao.querySchoolById(schoolId);
	}

	@Transactional
	@Override
	public boolean addSchool(School school) {
		// 空值判断，主要是判断SchoolName不为空
		if (school.getTeacher() != null && !"".equals(school.getTeacher())) {
			// 设置默认值
			try {
				int effectedNum = schoolDao.insertSchool(school);
				if (effectedNum > 0) {
					return true;
				} else {
					throw new RuntimeException("添加School信息失败!");
				}
			} catch (Exception e) {
				throw new RuntimeException("添加School信息失败:" + e.toString());
			}
		} else {
			throw new RuntimeException("School信息不能为空！");
		}
	}

	@Transactional
	@Override
	public boolean modifySchool(School school) {
		// 空值判断，主要是SchoolId不为空
		if (school.getId() != null && school.getId() > 0) {
			// 设置默认值
//			school.setLastEditTime(new Date());
			try {
				// 更新School信息
				int effectedNum = schoolDao.updateSchool(school);
				if (effectedNum > 0) {
					return true;
				} else {
					throw new RuntimeException("更新School信息失败!");
				}
			} catch (Exception e) {
				throw new RuntimeException("更新School信息失败:" + e.toString());
			}
		} else {
			throw new RuntimeException("School信息不能为空！");
		}
	}

	@Transactional
	@Override
	public boolean deleteSchool(int schoolId) {
		if (schoolId > 0) {
			try {
				// 删除School信息
				int effectedNum = schoolDao.deleteSchool(schoolId);
				if (effectedNum > 0) {
					return true;
				} else {
					throw new RuntimeException("删除School信息失败!");
				}
			} catch (Exception e) {
				throw new RuntimeException("删除School信息失败:" + e.toString());
			}
		} else {
			throw new RuntimeException("SchoolId不能为空！");
		}
	}
}
