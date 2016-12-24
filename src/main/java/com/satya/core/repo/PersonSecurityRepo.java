package com.satya.core.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.satya.core.bean.PersonSecurity;

public interface PersonSecurityRepo extends MongoRepository<PersonSecurity, Long> {

}
