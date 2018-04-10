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
	public Company getCompanyById(int CompanyId) {
		return companyDao.queryCompanyById(CompanyId);
	}

	@Transactional
	@Override
	public boolean addCompany(Company Company) {
		// 空值判断，主要是判断CompanyName不为空
		if (Company.getName() != null && !"".equals(Company.getName())) {
			// 设置默认值
//			Company.setCreateTime(new Date());
//			Company.setLastEditTime(new Date());
			try {
				int effectedNum = companyDao.insertCompany(Company);
				if (effectedNum > 0) {
					return true;
				} else {
					throw new RuntimeException("添加Company信息失败!");
				}
			} catch (Exception e) {
				throw new RuntimeException("添加Company信息失败:" + e.toString());
			}
		} else {
			throw new RuntimeException("Company信息不能为空！");
		}
	}

	@Transactional
	@Override
	public boolean modifyCompany(Company Company) {
		// 空值判断，主要是CompanyId不为空
		if (Company.getId() != null && Company.getId() > 0) {
			// 设置默认值
//			Company.setLastEditTime(new Date());
			try {
				// 更新Company信息
				int effectedNum = companyDao.updateCompany(Company);
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
	public boolean deleteCompany(int CompanyId) {
		if (CompanyId > 0) {
			try {
				// 删除Company信息
				int effectedNum = companyDao.deleteCompany(CompanyId);
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
}
