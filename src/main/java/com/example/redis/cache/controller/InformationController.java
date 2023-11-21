package com.example.redis.cache.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.redis.cache.entity.Information;
import com.example.redis.cache.entity.Student;
import com.example.redis.cache.response.ResponseTemplate;
import com.example.redis.cache.service.InformationService;

@RestController
@RequestMapping("info")
public class InformationController {

	@Autowired
	private InformationService infoService;
	
	@GetMapping("list")
	public ResponseTemplate list() {
		List<Information> informations = new ArrayList<Information>();
		
		Date start = new Date();
		Iterable<Information> iInformations = infoService.findAll();
		ResponseTemplate response = new ResponseTemplate();
		
		iInformations.forEach(informations::add);
		Date end = new Date();
		Long time = end.getTime() - start.getTime();
		
		response.setStatus(1);
		response.setMessage(String.format("Success retrieve information from redis %s ms", time));
		response.setData(informations);
		
		return response;
	}
	
	@GetMapping("find")
	public ResponseTemplate find(@RequestParam("sn") String serialNumber) {

		Date start = new Date();
		Information information = infoService.findBySerialNumber(serialNumber);
		ResponseTemplate response = new ResponseTemplate();
		Date end = new Date();
		Long time = end.getTime() - start.getTime();
		
		response.setStatus(1);
		response.setMessage(String.format("Success retrieve information from redis %s ms", time));
		response.setData(information);
		
		return response;
	}
	
	@PostMapping("add")
	public ResponseTemplate add(@RequestBody Information information) {
		
		ResponseTemplate response = new ResponseTemplate();
		
		infoService.save(information);
		
		response.setStatus(1);
		response.setMessage("Success save data from redis");
		response.setData(information);
		
		return response;
	}
	
	
}
