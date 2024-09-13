package com.shubhamApplication.springboot.restcontroller;

import com.shubhamApplication.springboot.entity.Employee;
import com.shubhamApplication.springboot.entity.User;
import com.shubhamApplication.springboot.service.EmployeeService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Employee>createEmployee(@RequestBody Employee emp,User user){
        try{
            employeeService.saveEntry(emp);
            return new ResponseEntity<>(emp, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(emp, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAllEmployee(){
        List<Employee> all= employeeService.getall();
        if(all!=null && !all.isEmpty()){
            return new ResponseEntity<>(all, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getbyId/{id}")
    public ResponseEntity<?> getById(@PathVariable ObjectId id) {
        Optional<Employee> employeeOp = employeeService.getbyId(id);
        if (employeeOp.isPresent()) {
            return new ResponseEntity<>(employeeOp.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable ObjectId id){
        employeeService.deletebyId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee emp,@PathVariable ObjectId id){
       try {
               Optional<Employee> employeeOp = employeeService.getbyId(id);
               Employee oldemp = employeeOp.get();
               if (employeeOp.isPresent()) {
                   if (oldemp.getName() != null && !oldemp.getName().isEmpty()) {
                       oldemp.setName(emp.getName());
                   } else {
                       oldemp.setName(oldemp.getName());
                   }
                   if (oldemp.getSalary() != 0) {
                       oldemp.setSalary(emp.getSalary());
                   } else {
                       oldemp.setSalary(oldemp.getSalary());
                   }
                   employeeService.saveEntry(oldemp);

                   return new ResponseEntity<>(oldemp, HttpStatus.CREATED);
               }else{
                   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
               }
       }catch(RuntimeException e){
               return new ResponseEntity<>(emp, HttpStatus.BAD_REQUEST);
           }

    }

}


