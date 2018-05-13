package com.example.demo.service;


import com.example.demo.entity.Company;

import java.util.List;

public interface CompanyService {

	/**
	 * 获取Company列表
	 * 
	 * @return
	 */
	List<Company> getCompanyList();

	/**
	 * 通过CompanyId获取Company信息
	 * 
	 * @param CompanyId
	 * @return
	 */
	Company getCompanyById(int CompanyId);

	/**
	 * 增加Company信息
	 * 
	 * @param Company
	 * @return
	 */
	boolean addCompany(Company Company);

	/**
	 * 修改Company信息
	 * 
	 * @param Company
	 * @return
	 */
	boolean modifyCompany(Company Company);

	/**
	 * 删除Company信息
	 * 
	 * @param CompanyId
	 * @return
	 */
	boolean deleteCompany(int CompanyId);

	Company queryCompanyByNumber(String number,String password);

}
