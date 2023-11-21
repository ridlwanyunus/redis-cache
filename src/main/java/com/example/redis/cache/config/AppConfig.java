package com.example.redis.cache.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public ExecutorService executorService() {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		return executorService;
	}
	
	
}
