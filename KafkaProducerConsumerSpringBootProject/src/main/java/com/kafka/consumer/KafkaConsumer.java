package com.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.kafka.document.InputFormat;
import com.kafka.service.UserService;

@Component
public class KafkaConsumer {

	private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

	@Autowired
	protected UserService userService;

	@KafkaListener(topics = "SpringTask", groupId = "SpringGroup1", containerFactory = "userKafkaListenerFactory")
	public void consume(InputFormat inputFormat) {
		if (inputFormat.getMethod().equals("Create")) {
			logger.info("Creating User");
			userService.createUser(inputFormat);
		}
		if (inputFormat.getMethod().equals("Update")) {
			logger.info("Updating User Details");
			userService.updateUser(inputFormat);
		}
		if (inputFormat.getMethod().equals("Delete")) {
			logger.info("Deleting User");
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
