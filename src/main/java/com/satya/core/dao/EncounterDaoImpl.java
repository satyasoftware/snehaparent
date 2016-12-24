package com.satya.core.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.satya.core.bean.Encounter;
import com.satya.core.bean.Treatment;

@Repository ("EncounterDao")
public class EncounterDaoImpl implements EncounterDao {
	@Autowired
	private MongoTemplate mongoTemplate;
	
	
	

	@Override
	public List<Encounter> getInstEncounters(Long instId){
		Query query = new Query();
		//Criteria criteria = new Criteria();
		//criteria.(Criteria.where("instId").is(instId));
        query.addCriteria(Criteria.where("instId").is(instId));
       // query.with(new Sort(Sort.Direction.ASC,"menuId"));
      // query.fields().include("_id").include("encounterType").include("person");
        System.out.println("query object="+query.getQueryObject());
	   return mongoTemplate.find(query, Encounter.class);
	    
	}
	
	
	@Override
	public Long getEncounterId(){
		//Integer maxid=1;
		try{Query query = new Query();
		query.with(new Sort(Sort.Direction.DESC,"encounterId"));
        query.limit(1);
		query.fields().include("_id");
		Encounter appo=mongoTemplate.findOne(query, Encounter.class);
		if(appo==null || appo.getEncounterId()==null) return 1L;
		else return appo.getEncounterId()+1;
		}catch(Exception e){e.printStackTrace();}
		return 1L;
	}
	@Override
	public Long getTreatmentId(){
		Long maxid=1L;
		try{Query query = new Query();
		query.with(new Sort(Sort.Direction.DESC,"treatmentId"));
        query.limit(1);
		query.fields().include("_id");
		Treatment appo=mongoTemplate.findOne(query, Treatment.class);
		if(appo==null || appo.getTreatmentId()==null) maxid=1L;
		else maxid= appo.getTreatmentId()+1L;
		}catch(Exception e){e.printStackTrace();}
		finally{
			System.out.println("Treatment maxid="+maxid);
		}
		return maxid;
	}
	
}
