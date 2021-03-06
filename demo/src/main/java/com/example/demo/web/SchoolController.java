package com.example.demo.web;

import com.example.demo.entity.School;
import com.example.demo.handler.SuccessHandle;
import com.example.demo.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    /**
     * 获取所有的区域信息
     *
     * @return
     */
    @RequestMapping(value = "/listSchool", method = RequestMethod.GET)
    private Map listCompany() {
        List<School> list = new ArrayList<School>();
        list = schoolService.getSchoolList();
        return SuccessHandle.success(list);
    }

}
