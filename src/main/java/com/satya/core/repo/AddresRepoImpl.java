package com.satya.core.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.satya.core.bean.SessionUser;

public class AddresRepoImpl{
	@Autowired
	private MongoTemplate mongoTemplate;
	public void saveUser(){
	SessionUser user = new SessionUser();
	user.setFirstname("Albert"); 
	user.setUserId(1L);
	user.setMobile(7306765272L);
	mongoTemplate.save(user, "user");
	}
}
