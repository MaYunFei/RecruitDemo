package com.example.demo.dao;

import com.example.demo.entity.School;

import java.util.List;

public interface SchoolDao {
    /**
     * 列出Company列表
     *
     * @return CompanyList
     */
    List<School> querySchool();

    /**
     * 根据Id列出具体School
     *
     * @return School
     */
    School querySchoolById(int SchoolId);

    /**
     * 插入School信息
     *
     * @param School
     * @return
     */
    int insertSchool(School School);

    /**
     * 更新School信息
     *
     * @param School
     * @return
     */
    int updateSchool(School School);

    /**
     * 删除School信息
     *
     * @param SchoolId
     * @return
     */
    int deleteSchool(int SchoolId);
}
