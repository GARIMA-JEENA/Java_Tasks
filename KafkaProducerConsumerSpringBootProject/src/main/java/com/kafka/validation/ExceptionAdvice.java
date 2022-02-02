package com.kafka.validation;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

//	@ExceptionHandler(EmptyInputException.class)
//	public ResponseEntity<String> handleEmptyInputFunc(EmptyInputException emptyInputException) {
//		return new ResponseEntity<String>("Input Fields are Empty, Please Look Into it. ", HttpStatus.BAD_REQUEST);
//	}
//	@ExceptionHandler(IdNotFoundException.class)
//	public ResponseEntity<String> handleIdNotFoundFunc(IdNotFoundException idNotFoundException) {
//		return new ResponseEntity<String>("User with Id does not exists. ", HttpStatus.BAD_REQUEST);
//	}

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return new ResponseEntity<Object>("Please Change Your Method Type ", HttpStatus.METHOD_NOT_ALLOWED);
	}

//
}
