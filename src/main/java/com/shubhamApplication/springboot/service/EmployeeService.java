package com.shubhamApplication.springboot.service;

import com.shubhamApplication.springboot.entity.Employee;
import com.shubhamApplication.springboot.entity.User;
import com.shubhamApplication.springboot.repository.EmployeeRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeeService
{
    @Autowired
    private UserService userservice;
    @Autowired
   private EmployeeRepository employeeRepository;
//@Transactional
    public void saveEntry(Employee employee,String username){
    try{
        User user=userservice.findByUserName(username);
        employee.setDate(new Date());
        Employee emp=employeeRepository.save(employee);
        user.getEmployeee().add(emp);
        userservice.saveEntry(user);
    }catch(Exception e){
        throw new RuntimeException("An error occurred while saving the entry.", e);
    }

    }

    public void save(Employee employee){
        employeeRepository.save(employee);
    }
    public List<Employee> getall(){
        return employeeRepository.findAll();
    }
    public Optional<Employee>getbyId(ObjectId id){
        return employeeRepository.findById(id);
    }

   // @Transactional
    public boolean deletebyId(ObjectId id, String username) {
    boolean removed =false;
    try{
        User user = userservice.findByUserName(username);
         removed=user.getEmployeee().removeIf(x->x.getId().equals(id));
        if(removed){
            userservice.saveEntry(user);
            employeeRepository.deleteById(id);
        }
    } catch (Exception e) {
    throw new RuntimeException("An error occurred while deleting the entry.", e);
}
return removed;
    }



}
