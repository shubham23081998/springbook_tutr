package com.shubhamApplication.springboot.restcontroller;

import com.shubhamApplication.springboot.entity.Employee;
import com.shubhamApplication.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/employee")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/create")
    public String createEmployee(@RequestBody Employee emp){
        return "record saved successfully";
    }
}
