package com.example.demo.web;

import com.example.demo.entity.Company;
import com.example.demo.entity.Job;
import com.example.demo.entity.Student;
import com.example.demo.handler.SuccessHandle;
import com.example.demo.service.CompanyService;
import com.example.demo.service.JobService;
import com.example.demo.service.StudentJobService;
import com.example.demo.service.StudentService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	@Autowired
	private StudentJobService studentJobService;
	@Autowired
	private JobService jobService;
	@Autowired
	private StudentService studentService;
	/**
	 * 获取所有的区域信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/listCompany", method = RequestMethod.GET)
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
	@RequestMapping(value = "/addCompany", method = RequestMethod.POST)
	private Map<String, Object> addCompany(String number, String password) {
		Company company = new Company();
		company.setNumber(number);
		company.setPassword(password);
		companyService.addCompany(company);
		return SuccessHandle.success(company);
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


	@RequestMapping(value = "/queryCompanyByPassword", method = RequestMethod.POST)
	private Map queryCompanyByPassword(String number, String password) {
		System.out.println(number + "  " + password);
		return SuccessHandle.success(companyService.queryCompanyByNumber(number, password));
	}


	@RequestMapping(value = "/queryJobInfo/{companyId}", method = RequestMethod.GET)
	private Map queryJobInfo(@PathVariable(value = "companyId") int companyId) {


		List<Job> jobByCompanyId = jobService.getJobByCompanyId(companyId);
		List<Object> list = new ArrayList<>(jobByCompanyId.size());

		for (Job job : jobByCompanyId) {
			Map<String, Object> modelMap = new HashMap<String, Object>();
			modelMap.put("job", job);
			List<Student> students = studentJobService.queryStudent(job.getId());
			modelMap.put("size", students.size());

			list.add(modelMap);
		}

		return SuccessHandle.success(list);
	}

	@RequestMapping(value = "/queryStudent/{jobId}", method = RequestMethod.GET)
	private Map queryStudent(@PathVariable(value = "jobId") int jobId) {


		List<Student> students = studentJobService.queryStudent(jobId);


		return SuccessHandle.success(students);
	}


}
