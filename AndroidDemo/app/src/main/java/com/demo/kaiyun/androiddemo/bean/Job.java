package com.demo.kaiyun.androiddemo.bean;


import java.io.Serializable;

public class Job implements Serializable{
    private Integer id;

    private String name;

    private String responsibility;

    private String require;


    private String education;

    private String money;

    private String company_id;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return responsibility
     */
    public String getResponsibility() {
        return responsibility;
    }

    /**
     * @param responsibility
     */
    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    /**
     * @return require
     */
    public String getRequire() {
        return require;
    }

    /**
     * @param require
     */
    public void setRequire(String require) {
        this.require = require;
    }



    /**
     * @return education
     */
    public String getEducation() {
        return education;
    }

    /**
     * @param education
     */
    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * @return major_id
     */
    public String getMoney() {
        return money;
    }

    /**
     * @param money
     */
    public void setMoney(String money) {
        this.money = money;
    }
    /**
     * @return major_id
     */
    public String getCompanyId() {
        return company_id;
    }

    /**
     * @param companyId
     */
    public void setCompanyId(String companyId) {
        this.company_id = companyId;
    }
}