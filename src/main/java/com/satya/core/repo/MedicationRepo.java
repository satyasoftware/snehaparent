package com.satya.core.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.satya.core.bean.MedicalOrder;

public interface MedicationRepo extends MongoRepository<MedicalOrder, Long> {
	List<MedicalOrder> findTop6ByEncounterIdOrderByCreateTsDesc(Long encounterId);
}
