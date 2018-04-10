package com.example.demo.service;


import com.example.demo.entity.School;

import java.util.List;

public interface SchoolService {

	/**
	 * 获取School列表
	 * 
	 * @return
	 */
	List<School> getSchoolList();

	/**
	 * 通过SchoolId获取School信息
	 * 
	 * @param SchoolId
	 * @return
	 */
	School getSchoolById(int SchoolId);

	/**
	 * 增加School信息
	 * 
	 * @param School
	 * @return
	 */
	boolean addSchool(School School);

	/**
	 * 修改School信息
	 * 
	 * @param School
	 * @return
	 */
	boolean modifySchool(School School);

	/**
	 * 删除School信息
	 * 
	 * @param SchoolId
	 * @return
	 */
	boolean deleteSchool(int SchoolId);

}
