package com.shubhamApplication.springboot.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document (collation="employee_detail")
public class Employee {
    @Id
    public String id;
    public String name;
    public int salary;
    public String city;
    public Date date;
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
