package com.example.redis.cache.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.redis.cache.entity.Information;

@Repository
public interface InformationRepository extends CrudRepository<Information, String>{

}
