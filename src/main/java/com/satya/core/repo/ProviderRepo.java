package com.satya.core.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.satya.core.bean.Provider;

public interface ProviderRepo extends MongoRepository<Provider, Long> {
	public Provider findByProviderID(Long providerID);
	public Provider findByFirstname(String firstName);
    public List<Provider> findByLastname(String lastName);
    public Provider findByUserIdAndPassword(String userid,String Password);
    public Provider findByUserId(String userId);
    public Provider findByGovtIdAndGovtIdType(String govtId,String govtIdType);
    
    
    public Page<Provider> findByFirstnameLikeIgnoringCaseAndLastnameLikeIgnoringCaseAndZip(String firstname,String lastname,String zip,Pageable pageable);
    public Page<Provider> findByFirstnameLikeIgnoringCaseAndZip(String firstname,String zip,Pageable pageable);
    public Page<Provider> findByLastnameLikeIgnoringCaseAndZip(String lastname,String zip,Pageable pageable);
   
    public Page<Provider> findByFirstnameLikeIgnoringCaseAndLastnameLikeIgnoringCaseAndAddress1LikeIgnoringCaseAndProvinceAndCity(String firstname,String lastname,String address1,String province,String city,Pageable pageable);
    public Page<Provider> findByFirstnameLikeIgnoringCaseAndAddress1LikeIgnoringCaseAndProvinceAndCity(String firstname,String address1,String province,String city,Pageable pageable);
    public Page<Provider> findByLastnameLikeIgnoringCaseAndAddress1LikeIgnoringCaseAndProvinceAndCity(String lastname,String address1,String province,String city,Pageable pageable);

    public Page<Provider> findByFirstnameLikeIgnoringCaseAndLastnameLikeIgnoringCaseAndProvinceAndCity(String firstname,String lastname,String province,String city,Pageable pageable);
    public Page<Provider> findByFirstnameLikeIgnoringCaseAndProvinceAndCity(String firstname,String province,String city,Pageable pageable);
    public Page<Provider> findByLastnameLikeIgnoringCaseAndProvinceAndCity(String lastname,String province,String city,Pageable pageable);

}
