package com.satya.core.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.satya.core.bean.PerSeqId;

public interface PersonSeqRepo extends MongoRepository<PerSeqId, String> {
	public List<PerSeqId> findAll();
	
}
