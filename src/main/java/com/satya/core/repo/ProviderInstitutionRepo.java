package com.satya.core.repo;

import java.util.Collection;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.satya.core.bean.ProviderInstitute;

public interface ProviderInstitutionRepo extends MongoRepository<ProviderInstitute, Long> {

	Collection<ProviderInstitute> findByProvIdOrderByInstId(Long provId);
	
	Collection<ProviderInstitute> findByProvIdAndProvType(Long provId,String provType);
	
	ProviderInstitute findByProvIdAndInstIdAndProvType(Long provId,Long instId,String provType);
	
	Collection<ProviderInstitute >findByInstIdAndProvTypeAndStatus(Long instId,String provType,Boolean status);
	
	Collection<ProviderInstitute >findByInstIdAndProvTypeNotAndStatus(Long instId,String provType,Boolean status);
	
	ProviderInstitute findByProvInstId(Long provInstId);
	
	ProviderInstitute findByProvInstIdAndStatus(Long provInstId,Boolean status);
	
	Collection<ProviderInstitute> findByInstId(Long instId);
}
