package com.satya.core.service;
import java.util.List;

import org.springframework.data.domain.Page;

import com.satya.core.bean.CodeTable;
import com.satya.core.bean.Person;

public interface PersonService {
	
	public Person findByUserIdAndPassword(String userId,String userpass);
	
	public CodeTable findAll();
	
	public Person save(Person person);
	public Person update(Person person);
	public Person updatePass(Person person);
	public List<Person> findAllPersons();
	
	public Person findPersonByUserId(String userId);
	
	public Person findByPersonId(Long personId);
	
	public Person findPersonByGovtIdAndType(String govtId,String govtIdType);
	
	public List<Person> searchForPerson(String name);
	
	public Person findAppointment(Long appointId,Person p);
	
	public Page<Person> findAllPersonsByPage(int pageno,int limit);
	
	public boolean checkPassword(String inputpaas,String dbpass);
	
	public List<Person> searchForPersonDeep(String name,String userid,String govtIdtype,String govtId,Long mobile,String mailId,String dob);
	
	/*public CodeTable codeTablesSave();*/
	public void pushLabTests();
}
