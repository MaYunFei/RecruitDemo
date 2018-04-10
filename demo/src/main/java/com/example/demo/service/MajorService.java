package com.example.demo.service;


import com.example.demo.entity.Major;

import java.util.List;

public interface MajorService {

	/**
	 * 获取Major列表
	 * 
	 * @return
	 */
	List<Major> getMajorList();

	/**
	 * 通过MajorId获取Major信息
	 * 
	 * @param MajorId
	 * @return
	 */
	Major getMajorById(int MajorId);

	/**
	 * 增加Major信息
	 * 
	 * @param Major
	 * @return
	 */
	boolean addMajor(Major Major);

	/**
	 * 修改Major信息
	 * 
	 * @param Major
	 * @return
	 */
	boolean modifyMajor(Major Major);

	/**
	 * 删除Major信息
	 * 
	 * @param MajorId
	 * @return
	 */
	boolean deleteMajor(int MajorId);

}
