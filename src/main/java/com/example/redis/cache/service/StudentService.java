package com.example.redis.cache.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.redis.cache.entity.Student;
import com.example.redis.cache.repo.StudentRepository;

@Service
public class StudentService {

	
	@Autowired
	private StudentRepository repo;
	
	public Iterable<Student> findAll(){
		return repo.findAll();
	}
	
	public void save(Student student) {
		repo.save(student);
	}
	
	public Optional<Student> findById(String id) {
		return repo.findById(id);
	}
	
	public void deleteById(String id) {
		repo.deleteById(id);
	}
	
	
	
	
}
