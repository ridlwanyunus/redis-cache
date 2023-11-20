package com.example.redis.cache.dto;

import com.example.redis.cache.entity.Information;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payload {

	private Information before;
	private Information after;
	
	
}
