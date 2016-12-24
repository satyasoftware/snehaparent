package com.satya.core.dao;
import java.util.Date;
import java.util.List;

import com.satya.core.bean.Person;

public interface PersonDao {
	public List<Person> searchForPerson(String name);
	
	public List<Person> searchForPerson(String name,String userid,String mailId,String govdId,String govtIdtype, Date dob,Long mobile, Date nextday);
}
