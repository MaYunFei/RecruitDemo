package com.example.demo.web;

import com.example.demo.entity.School;
import com.example.demo.entity.Student;
import com.example.demo.handler.SuccessHandle;
import com.example.demo.service.SchoolService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private SchoolService schoolService;


    @RequestMapping(value = "/queryStudentByPassword", method = RequestMethod.POST)
    private Map queryStudentByPassword(String number, String password) {
        System.out.println(number + "  " + password);
        return SuccessHandle.success(studentService.queryStudentByPassword(number, password));
    }


    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    private Map addStudent(String number, String password) {
        if (StringUtils.isEmpty(number) || StringUtils.isEmpty(password)) {
            throw new RuntimeException("参数异常");
        }
        Student student = new Student();
        student.setNumber(number);
        student.setPassword(password);
        System.out.println(" add student " + student);
        boolean b = studentService.addStudent(student);
        if (b) {
            return SuccessHandle.success(student);
        } else {
            throw new RuntimeException("服务器异常");
        }

    }

    @RequestMapping(value = "/get/{userId}", method = RequestMethod.GET)
    private Map getStudentInfo(@PathVariable(value = "userId") int userId) {

        Student student = studentService.getStudentById(userId);
        String schoolId = student.getSchoolId();
        School school = null ;
        if (!StringUtils.isEmpty(schoolId)){
            school = schoolService.getSchoolById(Integer.parseInt(schoolId));
        }

        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("student",student);
        resultMap.put("school",school);
        if (student == null) {
            throw new RuntimeException("服务器异常");
        }

        return SuccessHandle.success(resultMap);
    }


    @RequestMapping(value = "/update/{userId}", method = RequestMethod.POST)
    private Map updateInfo(@PathVariable(value = "userId") int userId,
                           String name,
                           String sex,
                           String age,
                           String number,
                           String email,
                           String address,
                           String school,
                           String experience) {
        Student student = studentService.getStudentById(userId);
        student.setName(name);
        student.setSex(sex);
        student.setAgo(age);
        student.setNumber(number);
        student.setEmail(email);
        student.setAndress(address);
//        schoolService.getSchoolById()
        student.setSchoolId(school);
        student.setExperience(experience);

        studentService.modifyStudent(student);

        return SuccessHandle.success(student);

    }

}
