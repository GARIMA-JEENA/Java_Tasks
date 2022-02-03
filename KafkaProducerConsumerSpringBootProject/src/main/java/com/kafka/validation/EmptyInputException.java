package com.kafka.validation;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EmptyInputException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyInputException(String errorMessage) {
		super(errorMessage);
	}
}
