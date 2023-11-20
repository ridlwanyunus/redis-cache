package com.example.redis.cache.entity;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@RedisHash("Student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {

	private String id;
	private String name;
	private String gender;
	private int grade;
	
}
