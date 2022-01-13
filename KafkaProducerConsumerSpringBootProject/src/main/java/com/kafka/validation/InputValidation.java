package com.kafka.validation;

import org.springframework.stereotype.Component;

import com.kafka.document.InputFormat;
@Component
public class InputValidation {
	
	public boolean validationFunc(InputFormat inputFormat) {

		if (inputFormat.userDTO.getRollNumber().isEmpty() || inputFormat.userDTO.getFirstName().isEmpty()
				|| inputFormat.userDTO.getLastName().isEmpty() || inputFormat.userDTO.getStream().isEmpty()
				|| inputFormat.userDTO.getLocation().isEmpty()) {
			return false;
		}
		return true;
	}

}
