package com.shubhamApplication.springboot.service;

import com.shubhamApplication.springboot.entity.User;
import com.shubhamApplication.springboot.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {


    @Autowired
    private UserRepository userRepository;
  public void saveEntry(User user){
        userRepository.save(user);

    }
    public List<User> getall(){
        return userRepository.findAll();
    }
    public Optional<User> getbyId(ObjectId id){
        return userRepository.findById(id);
    }
    public void deletebyId(ObjectId id) {
        userRepository.deleteById(id);
    }
//    public  User findByUserName(String username){
//        System.out.print("till herer2");
//        return userRepository.findByUserName(username);
//    }

}
