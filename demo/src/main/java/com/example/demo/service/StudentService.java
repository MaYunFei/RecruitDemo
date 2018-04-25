package com.example.demo.service;


import com.example.demo.entity.Student;

import java.util.List;

public interface StudentService {

	/**
	 * 获取Student列表
	 * 
	 * @return
	 */
	List<Student> getStudentList();

	/**
	 * 通过StudentId获取Student信息
	 * 
	 * @param StudentId
	 * @return
	 */
	Student getStudentById(int StudentId);

	/**
	 * 增加Student信息
	 * 
	 * @param Student
	 * @return
	 */
	boolean addStudent(Student Student);

	/**
	 * 修改Student信息
	 * 
	 * @param Student
	 * @return
	 */
	boolean modifyStudent(Student Student);

	/**
	 * 删除Student信息
	 * 
	 * @param StudentId
	 * @return
	 */
	boolean deleteStudent(int StudentId);


	Student queryStudentByPassword(String number, String password);

}
