package com.example.redis.cache.message;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.redis.cache.dto.DebeziumDto;

@Component
public class KafkaMessageListener {

	@KafkaListener(
		topics="mysql-connector-debezium.cdc.information",
		groupId = "mysql-connector-debezium",
		containerFactory = "containerFactory"
	)
	public void listener(String generic) {
		System.out.println(generic);
	}
	
	
}
