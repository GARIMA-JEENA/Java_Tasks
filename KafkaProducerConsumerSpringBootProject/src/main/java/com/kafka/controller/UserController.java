package com.kafka.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.kafka.config.dto.UserDTO;
import com.kafka.document.InputFormat;
import com.kafka.service.UserService;
import com.kafka.validation.IdNotFound;
import com.kafka.validation.InputValidation;

@RestController
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	KafkaTemplate<String, InputFormat> kafkaTemplate;

	@Autowired
	protected UserService userService;

	@Autowired
	private InputValidation inputValidation;

	@Autowired
	private IdNotFound idNotFound;

	private static final String TOPIC = "SpringTask";

	@PostMapping("/createUser")
	public ResponseEntity<String> createUser(@RequestBody InputFormat inputFormat) {
		if (inputValidation.validationFunc(inputFormat) == false) {
//			throw new EmptyInputException();
			return new ResponseEntity<>("Empty Input Fields Please check", HttpStatus.BAD_REQUEST);
		}
		try {
			kafkaTemplate.send(TOPIC, inputFormat);
			logger.info("Adding new User");
		} catch (Exception exception) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Request Successfull", HttpStatus.ACCEPTED);
	}

	@GetMapping(value = "/getUser")
	public List<UserDTO> getAllUsers() {
		logger.info("Getting All user Details ");
		return userService.getAllUsers();
	}

	@GetMapping("/getUser/{rollNumber}")
	public ResponseEntity<?> getUser(@PathVariable String rollNumber) {
		if (idNotFound.checkIDFound(rollNumber) == false) {
//			throw new IdNotFoundException();
			return new ResponseEntity<>("ID Not Found Please Check", HttpStatus.BAD_REQUEST);
		}
		logger.info("Getting user Details ");
		UserDTO userDTO=new UserDTO();
		 userDTO=userService.getUser(rollNumber);
		 return new ResponseEntity<>(userDTO, HttpStatus.ACCEPTED);
	}

	@PutMapping("/updateUser/{rollNumber}")
	public ResponseEntity<String> udpateUser(@PathVariable String rollNumber, @RequestBody InputFormat inputFormat) {
		if (idNotFound.checkIDFound(rollNumber) == false) {
//			throw new IdNotFoundException();
			return new ResponseEntity<>("ID Not Found Please Check", HttpStatus.BAD_REQUEST);
		}
		if (inputValidation.validationFunc(inputFormat) == false) {
//			throw new EmptyInputException();
			return new ResponseEntity<>("Input Fields are Empty", HttpStatus.BAD_REQUEST);
		}

		try {
			kafkaTemplate.send(TOPIC, inputFormat);
			logger.info("Updating User Details");
		} catch (Exception exception) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Request Successfull", HttpStatus.ACCEPTED);
	}

//	@DeleteMapping("/deleteUser/{rollNumber}")
//	public ResponseEntity<String> deleteUser(@PathVariable String rollNumber) {
//		if (idNotFound.checkIDFound(rollNumber) == false) {
//			return new ResponseEntity<>("Id Not Found PLease check", HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		try {
//			logger.info("Deleting User");
//			userService.deleteUser(rollNumber);
//			return new ResponseEntity<>("Request Successfull", HttpStatus.ACCEPTED);
//		} catch (Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

	@DeleteMapping("/deleteUser/{rollNumber}")
	public ResponseEntity<String> deleteUser(@PathVariable String rollNumber) {
		if (idNotFound.checkIDFound(rollNumber) == false) {
//			throw new IdNotFoundException();
			return new ResponseEntity<>("Id Not Found PLease check", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		try {
			InputFormat inputFormat = new InputFormat();
			UserDTO userDTO = new UserDTO();
			userDTO.setRollNumber(rollNumber);
			inputFormat.userDTO = userDTO;
			inputFormat.setMethod("Delete");
			kafkaTemplate.send(TOPIC, inputFormat);
			logger.info("Deleting User");
			return new ResponseEntity<>("Request Successfull", HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
