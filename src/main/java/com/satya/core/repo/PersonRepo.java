package com.satya.core.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.satya.core.bean.Person;

public interface PersonRepo extends MongoRepository<Person, Long> {
	public Person findById(Long id);
	public Person  findByUserId(String userId);
	public Person findByFirstname(String firstName);
    public List<Person> findByLastname(String lastName);
    public Person findByUserIdAndPassword(String userid,String Password);
    public Person findByGovtIdAndGovtIdType(String govtId,String govtIdType);
    
    
public List<Person> findByFirstnameLikeIgnoringCaseAndLastnameLikeIgnoringCaseAndUserIdIgnoringCaseAndGovtIdAndGovtIdTypeAndBirthdayAndEmail
(String firstname,String lastname,String userid,String govtId,String govtIdType,Date dob,String email);

public List<Person> findByFirstnameLikeIgnoringCaseOrGovtIdAndGovtIdType(String name,String govtId,String govtIdType);
    
    public Page<Person> findAll(Pageable pageable);
}
