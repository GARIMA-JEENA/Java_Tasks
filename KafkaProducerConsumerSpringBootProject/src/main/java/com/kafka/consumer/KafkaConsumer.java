package com.kafka.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.kafka.dao.DaoUser;
import com.kafka.document.UserModel;

@Component
@Service
public class KafkaConsumer {
	
	@Autowired
	private DaoUser daoUser;
	
	@KafkaListener(topics="UserTask3",groupId="j",containerFactory="userKafkaListenerFactory")
	public void consumeJson(UserModel userModel) {
		System.out.println("CONSUMED MESSAGE : "+ userModel);
		daoUser.save(userModel);
	}
//	@KafkaListener(topics="UserTask3",groupId="j",containerFactory="userKafkaListenerFactory")
//	public void consumeRollNumber(String rollNumber) {
//		System.out.println("CONSUMED MESSAGE : "+ rollNumber);
//		daoUser.deleteById(rollNumber);;
//	}
	

}
