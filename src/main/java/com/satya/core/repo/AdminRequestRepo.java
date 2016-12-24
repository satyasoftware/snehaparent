package com.satya.core.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.satya.core.bean.AdminRequest;

public interface AdminRequestRepo extends MongoRepository<AdminRequest, Long> {
	
	public List<AdminRequest> findByAdmReqStatus(String status);
	
	public List<AdminRequest> findAll();
	public AdminRequest findByAdmReqId(Long admReqId);
	public AdminRequest findByAdmReqIdAndInstId(Long admReqId,Long instId);
	
	public AdminRequest findByAdmReqIdAndInstIdAndAdmReqStatus(Long admReqId,Long instId,String status);
	public List<AdminRequest> findByProviderIdAndAdmReqStatus(Long providerId,String status);
}
