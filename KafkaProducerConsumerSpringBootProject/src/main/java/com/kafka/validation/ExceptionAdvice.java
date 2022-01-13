package com.kafka.validation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {
	
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInputFunc(EmptyInputException emptyInputException){
		return new ResponseEntity<String>("Input Fields are Empty, Please Look Into it. ",HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> handleIdNotFoundFunc(IdNotFoundException idNotFoundException){
		return new ResponseEntity<String>("User with Id does not exists. ",HttpStatus.BAD_REQUEST);
	}

}
