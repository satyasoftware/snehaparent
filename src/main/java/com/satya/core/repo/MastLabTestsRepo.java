package com.satya.core.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.satya.core.bean.MastLabTests;

public interface MastLabTestsRepo extends MongoRepository<MastLabTests, Long> {
 List<MastLabTests> findByTestnameLikeIgnoringCase(String testname);
}
