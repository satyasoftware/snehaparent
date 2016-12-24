package com.satya.core.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.satya.core.bean.SpAdmin;

public interface SpAdminRepo extends MongoRepository<SpAdmin, Long> {

	public SpAdmin findByUserIdAndPassword(String userId,String passwoed);
	
}
