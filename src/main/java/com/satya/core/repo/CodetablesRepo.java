package com.satya.core.repo;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.satya.core.bean.CodeTable;


public interface CodetablesRepo  extends MongoRepository<CodeTable, String> {
	List<CodeTable> findByInstType_InstType(String instType);
	
	//@Cacheable("codetable")
	List<CodeTable> findAll();
}
