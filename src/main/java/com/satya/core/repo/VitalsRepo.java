package com.satya.core.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.satya.core.bean.Vitals;

public interface VitalsRepo extends MongoRepository<Vitals, Long>  {
	
	List<Vitals> findTop6ByEncounterIdOrderByCreateTsDesc(Long encounterId);
	List<Vitals> findTop10ByEncounterIdOrderByVitalIdDesc(Long encounterId);
	List<Vitals> findTop6ByEncounterIdOrderByVitalIdDesc(Long encounterId);
}
