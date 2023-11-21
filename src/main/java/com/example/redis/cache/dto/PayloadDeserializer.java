package com.example.redis.cache.dto;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PayloadDeserializer implements Deserializer<Payload>{

	@Override
	public Payload deserialize(String topic, byte[] data) {
		try {
			return new ObjectMapper().readValue(new String(data, "UTF-8"), Payload.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SerializationException(e.getMessage());
		} 
	}

}
