package com.example.demo.dao;

import com.example.demo.entity.Company;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 按方法名大小升序执行
public class CompanyDaoTest {

    //通过spring容器注入Dao的实现类
    @Autowired
    private CompanyDao companyDao;
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void queryCompany() {
        List<Company> companies = companyDao.queryCompany();
        for (Company company : companies) {
            System.out.println(company);
        }

    }

    @Test
    public void queryCompanyById() {
        System.out.println(companyDao.queryCompanyById(1));
    }

    @Test
    public void insertCompany() {
    }

    @Test
    public void updateCompany() {
    }

    @Test
    public void deleteCompany() {
    }
}