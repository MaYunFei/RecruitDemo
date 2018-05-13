package com.example.demo.web;

import com.example.demo.entity.Job;
import com.example.demo.entity.School;
import com.example.demo.handler.SuccessHandle;
import com.example.demo.service.JobService;
import com.example.demo.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/job")
public class JobController {
    @Autowired
    private JobService jobService;

    /**
     * 获取所有的区域信息
     *
     * @return
     */
    @RequestMapping(value = "/{companyId}", method = RequestMethod.GET)
    private Map listCompany(@PathVariable(value = "companyId")int companyId) {
        List<Job> list = new ArrayList<Job>();
        list = jobService.getJobByCompanyId(companyId);
        return SuccessHandle.success(list);
    }

}
