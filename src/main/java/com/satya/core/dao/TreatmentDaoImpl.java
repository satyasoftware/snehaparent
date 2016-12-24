package com.satya.core.dao;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.satya.core.bean.Notes;
import com.satya.core.bean.Treatment;

@Repository ("TreatmentDao")
public class TreatmentDaoImpl implements TreatmentDao {
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public Collection<Treatment> getTreatmentDocts(Collection<Long> doctIds,Long encounterId){
		Query query = new Query();
		Criteria criteria = new Criteria();
        //criteria.(Criteria.where("providerID").in(proIds) ); encounterId
		criteria.andOperator(Criteria.where("encounterId").is(encounterId),Criteria.where("providerID").in(doctIds));
		query.addCriteria(criteria);
		query.fields().include("_id").include("providerID");
	List<Treatment> providers=mongoTemplate.find(query, Treatment.class);
	System.out.println("size="+providers.size()+" mm "+query.getQueryObject());
	return providers;
	}
	
	@Override
	public List<Notes> getEncounterNotes(Long encounterId){
		Query query = findQuery(encounterId);
		//Criteria criteria = new Criteria();
		//criteria.(Criteria.where("instId").is(instId));
		//criteria.andOperator(Criteria.where("encounterId").is(encounterId));
		//query.with(new Sort(Sort.Direction.ASC,"stickystatus"));
		//query.addCriteria(criteria);
        query.with(new Sort(Sort.Direction.ASC,"stickystatus"));
        //query.with(new Sort(Sort.Direction.DESC,"notesId"));
       // query.addCriteria(criteria);
      // query.fields().include("_id").include("encounterType").include("person");
        System.out.println("query object="+query.getQueryObject());
	   return mongoTemplate.find(query, Notes.class);
	}
	
	
	Query findQuery(Long encounterId){
	Query query =new Query();
	List<String> stickStatuList=new ArrayList<String>();
	stickStatuList.add("O");
	stickStatuList.add("");
	List<Criteria> crList=new ArrayList<Criteria>();
		crList.add(Criteria.where("encounterId").is(encounterId));
		crList.add(Criteria.where("stickystatus").ne("D"));
		Criteria criteria = new Criteria().andOperator(crList.toArray(new Criteria[crList.size()]));
		query.addCriteria(criteria);
		return query;
	}
}
