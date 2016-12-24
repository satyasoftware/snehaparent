package com.satya.core.service;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.satya.core.bean.Appointment;
import com.satya.core.bean.Encounter;
import com.satya.core.bean.ProviderInstitute;
import com.satya.core.bean.Treatment;
import com.satya.core.beanLimit.ProviderL;
import com.satya.core.dao.EncounterDao;
import com.satya.core.enums.AppintmentTypes;
import com.satya.core.repo.AppointmentRepo;
import com.satya.core.repo.EncounterRepo;
import com.satya.core.repo.ProviderInstitutionRepo;
import com.satya.core.repo.TreatmentRepo;

@Service("encounterService")
//@Transactional(readOnly = true)
public class EncounterServiceImpl implements EncounterService {
	
	@Autowired	private EncounterRepo encountRepo;
	
	@Autowired	private AppointmentRepo appoRepo;
	
	@Autowired	private TreatmentRepo treatRepo;
	
	@Autowired private EncounterDao encounterDao;
	
	@Autowired private ProviderInstitutionRepo proInstRepo;
	
	
	public Encounter findEncounter(Long encounterId){
		return encountRepo.findOne(encounterId);
	}
	
	public List<Encounter> getInstEncounters(Long instId){
	    return encounterDao.getInstEncounters(instId);
	}
	
	public Collection<Encounter> getInstActiveEncounters(Long instId){
	    return encountRepo.findByInstIdAndStatus(instId, 'O');
	}
	
	public Page<Encounter> getInstActive20Encounters(Long instId,int pageno){
	    return encountRepo.findByInstIdAndStatusAndEncounterTypeOrderByEncounterIdDesc(instId,'O', AppintmentTypes.InPatient.toString(),new PageRequest(pageno,20));
	}
	
	
	public Page<Encounter> getInstActiveWardEncounters(Long instId,String ward,String encounterType,int pageno){
		
		if(ward!=null && ward !="")
		  return encountRepo.findByInstIdAndWardAndStatusAndEncounterTypeOrderByEncounterIdDesc(instId, ward, 'O', encounterType ,new PageRequest(pageno,20));
	   else return encountRepo.findByInstIdAndStatusAndEncounterTypeOrderByEncounterIdDesc(instId, 'O', encounterType, new PageRequest(pageno,20));
	}
	
	public Encounter saveEncounter(Encounter encounter){
		encounter.setEncounterId(encounterDao.getEncounterId());
		encounter.setEncounterNumber(generateAdmiNumber(encounter.getInstId()));
		encounter.setStartDtTm(new Date());
		encounter.setStatus('O');
		encounter.setTreatstart(encounter.getAssignDoctor()!=null?true:false);
		Encounter en= encountRepo.save(encounter);
		Appointment appo=appoRepo.findByAppointmentId(en.getAppointmentId());
		appo.setEndDtTm(new Date());
		appo.setUpdateTs(new Date());
		appo.setUpdateUId(en.getCreatedUId());
		appo.setStatus('C');
				appoRepo.save(appo);
				
			if(encounter.getAssignDoctor()!=null){
				Treatment tre=new Treatment();
				
				tre.setTreatmentId(encounterDao.getTreatmentId());
				tre.setInstId(encounter.getInstId());
				tre.setPatId(encounter.getPersonId());
				tre.setCreatedUId(encounter.getCreatedUId());
				tre.setCreateTs(new Date());
				tre.setEncounterId(en.getEncounterId());
				tre.setEncounterType(en.getEncounterType());
				tre.setEncounterStatus(en.getStatus());
				
				ProviderL proL=new ProviderL();
				proL.setProviderID(encounter.getAssignDoctor());
				tre.setProviderL(proL);
				tre.setProviderType("Doctor");
				
				tre.setProviderId(encounter.getAssignDoctor());
				tre.setAttendingPhysician('N');
				tre.setStatus('O');
				tre.setEncounter(encounter);
				treatRepo.save(tre);
			}	
				
		return en;
	}
	public Encounter saveEmrgeEncounter(Encounter encounter){
		encounter.setEncounterId(encounterDao.getEncounterId());
		encounter.setEncounterNumber(generateAdmiNumber(encounter.getInstId()));
		encounter.setStartDtTm(new Date());
		encounter.setCreateTs(new Date());
		encounter.setStatus('O');
		encounter.setTreatstart(encounter.getAssignDoctor()!=null?true:false);
		Encounter en= encountRepo.save(encounter);
			if(encounter.getAssignDoctor()!=null){
				Treatment tre=new Treatment();
				
				tre.setTreatmentId(encounterDao.getTreatmentId());
				tre.setInstId(encounter.getInstId());
				tre.setPatId(encounter.getPersonId());
				tre.setCreatedUId(encounter.getCreatedUId());
				tre.setCreateTs(new Date());
				tre.setEncounterId(en.getEncounterId());
				tre.setEncounterType(en.getEncounterType());
				tre.setEncounterStatus(en.getStatus());
				
				ProviderL proL=new ProviderL();
				proL.setProviderID(encounter.getAssignDoctor());
				tre.setProviderL(proL);
				tre.setProviderType("Doctor");
				
				tre.setProviderId(encounter.getAssignDoctor());
				tre.setAttendingPhysician('N');
				tre.setStatus('O');
				tre.setEncounter(encounter);
				treatRepo.save(tre);
			}	
			
		return en;
	}
	
