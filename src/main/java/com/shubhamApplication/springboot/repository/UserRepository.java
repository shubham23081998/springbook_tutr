package com.shubhamApplication.springboot.repository;

import com.shubhamApplication.springboot.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.function.Function;


public interface UserRepository extends MongoRepository<User, ObjectId> {

    User findByUserName(String username);


}
