package com.satya.core.repo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.satya.core.bean.Institution;
public interface InstitutionRepo extends MongoRepository<Institution,Long> {

	Institution findByInstId(Long instId);
	
	//regex(Pattern.compile(name, Pattern.CASE_INSENSITIVE))
	//@Query("{ 'instName':{$regex:?0,$options:'i'}}")  //{"firstname" : {"$regex" : firstname }}
	Page<Institution> findByInstNameLikeIgnoringCaseAndAddress1IgnoringCaseAndProvinceAndCity(String instName,String address1,String province,String city,Pageable pageable);
	
	Page<Institution> findByInstNameLikeIgnoringCaseAndProvinceAndCity(String instName,String province,String city,Pageable pageable);
	
	Page<Institution> findByInstNameLikeIgnoringCaseAndZip(String instName,String zip,Pageable pageable);
}
