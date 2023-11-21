package com.example.redis.cache.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InformationDto {
	private String id;
	private String serial_number;
	private String npwp;
	private String certificate;
	
	private Date creation_date;
}
