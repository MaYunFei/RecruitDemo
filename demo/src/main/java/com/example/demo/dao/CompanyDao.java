package com.example.demo.dao;

import com.example.demo.entity.Company;
import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyDao {
	/**
	 * 列出Company列表
	 * 
	 * @return CompanyList
	 */
	List<Company> queryCompany();

	/**
	 * 根据Id列出具体Company
	 *
	 * @return Company
	 */
	Company queryCompanyById(int CompanyId);

	/**
	 * 插入Company信息
	 *
	 * @param Company
	 * @return
	 */
	int insertCompany(Company Company);

	/**
	 * 更新Company信息
	 *
	 * @param Company
	 * @return
	 */
	int updateCompany(Company Company);

	/**
	 * 删除Company信息
	 *
	 * @param CompanyId
	 * @return
	 */
	int deleteCompany(int CompanyId);


	Company queryCompanyByNumber(@Param("number") String number);
}
