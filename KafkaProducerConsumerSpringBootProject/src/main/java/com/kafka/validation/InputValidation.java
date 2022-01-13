package com.kafka.validation;

import org.springframework.stereotype.Component;

import com.kafka.document.InputFormat;
@Component
public class InputValidation {
	
	public boolean validationFunc(InputFormat inputFormat) {

		if (inputFormat.userModel.getRollNumber().isEmpty() || inputFormat.userModel.getFirstName().isEmpty()
				|| inputFormat.userModel.getLastName().isEmpty() || inputFormat.userModel.getStream().isEmpty()
				|| inputFormat.userModel.getLocation().isEmpty()) {
			return false;
		}
		return true;
	}

}
