package com.satya.core.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.satya.core.bean.LabTest;

public interface LabTestRepo extends MongoRepository<LabTest, Long> {

}
