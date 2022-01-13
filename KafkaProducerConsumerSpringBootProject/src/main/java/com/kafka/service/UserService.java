package com.kafka.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kafka.config.dto.UserDTO;
import com.kafka.converter.UserConverter;
import com.kafka.dao.DaoUser;
import com.kafka.document.InputFormat;
import com.kafka.document.UserModel;

@Service
public class UserService {

	@Autowired
	private DaoUser daoUser;

	@Autowired
	UserConverter userConverter;

	public void createUser(InputFormat inputFormat) {
		UserModel userModel=userConverter.dtoToUserModel(inputFormat.userDTO);
		daoUser.save(userModel);
		System.out.println("CONSUMED MESSAGE : " + "created " + userModel);
	}

	public List<UserDTO> getAllUsers() {
		List<UserModel> userModel = daoUser.findAll();
		return userConverter.userModelToDTO(userModel);
	}

	public UserDTO getUser(String rollNumber) {
		UserModel userModel = daoUser.findById(rollNumber).orElse(null);
		return userConverter.userModelToDTO(userModel);
	}

	public void updateUser(InputFormat inputFormat) {
		UserModel userModel=userConverter.dtoToUserModel(inputFormat.userDTO);
		daoUser.save(userModel);
		System.out.println("CONSUMED MESSAGE : " + "updated " + userModel);
	}

	public void deleteUser(String rollNumber) {
		daoUser.deleteById(rollNumber);
		System.out.println("CONSUMED MESSAGE : " + "deleted user");
	}
	
	public boolean checkId(String rollNumber) {
		if(daoUser.existsById(rollNumber)==true) {
			return true;
		}
		else {
			return false;
		}
	}
//	public List<UserModel> getUsersInRange(String lowerRange,String upperRange){
//	return daoUser.
//}

}
