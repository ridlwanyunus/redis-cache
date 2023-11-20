package com.example.redis.cache.entity;

import java.util.Date;

import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Information")
public class Information {

	private String id;
	private String serialNumber;
	private String npwp;
	private String certificate;
	
	private Date creationDate;
	
}
