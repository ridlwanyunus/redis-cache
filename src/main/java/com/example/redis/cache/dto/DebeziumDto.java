package com.example.redis.cache.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DebeziumDto {

	private Object schema;
	private Payload payload;
	
	
}
