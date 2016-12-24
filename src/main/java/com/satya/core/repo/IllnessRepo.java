package com.satya.core.repo;

import java.util.Collection;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.satya.core.bean.Illness;

public interface IllnessRepo extends MongoRepository<Illness, Long> {

	Collection<Illness> findByEncounterId(Long encounterId);
}