	public Encounter findByEncounterIdAndInstId(Long instId,Long encounId){
		return encountRepo.findByEncounterIdAndInstId(encounId, instId);
	}
	
     public Encounter closeEncounter(Encounter encounter){
    	return  encountRepo.save(encounter);
	}
     public Encounter updateEncounter(Encounter encounter){
     	return  encountRepo.save(encounter);
 	}
	public Treatment saveTreatment(Treatment treatment,Long userId){
		Treatment tre=treatRepo.findByEncounterIdAndProviderIdAndInstId(treatment.getEncounterId(), treatment.getProviderId(), treatment.getInstId());
		if(tre==null){
			treatment.setCreatedUId(userId);
			treatment.setCreateTs(new Date());
		    treatment.setTreatmentId(encounterDao.getTreatmentId());
		    tre= treatRepo.save(treatment);
		}else {
			System.out.println("setProviderType===");
			tre.setProviderType("Doctor");	
		tre.setUpdateTs(new Date());
		tre.setUpdateUId(userId);
		tre.setAttendingPhysician('N');
		tre.setStatus('O');
		tre=treatRepo.save(tre);
		}
		
		return tre;
	}
	
	public Treatment closeTreatment(Long encounterId,Long instId,Long proId,Long userId){
		Treatment tre=treatRepo.findByEncounterIdAndProviderIdAndInstId(encounterId, proId, instId);
			if(tre!=null)
			{
				tre.setUpdateTs(new Date());
				tre.setUpdateUId(userId);
				tre.setStatus('C');
				treatRepo.save(tre);
			}
		return tre;
	}
	
	public Treatment findProviderTreatment(Long encounterId,Long instId,Long proId){
	return treatRepo.findByEncounterIdAndProviderIdAndInstIdAndStatus(encounterId, proId, instId, 'O');
	}
	
	public Treatment updateTreatment(Long encounterId,Long instId,Long proId,Long userId){
		Treatment tr=treatRepo.findByEncounterIdAndInstIdAndAttendingPhysician(encounterId, instId, 'Y');
		if(tr!=null){
			tr.setUpdateTs(new Date());
			tr.setUpdateUId(userId);
			tr.setAttendingPhysician('N');
			treatRepo.save(tr);
		}
		
		Treatment tre=treatRepo.findByEncounterIdAndProviderIdAndInstId(encounterId, proId, instId);
		if(tre!=null)
		{
			tre.setUpdateTs(new Date());
			tre.setUpdateUId(userId);
			tre.setAttendingPhysician('Y');
			treatRepo.save(tre);
		}
	return tre;
	}
	
	public Collection<Encounter> findInstActiveEncounters(Long instId){
		return encountRepo.findByInstIdAndStatus(instId,'O');
	}
	
	
	@Override
	public Collection<Treatment> findInstActiveOutPatientEncounters(Long instId){
		return treatRepo.findByInstIdAndEncounterTypeAndProviderTypeAndStatusOrderByEncounterId(instId,"OutPatient","Doctor", 'O');
	
	}
	
