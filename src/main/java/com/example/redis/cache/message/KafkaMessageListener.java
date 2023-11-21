package com.example.redis.cache.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.redis.cache.dto.DebeziumDto;
import com.example.redis.cache.dto.InformationDto;
import com.example.redis.cache.dto.Payload;
import com.example.redis.cache.entity.Information;
import com.example.redis.cache.service.InformationService;

@Component
public class KafkaMessageListener {
	
	
	@Autowired
	private InformationService infoService;

	@KafkaListener(
		topics="mysql-connector-debezium.cdc.information",
		groupId = "mysql-connector-debezium",
		containerFactory = "containerFactory"
	)
	public void listener(Payload payload) {
		System.out.println(payload.toString());
		InformationDto informationDto = payload.getAfter();
		Information information = new Information();
		information.setId(informationDto.getId());
		information.setNpwp(informationDto.getNpwp());
		information.setSerialNumber(informationDto.getSerial_number());
		information.setCertificate(informationDto.getCertificate());
		information.setCreationDate(informationDto.getCreation_date());
		infoService.save(information);
	}
	
	
}
