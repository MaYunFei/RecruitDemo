package com.example.demo.dao;

import com.example.demo.entity.Major;

import java.util.List;

public interface MajorDao {
    /**
     * 列出Company列表
     *
     * @return CompanyList
     */
    List<Major> queryMajor();

    /**
     * 根据Id列出具体Major
     *
     * @return Major
     */
    Major queryMajorById(int MajorId);

    /**
     * 插入Major信息
     *
     * @param Major
     * @return
     */
    int insertMajor(Major Major);

    /**
     * 更新Major信息
     *
     * @param Major
     * @return
     */
    int updateMajor(Major Major);

    /**
     * 删除Major信息
     *
     * @param MajorId
     * @return
     */
    int deleteMajor(int MajorId);
}
