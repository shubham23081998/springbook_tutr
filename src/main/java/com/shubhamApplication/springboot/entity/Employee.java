package com.shubhamApplication.springboot.entity;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document (collection ="employee_detail")
@Getter
@Setter
public class Employee {
    @Id
    public ObjectId id;
    public String name;
    public int salary;
    public String city;
    public Date date;

}