	@Override
	public Collection<Encounter> findInstActiveInPatientEncounters(Long instId,String encounterType,String ward){
		Collection<Encounter> inPatList=new ArrayList<Encounter>();
		System.out.println("instId"+instId+" encounterType"+encounterType+" "+ward);
		if(ward!=null && ward!="")
			inPatList=encountRepo.findByInstIdAndStatusAndEncounterTypeAndWard(instId,'O',encounterType,ward);
		else 
			inPatList=encountRepo.findByInstIdAndStatusAndEncounterType(instId,'O',encounterType);
	     //Collection<Treatment> nurseTreats=treatRepo.findByInstIdAndStatusAndProviderIdAndEncounterTypeOrderByEncounterId(instId, 'O',nurseId,"InPatient");
	
		System.out.println(ward+ " ward inPatList ward"+inPatList.size());	
		Collection<Long> encIdList=getEcounterIds(inPatList);
		if(encIdList!=null && encIdList.size()>0){
			//System.out.println(ward+ " ward inPatList ward"+inPatList.size());
		Collection<Treatment> doctTreats=treatRepo.findByEncounterIdInAndProviderTypeAndStatusOrderByEncounterId(encIdList,"Doctor",'O');
		System.out.println("doctTreats"+doctTreats.size());
	
	   Map<Long,Collection<Treatment>> treetMentMap=new HashMap<Long,Collection<Treatment>>();
	
		for(Treatment doctTre:doctTreats){
			Collection<Treatment> trList=new ArrayList<Treatment>();
			if(treetMentMap.get(doctTre.getEncounterId())!=null){
				treetMentMap.get(doctTre.getEncounterId()).add(doctTre);
			}else{
				trList.add(doctTre);
			 treetMentMap.put(doctTre.getEncounterId(), trList);
			}
		}
	
	
		for(Encounter encounter:inPatList){
			char attphy='N';
			ProviderL attendPhy=null;
			Collection<Treatment> doctTreets=treetMentMap.get(encounter.getEncounterId());
			Collection<String> docts;
			if(doctTreets!=null && doctTreets.size()>0){
				docts=new ArrayList<String>();
				for(Treatment treets: doctTreets){
					if(treets.getAttendingPhysician()=='Y'){
						System.out.println("in getAttendingPhysician");
						attphy='Y';
						attendPhy=treets.getProviderL();
					}else{
						docts.add(treets.getProviderL().getFirstname());
					}
				}
				
				encounter.setDocts(docts);
				encounter.setAttendingPhysician(attphy);
				encounter.setAttePhysiName(attendPhy);
				
				System.out.println("in getAttendingPhysician"+encounter.getAttendingPhysician());
			}
			
			
		}
	}
	return inPatList;
	}
	
	private Collection<Long> getEcounterIds(Collection<Encounter> nurseTreats){
		 Collection<Long> encoIds=new HashSet<Long> ();
		 for(Encounter tre:nurseTreats){
			 encoIds.add(tre.getEncounterId());
		 }
		 return encoIds;
	 }
	@Override
	public Map<String,Collection<ProviderL>> findAssignedNotAssignProviders(Long instId,String provType,Long encounterId){
		
	
		
		Map<String,Collection<ProviderL>> doctorsMap=new HashMap<String,Collection<ProviderL>>();
		
		
		Collection<ProviderInstitute> proInstList=proInstRepo.findByInstIdAndProvTypeAndStatus(instId, provType,true);
		
		Map<Long,ProviderL> doctorMap=new HashMap<Long,ProviderL>();
		for(ProviderInstitute p:proInstList){
			doctorMap.put(p.getProviderL().getProviderID(), p.getProviderL());
		}
		
		Collection<Long> doctIds=new ArrayList<Long>();
		Collection<ProviderL> doctList=new ArrayList<ProviderL>();
		for(ProviderInstitute proInst:proInstList)
			doctIds.add(proInst.getProvId());
		
		
		if(doctIds.size()==0) return null;
		System.out.println(encounterId+"==encounterId  and Inst Docts="+doctIds);
		Collection<Treatment> tredoctList=new ArrayList<Treatment>();
		if(doctIds.size()>0)
			tredoctList= treatRepo.findAllEncounterAssignedDoctors(encounterId,doctIds);
		
		
		Collection<ProviderL> treatdoctList=new ArrayList<ProviderL>();
		for(Treatment treat:tredoctList){
			ProviderL pl=doctorMap.get(treat.getProviderId());
			pl.setAttendingPhysician(treat.getAttendingPhysician());
			treatdoctList.add(pl);
			doctorMap.remove(treat.getProviderId());
		}
		doctList.clear();
		for(Long nurseId:doctorMap.keySet()){
			doctList.add(doctorMap.get(nurseId));
		}
		System.out.println("treat doct Size:"+treatdoctList.size());
		System.out.println("others doct Size:"+doctList.size());
		
		doctorsMap.put("treats", treatdoctList);
		doctorsMap.put("others", doctList);
		
		return doctorsMap;
	}
	
	
    static DateFormat formatter = new SimpleDateFormat("yyMMdd"); 
	public  String generateAdmiNumber(Long instId) 
	{ 
		String val = ""+((int)(Math.random()*9000)+1000);
		String encounterNumber=formatter.format(new Date())+val;
		Long EncounterId=encountRepo.findByInstIdAndEncounterNumber(instId, encounterNumber);
		System.out.println(EncounterId);
		if(EncounterId==null){
			System.out.println(encounterNumber);
			return encounterNumber;
		}
	    return generateAdmiNumber(instId);
	}
}
