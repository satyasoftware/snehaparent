package com.satya.core.repo;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.satya.core.bean.Appointment;

public interface AppointmentRepo extends MongoRepository<Appointment, Long> {
	
	public Collection<Appointment> findByInstIdAndStartDtTm(Long instId, Date startDtTm);
	
	public Collection<Appointment> findByInstId(Long instId);
	
	public Collection<Appointment> findByInstIdAndStatus(Long instId,char status);
	
	public Page<Appointment> findByInstId(Long instId,Pageable pageable);
	
	public Page<Appointment> findByInstIdAndStartDtTm(Long instId,Date startDtTm,Pageable pageable);
	
	 public Appointment findByAppointmentId(Long appointId);
	 public Appointment findByAppointmentIdAndStatus(Long appointId,char status);
	 
	 public Collection<Appointment> findByInstIdAndPreferedProvider(Long instId,Long provider);
	 
	 public Page<Appointment> findByInstIdAndStatusAndStartDtTmIsBetween(Long instId,char status,Date start,Date end,Pageable pageable);
	 
	 public Collection<Appointment> findByInstIdAndStatusAndStartDtTmBetweenAndPreferedProviderInOrPreferedProvider(Long instId,char status,Date start,Date end,Collection<Long> provIds,Long empty);

}
