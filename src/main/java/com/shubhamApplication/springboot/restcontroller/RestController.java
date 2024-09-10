package com.shubhamApplication.springboot.restcontroller;
import com.shubhamApplication.springboot.entity.Employee;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api")
@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/hello")
    public String hello(){
        return "Ram-ram bhai sareya na";
    }

    Map<ObjectId, Employee> employeelist = new HashMap<>();

    @GetMapping("/getall")
    public List<Employee> getallemployee(){
        return  new ArrayList<>(employeelist.values());
    }

    @GetMapping("/get/{id}")
    public Employee getemployeebyID(@PathVariable int id){
        return employeelist.get(id);
    }


    @PostMapping("/save")
    public String createEmployee(@RequestBody Employee emp){
        employeelist.put(emp.getId(),emp);
      return "record saved successfully";
    }

    @DeleteMapping("/remove/{id}")
    public Employee deleteEmployeebyID(@PathVariable int id){

        return employeelist.remove(id);
    }

    @PutMapping("/update/{id}")
    public String updateEmployeebyId(@PathVariable int id,@RequestBody Employee emp){
        employeelist.put(emp.getId(),emp);
        return "record update successfully";
    }


}
