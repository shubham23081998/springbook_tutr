package com.shubhamApplication.springboot.service;

import com.shubhamApplication.springboot.entity.Employee;
import com.shubhamApplication.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService
{
    @Autowired
   private EmployeeRepository employeeRepository;

    public String saveEntry(Employee employee){
        employeeRepository.save(employee);
        return "Employee entry save successfully";
    }

}
