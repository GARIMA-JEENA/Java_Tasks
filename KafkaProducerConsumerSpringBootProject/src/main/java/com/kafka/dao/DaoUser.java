package com.kafka.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kafka.document.UserModel;

public interface DaoUser extends MongoRepository<UserModel, String> {

	void save(Optional<UserModel> userModel);

}
