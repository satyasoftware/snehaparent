package com.satya.core.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.satya.core.bean.OtherOrders;

public interface OtherOrdersRepo extends MongoRepository<OtherOrders,Long> {
	List<OtherOrders> findTop6ByEncounterIdOrderByCreateTsDesc(Long encounterId);
	List<OtherOrders> findTop10ByEncounterIdOrderByOtherOrderIdDesc(Long encounterId);

}
