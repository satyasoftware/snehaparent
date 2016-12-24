package com.satya.core.repo;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.satya.core.bean.Drugs;

public interface DrugsRepo extends MongoRepository<Drugs, Long>{
	
	@Query( fields="{_id :1,nonProprietaryName :1,dosageFormName :1,strengthNumber:1,strengthUnit:1}") 
	Collection<Drugs> findByNonProprietaryNameLikeIgnoringCaseOrderByNonProprietaryName(String drname);
	
	@Query(value="{nonProprietaryName : {$regex : \".*testosterone.*\" , \"$options\" : \"i\"}}", fields="{_id :1,nonProprietaryName :1,dosageFormName :1,strengthNumber:1,strengthUnit:1,proprietaryName:1}") 
	Page<Drugs> findByNonProprietaryNameLikeIgnoringCase(String drname,Pageable page);
	
	//@Query(value="{nonProprietaryName : {$regex : ?0}}", fields="{_id :1,nonProprietaryName :1,dosageFormName :1,strengthNumber:1,strengthUnit:1,proprietaryName:1}")
   // public Page<Drugs> getByNonProprietaryNameRegexQuery(String nonProprietaryName,Pageable page);
	
	@Query(value="{ \"nonProprietaryName\" : { \"$regex\" : \".*testosterone.*\" , \"$options\" : \"i\"}}", fields="{ nonProprietaryName : 1 , strengthUnit : 1 , strengthNumber : 1 , dosageFormName: 1 , _id : 1}")
	 public Page<Drugs> getByNonProprietaryNameRegexQuery(String nonProprietaryName,Pageable page);
}
