package com.satya.core.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.satya.core.bean.RequestCorresponds;

public interface RequestCorrespondsRepo extends MongoRepository<RequestCorresponds, Long> {

}
