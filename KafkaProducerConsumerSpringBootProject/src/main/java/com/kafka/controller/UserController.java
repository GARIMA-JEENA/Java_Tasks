package com.kafka.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.dao.DaoUser;
import com.kafka.document.UserModel;

@RestController
public class UserController {

	@Autowired
	KafkaTemplate<String,UserModel> kafkaTemplate;
	
	@Autowired
	private DaoUser daoUser;
	
	private static final String TOPIC="UserTask3";
	
	@PostMapping("/createUser")
	public String createUser(@RequestBody UserModel userModel){
		
		kafkaTemplate.send(TOPIC, userModel);
		return "User added successfully";	
		}
	
	@GetMapping("/getAllUsers")
	public List<UserModel> getAllUsers() {
		return daoUser.findAll();
	}
	
	@GetMapping("/getUser/{rollNumber}")
	public Optional<UserModel> getUser(@PathVariable String rollNumber) {
		return daoUser.findById(rollNumber);
		
	}
////	
//	@PutMapping("/updateUser/{rollNumber}")
//	public List<UserModel> updateUser(@PathVariable String rollNumber) {
//		return daoUser.save();
//	}
	
//	@DeleteMapping("/deleteUser/{rollNumber}")
//	public	String deleteUser(@PathVariable String rollNumber) {
//		//kafkaTemplate.send(TOPIC,rollNumber);
//		return "User Deleted suucessfully";
//	}
	
	
	
}
