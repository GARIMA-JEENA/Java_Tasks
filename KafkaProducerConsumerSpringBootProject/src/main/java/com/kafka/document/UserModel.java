package com.kafka.document;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserModel {

	public UserModel(String rollNumber, String userName, String location) {
		super();
		this.rollNumber = rollNumber;
		this.userName = userName;
		this.location = location;
	}
	@Id
	private String rollNumber;
	private String userName;
	private String location;

	public UserModel() {
		super();
		
	}
	@Override
	public String toString() {
		return "UserModel [rollNumber=" + rollNumber + ", userName=" + userName + ", location=" + location + "]";
	}
	public String getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}

