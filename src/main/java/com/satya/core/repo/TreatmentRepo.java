package com.satya.core.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.satya.core.bean.Treatment;

public interface TreatmentRepo extends MongoRepository<Treatment, Long> {

	Treatment findByTreatmentId(Long treatmentId);
	List<Treatment> findByEncounterIdAndStatus(Long encounId,char status);
	
	 @Query(value="{'$and':[{'encounterId' : ?0, status : 'O', providerId : {$in : ?1}}]}", fields="{_id : 0, providerId : 1,attendingPhysician : 1}")
	// "{'$or' : [{'population' : {$lt : ?0}}, {'area' : {$lt : ?1}}]}"
	Collection<Treatment> findAllEncounterAssignedDoctors(Long encounId,Collection<Long> proIds);
	 
	 Collection<Treatment> findByInstIdAndProviderIdAndStatus(Long encounId,Long proIds,char status);
	 
	Collection<Treatment> findByEncounterIdAndProviderIdIn(Long encounId,Collection<Long> proIds);
	
	Treatment findByEncounterIdAndProviderIdAndInstId(Long encounId,Long provId,Long instId);
	
	Treatment findByEncounterIdAndInstIdAndAttendingPhysician(Long encounId,Long instId,char status);
	Collection<Treatment> findByInstIdAndStatusAndProviderIdOrProviderIdInOrderByEncounterId(Long instId,char status,Long nurseId,Collection<Long> proIds);
	
	 @Query( fields="{_id : 0, providerId :1}") 
	 Treatment findByEncounterIdAndProviderIdAndInstIdAndStatus(Long encounId,Long provId,Long instId,char status);
	 
	 Collection<Treatment> findByInstIdAndEncounterTypeAndProviderIdInAndStatusOrderByEncounterId(Long instId,String encounType,Collection<Long> proIds,char status);
	 
	 
	 Collection<Treatment> findByInstIdAndStatusAndProviderIdAndEncounterTypeOrderByEncounterId(Long instId,char status,Long provId,String encounType);
	 
	 Collection<Treatment> findByEncounterIdInAndProviderIdInAndStatusOrderByEncounterId(Collection<Long> encounIds,Collection<Long> proIds,char status);
	 
	 Collection<Treatment>  findByInstIdAndEncounterTypeAndProviderTypeAndStatusOrderByEncounterId(Long instId,String provType,String encounType,char status);
	
	 Collection<Treatment> findByEncounterIdInAndProviderTypeAndStatusOrderByEncounterId(Collection<Long> encounIds,String provType,char status);


}
