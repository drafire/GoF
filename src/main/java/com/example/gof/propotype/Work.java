package com.example.gof.propotype;

import java.io.Serializable;

public class Work implements Serializable{   //需要继承Seariable，才能序列化和反序列化
    private String company;
    private int salary;
    private String job;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCompany() {

        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Work(String company, int salary, String job) {
        this.company = company;
        this.salary = salary;
        this.job = job;
    }
}
