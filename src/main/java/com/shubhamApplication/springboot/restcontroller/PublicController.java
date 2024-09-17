package com.shubhamApplication.springboot.restcontroller;

import com.shubhamApplication.springboot.entity.User;
import com.shubhamApplication.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/public")
@RestController
public class PublicController {
    @Autowired
    UserService userService;
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        userService.saveEntry(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}
