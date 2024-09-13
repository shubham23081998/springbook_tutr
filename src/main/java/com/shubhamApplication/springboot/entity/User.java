package com.shubhamApplication.springboot.entity;

import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection ="user")
//@Indexed
public class User {
    @Id
    private ObjectId id;
    @Indexed(unique = true)
    @NonNull
    private String userName;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public @NonNull String getUsername() {
        return userName;
    }

    public void setUsername(@NonNull String userName) {
        this.userName = userName;
    }

    public @NonNull String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    public List<Employee> getEmployeee() {
        return Employeee;
    }

    public void setEmployeee(List<Employee> employeee) {
        Employeee = employeee;
    }

    @NonNull
    private String password;
    @DBRef
    private List<Employee> Employeee=  new ArrayList<>();


}
