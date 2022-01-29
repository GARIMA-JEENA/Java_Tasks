package com.kafka.dto;

import lombok.Data;

@Data
public class UserDTO {
	private String rollNumber;
	private String firstName;
	private String lastName;
	private String stream;
	private String location;

}
