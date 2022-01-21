package com.kafka.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.kafka.document.InputFormat;
import com.kafka.service.UserService;

@Component
public class KafkaConsumer {

	@Autowired
	protected UserService userService;

	@KafkaListener(topics = "SpringTask", groupId = "SpringGroup", containerFactory = "userKafkaListenerFactory")
	public void consume(InputFormat inputFormat) {
		if (inputFormat.getMethod().equals("Create")) {
			userService.createUser(inputFormat);
		}
		if (inputFormat.getMethod().equals("Update")) {
			userService.updateUser(inputFormat);
		}
		if (inputFormat.getMethod().equals("Delete")) {
//			userService.deleteUser(inputFormat.userDTO.getRollNumber());
			userService.deleteUser(inputFormat);
		}
	}
//	@KafkaListener(topics="UserTask3",groupId="j",containerFactory="kafkaListenerContainerFactory")
//	public void consumeString(String rollNumber) {
//		userService.deleteUser(rollNumber);
//		
//	}
}
