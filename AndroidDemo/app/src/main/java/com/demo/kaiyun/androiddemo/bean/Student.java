package com.demo.kaiyun.androiddemo.bean;


import java.io.Serializable;

public class Student implements Serializable {
    private Integer id;

    private String name;

    private String sex;

    private String ago;

    private String major_id;

    private String school_id;

    private String experience;

    private String enjlish;

    private String andress;

    private String number;

    private String password;

    private String email;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

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
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return ago
     */
    public String getAgo() {
        return ago;
    }

    /**
     * @param ago
     */
    public void setAgo(String ago) {
        this.ago = ago;
    }

    /**
     * @return major_id
     */
    public String getMajorId() {
        return major_id;
    }

    /**
     * @param majorId
     */
    public void setMajorId(String majorId) {
        this.major_id = majorId;
    }

    /**
     * @return school_id
     */
    public String getSchoolId() {
        return school_id;
    }

    /**
     * @param schoolId
     */
    public void setSchoolId(String schoolId) {
        this.school_id = schoolId;
    }

    /**
     * @return experience
     */
    public String getExperience() {
        return experience;
    }

    /**
     * @param experience
     */
    public void setExperience(String experience) {
        this.experience = experience;
    }

    /**
     * @return enjlish
     */
    public String getEnjlish() {
        return enjlish;
    }

    /**
     * @param enjlish
     */
    public void setEnjlish(String enjlish) {
        this.enjlish = enjlish;
    }

    /**
     * @return andress
     */
    public String getAndress() {
        return andress;
    }

    /**
     * @param andress
     */
    public void setAndress(String andress) {
        this.andress = andress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", ago='" + ago + '\'' +
                ", major_id='" + major_id + '\'' +
                ", school_id='" + school_id + '\'' +
                ", experience='" + experience + '\'' +
                ", enjlish='" + enjlish + '\'' +
                ", andress='" + andress + '\'' +
                ", number='" + number + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}