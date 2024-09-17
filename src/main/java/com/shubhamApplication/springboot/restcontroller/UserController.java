package com.shubhamApplication.springboot.restcontroller;

import com.shubhamApplication.springboot.entity.User;
import com.shubhamApplication.springboot.service.UserService;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping("/User")
@RestController
public class UserController {

    @Autowired
    private UserService userService;



    @GetMapping("/getall")
    public ResponseEntity<?> getAllUser(){
        List<User> all= userService.getall();
        if(all!=null && !all.isEmpty()){
            return new ResponseEntity<>(all, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getbyId/{id}")
    public ResponseEntity<?> getById(@PathVariable ObjectId id) {
        Optional<User> userOp = userService.getbyId(id);
        if (userOp.isPresent()) {
            return new ResponseEntity<>(userOp.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable ObjectId id){
        userService.deletebyId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User user){
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       String username= authentication.getName();
       User userindb = userService.findByUserName(username);

            userindb.setUsername(user.getUsername());
            userindb.setPassword(user.getPassword());
            userService.saveEntry(userindb);
            return new ResponseEntity<>(userindb,HttpStatus.OK);
    }

}
