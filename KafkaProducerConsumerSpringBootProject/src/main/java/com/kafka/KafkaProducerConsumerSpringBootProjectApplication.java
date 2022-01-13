package com.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaProducerConsumerSpringBootProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerConsumerSpringBootProjectApplication.class, args);
	}

}

//bin/zookeeper-server-start.sh config/zookeeper.properties

//bin/kafka-server-start.sh config/server.properties

//bin/kafka-topics.sh --create --topic UserTask3 --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1

//bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic UserTask3 --from-beginning

//bin/kafka-console-producer.sh --broker-list localhost:9092  --topic UserTask3

//history | grep create

//./bin/kafka-topics.sh --bootstrap-server=localhost:9092 --list

//./bin/kafka-topics.sh --bootstrap-server=localhost:9092 --describe --topic UserTask3

//db name: Task3

//{
//    "method":"Create",
//    "userModel":
//    {
//    "rollNumber":"200",
//    "firstName":"Sneha",
//	"lastName":"Roy",
//    "stream":"CSE",
//    "location":"Assam"
//    }
//}