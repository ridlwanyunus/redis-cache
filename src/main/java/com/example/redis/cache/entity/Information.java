package com.example.redis.cache.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Information")
public class Information {

	@Id
	private String id;
	
	@Indexed
	private String serialNumber;
	
	@Indexed
	private String npwp;

	private String certificate;
	
	private Date creationDate;
	
}
