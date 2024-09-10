package com.shubhamApplication.springboot.service;

import com.shubhamApplication.springboot.entity.Employee;
import com.shubhamApplication.springboot.repository.EmployeeRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeeService
{
    @Autowired
   private EmployeeRepository employeeRepository;

    public String saveEntry(Employee employee){
        employee.setDate(new Date());
        employeeRepository.save(employee);

        return "Employee entry save successfully";
    }
    public List<Employee> getall(){
        return employeeRepository.findAll();
    }
    public Optional<Employee>getbyId(ObjectId id){
        return employeeRepository.findById(id);
    }
    public void deletebyId(ObjectId id) {
        employeeRepository.deleteById(id);
    }


}
