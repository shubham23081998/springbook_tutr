package com.shubhamApplication.springboot.repository;

import com.shubhamApplication.springboot.entity.Employee;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, ObjectId> {
}
