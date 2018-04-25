package com.example.demo.web;

import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;


//	@RequestMapping(value = "/queryStudentByPassword", method = RequestMethod.GET)
//	private Student listCompany() {
//		studentService.queryStudentByPassword()
//	}

}
