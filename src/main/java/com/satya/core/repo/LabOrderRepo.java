package com.satya.core.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.satya.core.bean.LabOrder;

public interface LabOrderRepo extends MongoRepository<LabOrder, Long> {
	List<LabOrder> findTop6ByEncounterIdOrderByCreateTsDesc(Long encounterId);

}
