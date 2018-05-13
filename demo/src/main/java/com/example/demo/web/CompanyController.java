package com.example.demo.web;

import com.example.demo.entity.Company;
import com.example.demo.handler.SuccessHandle;
import com.example.demo.service.CompanyService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/company")
public class CompanyController {
	@Autowired
	private CompanyService companyService;

	/**
	 * 获取所有的区域信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/listcompany", method = RequestMethod.GET)
	private Map listCompany() {
		List<Company> list = new ArrayList<Company>();
		list = companyService.getCompanyList();
		return SuccessHandle.success(list);
	}

	/**
	 * 通过区域Id获取区域信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getcompanybyid", method = RequestMethod.GET)
	private Map<String, Object> getCompanyById(Integer companyId) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 获取区域信息
		Company company = companyService.getCompanyById(companyId);
		modelMap.put("company", company);
		return modelMap;
	}

	/**
	 * 添加区域信息
	 * 
	 * @param
	 * @param
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	@RequestMapping(value = "/addcompany", method = RequestMethod.POST)
	private Map<String, Object> addCompany(@RequestBody Company company)
			throws JsonParseException, JsonMappingException, IOException {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 添加区域信息
		modelMap.put("success", companyService.addCompany(company));
		return modelMap;
	}

	/**
	 * 修改区域信息，主要修改名字
	 * 
	 * @param
	 * @param
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	@RequestMapping(value = "/modifycompany", method = RequestMethod.POST)
	private Map<String, Object> modifyCompany(@RequestBody Company company)
			throws JsonParseException, JsonMappingException, IOException {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 修改区域信息
		modelMap.put("success", companyService.modifyCompany(company));
		return modelMap;
	}

	@RequestMapping(value = "/removecompany", method = RequestMethod.GET)
	private Map<String, Object> removeCompany(Integer companyId) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 修改区域信息
		modelMap.put("success", companyService.deleteCompany(companyId));
		return modelMap;
	}

}
