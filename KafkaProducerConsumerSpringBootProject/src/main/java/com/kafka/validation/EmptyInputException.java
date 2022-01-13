package com.kafka.validation;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Component
public class EmptyInputException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String errorCode;
	public String errorMessage;
}
