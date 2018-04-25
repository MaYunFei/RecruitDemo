package com.example.demo.web;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;


    @RequestMapping(value = "/queryStudentByPassword", method = RequestMethod.GET)
    private Student queryStudentByPassword(String number, String password) {
        System.out.println(number + "  " + password);
        return studentService.queryStudentByPassword(number, password);
    }

}
