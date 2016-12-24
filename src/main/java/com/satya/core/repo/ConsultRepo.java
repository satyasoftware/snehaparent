package com.satya.core.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.satya.core.bean.Consult;

public interface ConsultRepo extends MongoRepository<Consult, Long> {
	List<Consult> findTop6ByEncounterIdOrderByCreateTsDesc(Long encounterId);
	List<Consult> findTop10ByEncounterIdOrderByConsultIdDesc(Long encounterId);
}
