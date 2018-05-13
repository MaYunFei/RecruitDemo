package com.demo.kaiyun.androiddemo.bean;


public class School {
    private Integer id;

    private String name;

    private String introduce;

    private String quantity;

    private String adress;

    private String teacher;

    private Integer number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
     * @return introduce
     */
    public String getIntroduce() {
        return introduce;
    }

    /**
     * @param introduce
     */
    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    /**
     * @return quantity
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * @param quantity
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    /**
     * @return adress
     */
    public String getAdress() {
        return adress;
    }

    /**
     * @param adress
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }

    /**
     * @return teacher
     */
    public String getTeacher() {
        return teacher;
    }

    /**
     * @param teacher
     */
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    /**
     * @return number
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * @param number
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return name;
    }
}