package com.shubhamApplication.springboot.restcontroller;

import com.shubhamApplication.springboot.entity.User;
import com.shubhamApplication.springboot.service.UserService;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping("/User")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        userService.saveEntry(user);
       return new ResponseEntity<>(user,HttpStatus.CREATED);
    }

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
    @PutMapping("/update/{username}")
    public ResponseEntity<?> updateUser(@RequestBody User user,@PathVariable String username){
        User olduser = userService.findByUserName(username);

        System.out.print("till herer1");

        if(olduser !=null) {
            olduser.setUsername(user.getUsername());
            olduser.setPassword(user.getPassword());
            userService.saveEntry(olduser);
            return new ResponseEntity<>(olduser, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(olduser, HttpStatus.NOT_FOUND);
        }
    }
}
