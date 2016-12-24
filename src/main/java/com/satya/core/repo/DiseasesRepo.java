package com.satya.core.repo;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.satya.core.bean.Diseases;
public interface DiseasesRepo extends MongoRepository<Diseases, Long>{
	Page<Diseases>  findByDiseaseNameLikeIgnoringCase(String diseaseName,Pageable page);
}
