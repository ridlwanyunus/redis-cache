package com.example.redis.cache.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payload {

	private InformationDto before;
	private InformationDto after;
	private Source source;
	private String op;
	private Long ts_ms;
	private String transaction;
	
}
