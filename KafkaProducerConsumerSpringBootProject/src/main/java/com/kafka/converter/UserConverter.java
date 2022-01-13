package com.kafka.converter;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import com.kafka.config.dto.UserDTO;
import com.kafka.document.UserModel;

@Component
public class UserConverter {

	public UserDTO userModelToDTO(UserModel userModel) {
//		UserDTO dto = new UserDTO();
//		dto.setUserName(userModel.getUserName());
//		dto.setRollNumber(userModel.getRollNumber());
//		dto.setEmail(userModel.getEmail());
//		dto.setLocation(userModel.getLocation());
//		return dto;

		ModelMapper mapper = new ModelMapper();
		UserDTO map = mapper.map(userModel, UserDTO.class);
		return map;
	}

	public List<UserDTO> userModelToDTO(List<UserModel> userModel) {
		return userModel.stream().map(x -> userModelToDTO(x)).collect(Collectors.toList());
	}


}
