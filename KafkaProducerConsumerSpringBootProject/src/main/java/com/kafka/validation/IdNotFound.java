package com.kafka.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kafka.service.UserService;

@Component
public class IdNotFound {

	@Autowired
	UserService userService;

	public boolean checkIDFound(String rollNumber) {
		if (userService.checkId(rollNumber) == true) {
			return true;
		} else {
			return false;
		}
	}

}
