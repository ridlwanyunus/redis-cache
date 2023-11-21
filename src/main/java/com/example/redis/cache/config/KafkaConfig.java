package com.example.redis.cache.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.example.redis.cache.dto.Payload;
import com.example.redis.cache.dto.PayloadDeserializer;
import com.example.redis.cache.entity.Information;

@Configuration
public class KafkaConfig {
	
	@Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

	@Bean
	public ConsumerFactory<String, Payload> consumerFactory(){
		Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, "group_request_signing");
        props.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG,1000000);
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG,400);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, PayloadDeserializer.class);
		
		return new DefaultKafkaConsumerFactory<String, Payload>(props);
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Payload> containerFactory(){
		ConcurrentKafkaListenerContainerFactory<String, Payload> factory = new ConcurrentKafkaListenerContainerFactory<String, Payload>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
	
}
