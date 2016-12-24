package com.satya.core.service;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.satya.core.bean.AdminRequest;
import com.satya.core.bean.PerSeqId;
import com.satya.core.repo.AdminRequestRepo;
import com.satya.core.repo.InstitutionRepo;
import com.satya.core.repo.PersonSeqRepo;
import com.satya.core.repo.ProviderRepo;

@Service("admReqService")
@Transactional(readOnly = true)
public class AdmReqServiceImpl implements AdmReqService {
	
	@Autowired private AdminRequestRepo admReqRepo;
	
	@Autowired private PersonSeqRepo personSeqRepo;
	
	//@Autowired private MongoTemplate mongoTemplate;
	
	@Autowired private InstitutionRepo instRepo;

	@Autowired private ProviderRepo provRepo; 
	
	/*public void saveUser(){
	SessionUser user = new SessionUser();
	user.setFirstname("Albert"); 
	user.setId(1L);
	user.setMobile(7306765272L);
	mongoTemplate.save(user, "user");
	}*/
	
	public AdminRequest saveRequest(AdminRequest req){
		req.setAdmReqId(getadmReqSequenceId());
		req.setCreateddate(new Date());
		req.setAdmReqStatus("Pending");
		req.setStatus(false);
		req.setCreatedUserId(req.getProviderId());
		return admReqRepo.save(req);
		
	}
	
	@Override
	public List<AdminRequest>	getPendingRequest(Long provId,String admReqstatus){
		List<AdminRequest> pendList=admReqRepo.findByProviderIdAndAdmReqStatus(provId,admReqstatus);
		//AdminRequest pendReq=adminReqRepo.findByAdmReqIdAndInstIdAndAdmReqStatus(admReqId, instId,"Pending");
		for(AdminRequest pendReq:pendList){
			pendReq.setInstitution(instRepo.findByInstId(pendReq.getInstId()));
			pendReq.setProvider(provRepo.findByProviderID(pendReq.getProviderId()));
		}
		return pendList;
	}
	public long getadmReqSequenceId() {
	   	PerSeqId seq=new PerSeqId();
	   	List<PerSeqId> seqList = personSeqRepo.findAll();
	   	if(seqList==null || CollectionUtils.isEmpty(seqList) ){
	   		seq.setAdmReqId(1L);
	   	}else{
	   		seq=seqList.get(0);
	   		seq.setAdmReqId(seq.getAdmReqId()==null?1L:seq.getAdmReqId()+1);
	   		}
	   	personSeqRepo.save(seq);
	   	System.out.println("seqid==="+seq.getAdmReqId());
	   	return seq.getAdmReqId();

	     }	
}
