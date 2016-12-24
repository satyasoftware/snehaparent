package com.satya.core.repo;

import java.util.Collection;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.satya.core.bean.DoctorNurseMap;

public interface DoctorNurseMapRepo extends MongoRepository<DoctorNurseMap, Long> {
	Collection<DoctorNurseMap> findByInstIdAndDoctorId(Long instId,Long doctorId);
	
	Collection<DoctorNurseMap> findByInstIdAndDoctorIdAndStatus(Long instId,Long doctorId,String status);
	
	DoctorNurseMap findByInstIdAndDoctorIdAndNurseId(Long instId,Long doctorId,Long nurseId);
	
	Collection<DoctorNurseMap> findByInstIdAndNurseId(Long instId,Long nurseId);
}
