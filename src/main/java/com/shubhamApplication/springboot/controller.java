package com.shubhamApplication.springboot;

import com.shubhamApplication.springboot.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class controller {

  @RequestMapping("test")
    public String hello(){
        return "This is my first website";
    }

}
