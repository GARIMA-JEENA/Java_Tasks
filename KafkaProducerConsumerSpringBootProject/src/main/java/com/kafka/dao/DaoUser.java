package com.kafka.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kafka.document.UserModel;

public interface DaoUser extends MongoRepository<UserModel,String>{

}
