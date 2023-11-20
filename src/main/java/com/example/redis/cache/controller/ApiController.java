package com.example.redis.cache.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.redis.cache.entity.Student;
import com.example.redis.cache.response.ResponseTemplate;
import com.example.redis.cache.service.StudentService;

@RestController
@RequestMapping("api")
public class ApiController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("list")
	public ResponseTemplate find() {
		List<Student> students = new ArrayList<Student>();
		Iterable<Student> iStudents = studentService.findAll();
		ResponseTemplate response = new ResponseTemplate();
		
		iStudents.forEach(students::add);
		response.setStatus(1);
		response.setMessage("Success retrieve data from redis");
		response.setData(students);
		
		return response;
	}
	
	@PostMapping("add")
	public ResponseTemplate add(@RequestBody Student student) {
		
		ResponseTemplate response = new ResponseTemplate();
		
		studentService.save(student);
		
		response.setStatus(1);
		response.setMessage("Success save data from redis");
		response.setData(student);
		
		return response;
	}
	
	
	
}
