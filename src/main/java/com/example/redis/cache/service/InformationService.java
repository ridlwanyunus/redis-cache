package com.example.redis.cache.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.redis.cache.entity.Information;
import com.example.redis.cache.entity.Student;
import com.example.redis.cache.repo.InformationRepository;

@Service
public class InformationService {

	@Autowired
	private InformationRepository repo;
	
	
	public Iterable<Information> findAll(){
		return repo.findAll();
	}
	
	public void save(Information info) {
		repo.save(info);
	}
	
	public Optional<Information> findById(String id) {
		return repo.findById(id);
	}
	
	public Information findBySerialNumber(String serialNumber) {
		return repo.findBySerialNumber(serialNumber);
	}
}
