package com.example.demo.web;

import com.example.demo.entity.Student;
import com.example.demo.handler.SuccessHandle;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;


    @RequestMapping(value = "/queryStudentByPassword", method = RequestMethod.GET)
    private Map queryStudentByPassword(String number, String password) {
        System.out.println(number + "  " + password);
        return SuccessHandle.success(studentService.queryStudentByPassword(number, password));
    }


    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    private Map addStudent(String number, String password) {
        if (StringUtils.isEmpty(number) || StringUtils.isEmpty(password)){
            throw new RuntimeException("参数异常");
        }
        Student student = new Student();
        student.setNumber(number);
        student.setPassword(password);
        System.out.println(" add student " + student);
        boolean b = studentService.addStudent(student);
        if (b){
            return SuccessHandle.success(student);
        }else{
            throw new RuntimeException("服务器异常");
        }

    }

}
