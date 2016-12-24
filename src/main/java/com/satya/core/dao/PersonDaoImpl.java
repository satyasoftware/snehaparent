package com.satya.core.dao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.satya.core.bean.Person;

@Repository ("PersonDao")
public class PersonDaoImpl implements PersonDao {
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public List<Person> searchForPerson(String name){
		
		Query query = new Query();
		query.limit(120);	
		Criteria criteria = new Criteria();
        criteria.orOperator(Criteria.where("firstname").regex(Pattern.compile(name, Pattern.CASE_INSENSITIVE)),Criteria.where("lastname").regex(Pattern.compile(name, Pattern.CASE_INSENSITIVE)),Criteria.where("userId").regex(Pattern.compile(name, Pattern.CASE_INSENSITIVE)));
		//query.addCriteria(Criteria.where("firstname").regex(Pattern.compile(name, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)));   
		query.addCriteria(criteria);
		System.out.println("criteria = "+criteria.getCriteriaObject());
		query.fields().include("_id").include("firstname").include("lastname").include("userId");
		List<Person> persons=mongoTemplate.find(query, Person.class);
		System.out.println("size="+persons.size());
		return persons;
	}
	
	@Override
	public List<Person> searchForPerson(String name,String userId,String email,String govtId,String govtIdType, Date birthday,Long mobile, Date nextday){

		Query query = getCriteriaFromData(name, userId, email, govtId, govtIdType, birthday, mobile, nextday);
		if(query==null) return null;
		query.limit(50);	
		query.fields().include("_id").include("firstname").include("lastname").include("userId").include("email").include("birthday").include("cell_number").include("govtIdType").include("govtId");
		List<Person> persons=mongoTemplate.find(query, Person.class);
		System.out.println("Deep search size="+persons.size());
		return persons;
	}
	
	private Query getCriteriaFromData(String name,String userId,String email,String govtId,String govtIdType, Date birthday,Long mobile, Date nextday){
		Query query =null;
		List<Criteria> crList=new ArrayList<Criteria>();
		if((name!="" || name!=null) && name.length()>3){
			crList.add(Criteria.where("firstname").regex(Pattern.compile(name, Pattern.CASE_INSENSITIVE)));
		}
		
		if((email!="" || email!=null) && email.length()>6){
			crList.add(Criteria.where("email").is(Pattern.compile(email, Pattern.CASE_INSENSITIVE))); 
		}
		if((userId!="" || userId!=null) && userId.length()>3){
			crList.add( Criteria.where("userId").is(Pattern.compile(userId, Pattern.CASE_INSENSITIVE)));
		}
		if(govtId!="" && govtIdType!=""){
			crList.add(Criteria.where("govtId").is(govtId));
			crList.add(Criteria.where("govtIdType").in(govtIdType));
		}
		if(mobile!=null && mobile.toString().length()>8){
			crList.add(Criteria.where("cell_number").is(mobile));
		}
		if(birthday!=null && birthday.toString().length()>8){
			crList.add(Criteria.where("birthday").gt(birthday));
			crList.add(Criteria.where("birthday").lt(nextday));
		}

		System.out.println("cri size=="+crList.size()+ "birthday=="+birthday);
		if(crList.size()==0){
			return null;
		}
		else query =new Query();
		Criteria criteria = new Criteria().andOperator(crList.toArray(new Criteria[crList.size()]));
		query.addCriteria(criteria);
	    System.out.println(criteria.getCriteriaObject());
		return query;
  }
}
