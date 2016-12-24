package com.satya.core.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.satya.core.bean.AdminRequest;
import com.satya.core.bean.PerSeqId;
import com.satya.core.bean.RequestCorresponds;
import com.satya.core.bean.SpAdmin;
import com.satya.core.repo.AdminRequestRepo;
import com.satya.core.repo.InstitutionRepo;
import com.satya.core.repo.PersonSeqRepo;
import com.satya.core.repo.ProviderRepo;
import com.satya.core.repo.RequestCorrespondsRepo;
import com.satya.core.repo.SpAdminRepo;
@Service("spAdminService")
//@Transactional(readOnly = true)
public class SpAdminServiceImpl implements SpAdminService {
@Autowired 
private SpAdminRepo spAdminRepo;
@Autowired 
private PersonSeqRepo seqRepo;

@Autowired 
private AdminRequestRepo adminReqRepo;

@Autowired 
private InstitutionRepo instRepo;

@Autowired 
private ProviderRepo provRepo; 

@Autowired 
private RequestCorrespondsRepo reqCorrRepo;

@Override
public SpAdmin save(SpAdmin supAdmin){
	       supAdmin.setSuperID(getSuperadmId());
		return spAdminRepo.save(supAdmin);
	}

@Override	
	public SpAdmin update(SpAdmin supAdmin){
	
		return spAdminRepo.save(supAdmin);
	}

@Override	
public SpAdmin checkForLogin(final String userId, final String password){
	return spAdminRepo.findByUserIdAndPassword(userId, password);
}

@Override
public List<AdminRequest>	getAllRequests(String status){
	List<AdminRequest> pendReqList=new ArrayList<AdminRequest>();
	//pendReqList=adminReqRepo.findByAdmReqStatus(status);
	pendReqList=adminReqRepo.findAll();
	if(pendReqList.size()>0){
		for(AdminRequest req:pendReqList)
			req.setInstitution(instRepo.findByInstId(req.getInstId()));
	}
	return pendReqList;
}

@Override
public AdminRequest	getAdmRequest(Long admReqId,Long instId){
	AdminRequest pendReq=adminReqRepo.findByAdmReqIdAndInstId(admReqId, instId);
	//AdminRequest pendReq=adminReqRepo.findByAdmReqIdAndInstIdAndAdmReqStatus(admReqId, instId,"Pending");
	if(pendReq!=null){
		pendReq.setInstitution(instRepo.findByInstId(pendReq.getInstId()));
		pendReq.setProvider(provRepo.findByProviderID(pendReq.getProviderId()));
	}
	return pendReq;
}
@Override
public AdminRequest	updateAdmRequestStatus(RequestCorresponds admCorr){
	AdminRequest pendReq=adminReqRepo.findByAdmReqId(admCorr.getAdmReqId());
	pendReq.setAdmReqStatus(admCorr.getAdmReqStatus());
	if(admCorr.getAdmReqStatus().equals("Approved"))
		pendReq.setStatus(true);
	pendReq=adminReqRepo.save(pendReq);
	admCorr.setCorresId(getAdmReqCorrId());
	reqCorrRepo.save(admCorr);
	return pendReq;
}

public Long getAdmReqCorrId(){
	PerSeqId seq=new PerSeqId();
   	List<PerSeqId> seqList = seqRepo.findAll();
   	if(seqList==null || CollectionUtils.isEmpty(seqList) ){
   		seq.setAdmReqCorrId(1L);
   	}else{
   		seq=seqList.get(0);
   		seq.setAdmReqCorrId(seq.getAdmReqCorrId()==null?1L:seq.getAdmReqCorrId()+1);
   		}
   	seqRepo.save(seq);
   	System.out.println("seqid==="+seq.getAdmReqCorrId());
   	return seq.getAdmReqCorrId();
}
public Long getSuperadmId() {
	
	PerSeqId seq=new PerSeqId();
   	List<PerSeqId> seqList = seqRepo.findAll();
   	if(seqList==null || CollectionUtils.isEmpty(seqList) ){
   		seq.setSuperadmId(1L);
   	}else{
   		seq=seqList.get(0);
   		seq.setSuperadmId(seq.getSuperadmId()==null?1L:seq.getSuperadmId()+1);
   		}
   	seqRepo.save(seq);
   	System.out.println("seqid==="+seq.getSuperadmId());
   	return seq.getSuperadmId();

     }
}
