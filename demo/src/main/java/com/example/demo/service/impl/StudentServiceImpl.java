package com.example.demo.service.impl;

import com.example.demo.dao.StudentDao;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;

	@Override
	public List<Student> getStudentList() {
		// 返回所有的Student信息
		return studentDao.queryStudent();
	}

	@Override
	public Student getStudentById(int studentId) {
		return studentDao.queryStudentById(studentId);
	}

	@Transactional
	@Override
	public boolean addStudent(Student student) {
		// 空值判断，主要是判断StudentName不为空
//		if (student.getName() != null && !"".equals(student.getName())) {
			// 设置默认值

			if (studentDao.queryStudentByNumber(student.getNumber()) !=null){
				throw new RuntimeException("手机号已经存在!");
			}

			try {
				int effectedNum = studentDao.insertStudent(student);
				if (effectedNum > 0) {
					return true;
				} else {
					throw new RuntimeException("添加Student信息失败!");
				}
			} catch (Exception e) {
				throw new RuntimeException("添加Student信息失败:" + e.toString());
			}
//		} else {
//			throw new RuntimeException("Student信息不能为空！");
//		}
	}

	@Transactional
	@Override
	public boolean modifyStudent(Student student) {
		// 空值判断，主要是StudentId不为空
		if (student.getId() != null && student.getId() > 0) {
			// 设置默认值
//			student.setLastEditTime(new Date());
			try {
				// 更新Student信息
				int effectedNum = studentDao.updateStudent(student);
				if (effectedNum > 0) {
					return true;
				} else {
					throw new RuntimeException("更新Student信息失败!");
				}
			} catch (Exception e) {
				throw new RuntimeException("更新Student信息失败:" + e.toString());
			}
		} else {
			throw new RuntimeException("Student信息不能为空！");
		}
	}

	@Transactional
	@Override
	public boolean deleteStudent(int studentId) {
		if (studentId > 0) {
			try {
				// 删除Student信息
				int effectedNum = studentDao.deleteStudent(studentId);
				if (effectedNum > 0) {
					return true;
				} else {
					throw new RuntimeException("删除Student信息失败!");
				}
			} catch (Exception e) {
				throw new RuntimeException("删除Student信息失败:" + e.toString());
			}
		} else {
			throw new RuntimeException("StudentId不能为空！");
		}
	}

	@Override
	public Student queryStudentByPassword(String number, String password) {
		Student student = studentDao.queryStudentByNumber(number);

//		Student student = studentDao.queryStudentByPassword(number, password);
		if (student == null){
			throw new RuntimeException("查无此人");
		}else {
			if (student.getPassword().equals(password)) {
				return student;
			}else {
				throw new RuntimeException("密码错误");
			}

		}
	}
}
