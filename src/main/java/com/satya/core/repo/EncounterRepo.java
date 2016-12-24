package com.satya.core.repo;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.satya.core.bean.Encounter;

public interface EncounterRepo extends MongoRepository<Encounter, Long> {

	
	Collection<Encounter> findByInstIdAndStatus(Long instId, char status);
	Collection<Encounter> findByInstIdAndWardAndStatus(Long instId,String ward, char status);
	Encounter findByEncounterIdAndInstId(Long encountId,Long instId);
	
	Page<Encounter> findByInstIdAndWardAndStatusAndEncounterTypeOrderByEncounterIdDesc(Long instId,String ward, char status,String encounterType,Pageable page);
	Page<Encounter> findByInstIdAndStatusAndEncounterTypeOrderByEncounterIdDesc(Long instId, char status,String encounterType,Pageable page);

	Page<Encounter> findByInstIdAndStatusOrderByEncounterIdDesc(Long instId, char status,Pageable page);
	
	 @Query( fields="{_id :1}") 
	 Long findByInstIdAndEncounterNumber(Long instId,String encounterNumber);
	
	// @Query(value="{'$and':[{'instId' : ?0, status : 'O', encounterType : ?1}]}", fields="{_id : 1}")
	// Collection<Long> findAllOpenEncounterTypes(Long instId, char status,String encounterType);
	// @Query( fields="{_id :1}") 
	//Collection<Long> findByInstIdAndStatusAndEncounterType(Long instId, char status,String encounterType);
	 
	 
	 Collection<Encounter> findByInstIdAndStatusAndEncounterTypeAndWard(Long instId, char status,String encounterType,String ward);
	 
	 Collection<Encounter> findByInstIdAndStatusAndEncounterType(Long instId, char status,String encounterType);
	 
}
