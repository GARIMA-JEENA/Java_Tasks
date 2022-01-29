package com.kafka.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class UserModel {

	@Id
	private String rollNumber;
	private String firstName;
	private String lastName;
	private String stream;
	private String location;

}
