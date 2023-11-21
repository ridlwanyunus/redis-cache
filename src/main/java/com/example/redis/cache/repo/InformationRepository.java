package com.example.redis.cache.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.redis.cache.entity.Information;

@Repository
public interface InformationRepository extends CrudRepository<Information, String>{

	public Information findBySerialNumber(String serialNumber);
	
}
