package com.example.demo.service.impl;

import com.example.demo.dao.CompanyDao;
import com.example.demo.entity.Company;
import com.example.demo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	private CompanyDao companyDao;

	@Override
	public List<Company> getCompanyList() {
		// 返回所有的Company信息
		return companyDao.queryCompany();
	}

	@Override
	public Company getCompanyById(int companyId) {
		return companyDao.queryCompanyById(companyId);
	}

	@Transactional
	@Override
	public boolean addCompany(Company company) {
		// 空值判断，主要是判断CompanyName不为空
//		if (company.getName() != null && !"".equals(company.getName())) {
			// 设置默认值
			try {
				int effectedNum = companyDao.insertCompany(company);
				if (effectedNum > 0) {
					return true;
				} else {
					throw new RuntimeException("添加Company信息失败!");
				}
			} catch (Exception e) {
				throw new RuntimeException("添加Company信息失败:" + e.toString());
			}
//		} else {
//			throw new RuntimeException("Company信息不能为空！");
//		}
	}

	@Transactional
	@Override
	public boolean modifyCompany(Company company) {
		// 空值判断，主要是CompanyId不为空
		if (company.getId() != null && company.getId() > 0) {
			// 设置默认值
//			company.setLastEditTime(new Date());
			try {
				// 更新Company信息
				int effectedNum = companyDao.updateCompany(company);
				if (effectedNum > 0) {
					return true;
				} else {
					throw new RuntimeException("更新Company信息失败!");
				}
			} catch (Exception e) {
				throw new RuntimeException("更新Company信息失败:" + e.toString());
			}
		} else {
			throw new RuntimeException("Company信息不能为空！");
		}
	}

	@Transactional
	@Override
	public boolean deleteCompany(int companyId) {
		if (companyId > 0) {
			try {
				// 删除Company信息
				int effectedNum = companyDao.deleteCompany(companyId);
				if (effectedNum > 0) {
					return true;
				} else {
					throw new RuntimeException("删除Company信息失败!");
				}
			} catch (Exception e) {
				throw new RuntimeException("删除Company信息失败:" + e.toString());
			}
		} else {
			throw new RuntimeException("CompanyId不能为空！");
		}
	}

	@Override
	public Company queryCompanyByNumber(String number,String password) {
		Company company = companyDao.queryCompanyByNumber(number);

		if (company==null){
			throw new RuntimeException("手机号输入错误");
		}

		if (password.equals(company.getPassword())){
			return company;
		}else {
			throw new RuntimeException("密码错误");
		}

	}
}
