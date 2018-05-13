package com.example.demo.entity;


public class Job {
    private Integer id;

    private String name;

    private String responsibility;

    private String require;

    private String money;

    private String education;

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
     * @return money
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
    public String getCompanyId() {
        return company_id;
    }

    /**
     * @param companyId
     */
    public void setCompanyId(String companyId) {
        this.company_id = companyId;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", responsibility='" + responsibility + '\'' +
                ", require='" + require + '\'' +
                ", money=" + money +
                ", education='" + education + '\'' +
                ", company_id=" + company_id +
                '}';
    }
}