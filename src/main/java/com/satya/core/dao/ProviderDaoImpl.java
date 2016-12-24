package com.satya.core.dao;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.satya.core.bean.DoctorNurseMap;
import com.satya.core.bean.Institution;
import com.satya.core.bean.Person;
import com.satya.core.bean.Provider;
import com.satya.core.bean.ProviderInstitute;

@Repository ("providerDao")
public class ProviderDaoImpl implements  ProviderDao{
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public List<Provider> searchForProvider(String name){
		
		Query query = new Query();
		query.limit(120);	
		Criteria criteria = new Criteria();
        criteria.orOperator(Criteria.where("firstname").regex(Pattern.compile(name, Pattern.CASE_INSENSITIVE)),Criteria.where("lastname").regex(Pattern.compile(name, Pattern.CASE_INSENSITIVE)),Criteria.where("regNo").regex(Pattern.compile(name, Pattern.CASE_INSENSITIVE)));
		//query.addCriteria(Criteria.where("firstname").regex(Pattern.compile(name, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)));   
		query.addCriteria(criteria);
		query.fields().include("_id").include("firstname").include("lastname").include("regNo").include("regDept");
	List<Provider> providers=mongoTemplate.find(query, Provider.class);
	System.out.println("size="+providers.size());
	return providers;
	}
	
	@Override
	public List<Institution> searchForInstitution(String instname,String instType){
		
		Query query = new Query();
		query.limit(120);	
		Criteria criteria = new Criteria();
        if(instType!="")criteria.andOperator(Criteria.where("instName").regex(Pattern.compile(instname, Pattern.CASE_INSENSITIVE)),Criteria.where("instType").regex(Pattern.compile(instType, Pattern.CASE_INSENSITIVE)));
		else criteria.orOperator(Criteria.where("instName").regex(Pattern.compile(instname, Pattern.CASE_INSENSITIVE)));
        //query.addCriteria(Criteria.where("firstname").regex(Pattern.compile(name, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)));   
		query.addCriteria(criteria);
		query.fields().include("_id").include("instName").include("regNo").include("phone1").include("instType");
	List<Institution> institutions=mongoTemplate.find(query, Institution.class);
	System.out.println("size="+institutions.size());
	return institutions;
	}
	
	
	
	@Override
	public Collection<Provider> getInstProviders(Collection<Long> proIds){
		Query query = new Query();
		//Criteria criteria = new Criteria();
        //criteria.(Criteria.where("providerID").in(proIds) );
        query.addCriteria(Criteria.where("providerID").in(proIds));
		//query.addCriteria(criteria);
		query.fields().include("_id").include("firstname").include("lastname").include("regNo").include("regDept");
	List<Provider> providers=mongoTemplate.find(query, Provider.class);
	System.out.println("size="+providers.size());
	return providers;
	}
	
	public Collection<ProviderInstitute> getNurses(Long instId,Long nurseIds){
		Query query = new Query();
		Criteria criteria = new Criteria();
		criteria.andOperator(Criteria.where("instId").in(instId),Criteria.where("provId").nin(nurseIds),Criteria.where("provType").in("Nurse"));
		 query.addCriteria(criteria);
	List<ProviderInstitute> result = mongoTemplate.find(query, ProviderInstitute.class);
	return result;
	}
	
	@Override
	public Provider findProvider(Long proId){
		Query query = new Query(Criteria.where("providerID").is(proId));
		query.fields().include("_id").include("firstname").include("lastname").include("regNo").include("regDept");
		return mongoTemplate.findOne(query, Provider.class);
	}	
	
	@Override
	public Person findPerson(Long persId){ //cell_number
		Query query = new Query(Criteria.where("id").is(persId));
		query.fields().include("_id").include("firstname").include("lastname").include("cell_number");
		return mongoTemplate.findOne(query, Person.class);
	}	
	
	
	public List<Provider> searchForProviderByReg(String regNo){
		
		Query query = new Query();
		query.limit(120);	
		Criteria criteria = new Criteria();
        criteria.orOperator(Criteria.where("regNo").regex(Pattern.compile(regNo, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)));
		//query.addCriteria(Criteria.where("firstname").regex(Pattern.compile(name, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)));   
		query.addCriteria(criteria);
		query.fields().include("_id").include("firstname").include("lastname").include("regNo").include("regDept");
	List<Provider> providers=mongoTemplate.find(query, Provider.class);
	System.out.println("size="+providers.size());
	return providers;
	}
	
	@Override
	public BigInteger getMaxDoctNurseMapId(){
		BigInteger big=new BigInteger("1");
		try{
		Query query = new Query();
		query.with(new Sort(Sort.Direction.DESC,"mapId"));
        query.limit(1);
		query.fields().include("_id");
		DoctorNurseMap sub=mongoTemplate.findOne(query, DoctorNurseMap.class);
		if(sub==null || sub.getMapId()==null) return big;
		return big=new BigInteger(sub.getMapId()+"1");
		}catch(NullPointerException e){e.printStackTrace();}
		return big;
	}
	
	
}
