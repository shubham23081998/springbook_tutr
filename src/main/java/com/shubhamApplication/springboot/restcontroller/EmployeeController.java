package com.shubhamApplication.springboot.restcontroller;

import com.shubhamApplication.springboot.entity.Employee;
import com.shubhamApplication.springboot.service.EmployeeService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RequestMapping("/employee")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/create")
    public String createEmployee(@RequestBody Employee emp){
        employeeService.saveEntry(emp);
        return "record saved successfully";
    }

    @GetMapping("/getall")
    public List<Employee> getAllEmployee(){
        return employeeService.getall();
    }
    @GetMapping("/getbyId/{id}")
    public Employee getById(@PathVariable ObjectId id){
        return employeeService.getbyId(id).orElse(null);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable ObjectId id){
        employeeService.deletebyId(id);
        return "delete successfully";
    }
    @PutMapping("/update/{id}")
    public String updateEmployee(@RequestBody Employee emp,@PathVariable ObjectId id){
        Employee oldemp=employeeService.getbyId(id).orElse(null);
        if(oldemp.getName()!=null) {
            oldemp.setName(emp.getName());
        }
        if( oldemp.getSalary() !=0)
        {
        oldemp.setSalary(emp.getSalary());
        }
        employeeService.saveEntry(oldemp);
        return "update successfully";
    }

}
