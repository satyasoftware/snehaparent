package com.satya.core.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.satya.core.bean.ProviderSecurity;

public interface ProviderSecurityRepo extends MongoRepository<ProviderSecurity, Long> {

}
