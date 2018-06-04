package com.demo.kaiyun.androiddemo.bean;

public class PostedItem {

    /**
     * size : 1
     * job : {"id":1,"name":"销售经理","responsibility":"1、负责公司信息安全产品销售，开发客户资源、挖掘产品需求；/n2、负责商务谈判、合同签署、合同款收回","require":"1、IT行业（软件优先）销售经验2-4年，或IT咨询行业咨询顾问、项目顾问经验1-4年；/n2、历史业绩优异；具备互联网、互联网金融、金融行业客户资源且可转化；/n3、具备良好的学习能力、自我驱动力、以结果为导向的工作思维、突出的沟通能力；","money":"3k\u20144k","education":"不限","companyId":"1"}
     */

    private int size;
    private Job job;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
