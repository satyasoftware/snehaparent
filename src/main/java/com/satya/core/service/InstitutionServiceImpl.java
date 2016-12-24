package com.satya.core.service;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.satya.core.bean.Department;
import com.satya.core.bean.DoctorNurseMap;
import com.satya.core.bean.Institution;
import com.satya.core.bean.PerSeqId;
import com.satya.core.bean.Provider;
import com.satya.core.bean.ProviderInstitute;
import com.satya.core.bean.Ward;
import com.satya.core.dao.ProviderDao;
import com.satya.core.dto.ProviderDto;
import com.satya.core.enums.StatusEnum;
import com.satya.core.repo.DoctorNurseMapRepo;
import com.satya.core.repo.InstitutionRepo;
import com.satya.core.repo.PersonSeqRepo;
import com.satya.core.repo.ProviderInstitutionRepo;

@Service("institutionService")
//@Transactional(readOnly = true)
public class InstitutionServiceImpl implements InstitutionService {
    
	@Autowired 	private InstitutionRepo institutionRepo;
	@Autowired 	private PersonSeqRepo personSeqRepo;
	@Autowired	private ProviderInstitutionRepo proInstRepo;
	@Autowired	private ProviderDao providerDao;
	@Autowired	private DoctorNurseMapRepo doctNurseRepo;
	
	
	@Override
	public List<Provider> searchForProvider(String name){
		return providerDao.searchForProvider(name);
		
	}

	@Override
	public Collection<ProviderInstitute> getAllInstProvider(Long instId){
		return proInstRepo.findByInstId(instId);
		
	}
	
	@Override
		public Collection<Provider> findByInstId(Long instId) {
		Collection<ProviderInstitute> proInstList=proInstRepo.findByInstId(instId);
		Collection<Long> proIds=new HashSet<Long>();
		Collection<Provider> instProviders=new ArrayList<Provider>();
		for(ProviderInstitute proInst:proInstList)
			proIds.add(proInst.getProvId());
		if(proIds.size()>0){
			 instProviders= providerDao.getInstProviders(proIds);
		}
		Collection<Provider> retProviders=new ArrayList<Provider>();
		for(Provider prov:instProviders){
			retProviders.add(new Provider(prov.getProviderID(),prov.getFirstname()+", "+prov.getLastname()+" # "+prov.getRegNo()));
		}
		return retProviders;
	}
	
	@Override
	public List<Institution> searchForInstitution(String instname,String appointFor){
		String instType="";
		if(appointFor!=null){
			if(appointFor.equals("Doctor") || appointFor.equals("Blood Sample") ){
				instType="Hospital";
				//Pharmacy, , Lab
			}else if(appointFor.equals("Lab Work")){
				instType="Laboratory";
			}
		}
		return providerDao.searchForInstitution(instname,instType);
		
	}
	
	public Page<Institution> searchForInstitution(String instName,String zip,String address1,String province,String city,int pageno,int limit){
		Page<Institution> pageList=null;
		if(instName!=null && instName !="" && zip!=null && zip !="" && zip.length()>2) {
			System.out.println("Name zip");
			pageList= institutionRepo.findByInstNameLikeIgnoringCaseAndZip(instName, zip, new PageRequest(pageno,limit));
		}
		else if(instName!=null && instName !="" && address1!="" && address1!=null && province!="" && province!=null && city !=null){ 
			System.out.println("Name address1 province city");
			pageList =institutionRepo.findByInstNameLikeIgnoringCaseAndAddress1IgnoringCaseAndProvinceAndCity(instName, address1, province, city,new PageRequest(pageno,limit));
		}
			else if(instName!=null && instName !="" && province!="" && province!=null && city !=null) {
				System.out.println("Name  province city");
				pageList= institutionRepo.findByInstNameLikeIgnoringCaseAndAddress1IgnoringCaseAndProvinceAndCity(instName, address1, province, city, new PageRequest(pageno,limit));//(instName, address1, province,city,new PageRequest(pageno,limit));
			}
		return pageList;
	}
	
	@Override
	public Collection<ProviderInstitute> findProviderInstitutes(Long provId){
		Collection<ProviderInstitute> proInstList= proInstRepo.findByProvIdOrderByInstId(provId);
		
		System.out.println(" Insti Roles List"+proInstList.size());
		//for(ProviderInstitute proInst:proInstList){
			//System.out.println(" INST Name="+proInst.getInstId());
			//if(!proInst.getProvType().equalsIgnoreCase("Admin"))proInst.setInstitution(institutionRepo.findByInstId(proInst.getInstId()));
		//}
	 return proInstList;
	}
	
	@Override
	public List<Provider> searchForProviderByReg(String regNo){
		return providerDao.searchForProviderByReg(regNo);
	}
	
	@Override
	public Collection<Provider> findByInstIdAndProvType(Long instId,String provType){
		//List<Provider> proList=new ArrayList<Provider>();
		Collection<ProviderInstitute> proInstList=proInstRepo.findByInstIdAndProvTypeAndStatus(instId, provType,true);
		Collection<Long> proIds=new ArrayList<Long>();
		
		for(ProviderInstitute proInst:proInstList)
			proIds.add(proInst.getProvId());
		if(proIds.size()>0)
			return providerDao.getInstProviders(proIds);
		else return null;
	}
	@Override
	public Collection<ProviderDto> findByInstIdAndOtherthanDoctors(Long instId){
		//List<Provider> proList=new ArrayList<Provider>();
		Collection<ProviderInstitute> proInstList=proInstRepo.findByInstIdAndProvTypeNotAndStatus(instId, "Doctor",true);
		System.out.println("not doct list size="+proInstList);
		ProviderDto pro=null;
		Collection<ProviderDto> provi=new ArrayList<ProviderDto>();
		for(ProviderInstitute proInst:proInstList){
			pro=new ProviderDto();
			pro.setProviderID(proInst.getProviderL().getProviderID());
			pro.setFirstname(proInst.getProviderL().getFirstname()+","+proInst.getProviderL().getLastname());
			provi.add(pro);
		}
		return provi;
	}
	
	
	@Override
	public void saveDoctNurseAssociation(Long instId,Long doctId,String nurseIds,Long userId){
		StringTokenizer str=new StringTokenizer(nurseIds, ",");
		while(str.hasMoreTokens()){ 
			Long nurseId= Long.parseLong(str.nextToken().replace("\"", ""));
			DoctorNurseMap doctnurse=doctNurseRepo.findByInstIdAndDoctorIdAndNurseId(instId, doctId,nurseId);
			if(doctnurse!=null && doctnurse.getMapId()!=null){
			doctnurse.setStatus("A");
			doctnurse.setUpdateduserId(userId);
			doctnurse.setUpdateddate(new Date());
			doctNurseRepo.save(doctnurse);
			}
			else{
				doctnurse=new DoctorNurseMap();
				//BigInteger maxid=providerDao.getMaxDoctNurseMapId();
				//System.out.println("maxid=="+maxid);
				
				//doctnurse.setMapId(maxid);
				doctnurse=new DoctorNurseMap();
				doctnurse.setDoctorId(doctId);
				doctnurse.setInstId(instId);
				doctnurse.setNurseId(nurseId);
				doctnurse.setStatus("A");
				doctnurse.setCreatedUserId(userId);
				doctnurse.setRegisterdate(new Date());
				doctNurseRepo.save(doctnurse);
			}
		} 
	}
	@Override
	public void removeDoctNurseAssociation(Long instId,Long doctId,String nurseIds,Long userId){
		StringTokenizer str=new StringTokenizer(nurseIds, ",");
		while(str.hasMoreTokens()){ 
			Long nurseId= Long.parseLong(str.nextToken());
			DoctorNurseMap doctnurse=doctNurseRepo.findByInstIdAndDoctorIdAndNurseId(instId, doctId,nurseId);
			if(doctnurse!=null && doctnurse.getMapId()!=null){
			doctnurse.setStatus("I");
			doctnurse.setUpdateduserId(userId);
			doctnurse.setUpdateddate(new Date());
			doctNurseRepo.save(doctnurse);
			}
		} 
	}
	
	@Override
	public Institution addWard(Long instId,String wardName){
		Institution inst=institutionRepo.findByInstId(instId);
		Collection<Ward> wardList=new HashSet<Ward>();
		if(inst.getWards()!=null)wardList=inst.getWards();
		wardName=wardName.toUpperCase();
		Ward dept=new Ward(wardName.toUpperCase(),StatusEnum.A.toString());
		if(wardList.add(dept)){
		inst.setWards(wardList);
		inst=institutionRepo.save(inst);
		System.out.println("ward Added");
		inst.setDeptAddStatus(true);
		}else inst.setDeptAddStatus(false);
		return inst;
	} 
	
	@Override
	public Institution updateWard(Long instId,String wardName,String status){
		Institution inst=institutionRepo.findByInstId(instId);
		Collection<Ward> wardList=new ArrayList<Ward>();
		wardList=inst.getWards();
		for(Ward dep:wardList){
			if(dep.getWardName().equalsIgnoreCase(wardName)){
				dep.setStatus(StatusEnum.valueOf(status).toString());
				System.out.println("wardName change status  ="+wardName);
				///depList.remove(dep);
				break;
			}
		}
		inst.setWards(wardList);
		inst=institutionRepo.save(inst);
		return inst;
	} 
	
	@Override
	public Institution addDepartment(Long instId,String deptName){
		Institution inst=institutionRepo.findByInstId(instId);
		Collection<Department> depList=new TreeSet<Department>();
		depList=inst.getDepartments();
		deptName=deptName.toUpperCase();
		Department dept=new Department(deptName.toUpperCase(),StatusEnum.A.toString());
		if(depList.add(dept)){
		inst.setDepartments(depList);
		inst=institutionRepo.save(inst);
		System.out.println("dept Added");
		inst.setDeptAddStatus(true);
		}else inst.setDeptAddStatus(false);
		return inst;
	} 
	
	@Override
	public Institution updateDepartment(Long instId,String deptName,String status){
		Institution inst=institutionRepo.findByInstId(instId);
		Collection<Department> depList=new ArrayList<Department>();
		depList=inst.getDepartments();
		for(Department dep:depList){
			if(dep.getDepName().equalsIgnoreCase(deptName)){
				dep.setStatus(StatusEnum.valueOf(status).toString());
				System.out.println("deptName change status  ="+deptName);
				///depList.remove(dep);
				break;
			}
		}
		inst.setDepartments(depList);
		inst=institutionRepo.save(inst);
		return inst;
	} 
	
	@Override
	public Map<String,Collection<Provider>> findDoctorMapNurses(Long instId,Long doctId,String provType){
		
		Map<String,Collection<Provider>> nursesMap=new HashMap<String,Collection<Provider>>();
		
		
		Collection<ProviderInstitute> proInstList=proInstRepo.findByInstIdAndProvTypeAndStatus(instId, provType,true);
		
		Collection<Long> proIds=new ArrayList<Long>();
		for(ProviderInstitute proInst:proInstList)
			proIds.add(proInst.getProvId());
		
		if(proIds.size()==0) return null;
		Collection<Provider> nurseList=new ArrayList<Provider>();
		if(proIds.size()>0)
			 nurseList= providerDao.getInstProviders(proIds);
		
		
		Map<Long,Provider> nurseMap=new HashMap<Long,Provider>();
		for(Provider p:nurseList){
			nurseMap.put(p.getProviderID(), p);
		}
		
		Collection<Provider> doctAssoNurseList=new ArrayList<Provider>();
		
		Collection<DoctorNurseMap> doctAssNurseList=doctNurseRepo.findByInstIdAndDoctorIdAndStatus(instId, doctId,"A");
		
		for(DoctorNurseMap nurse:doctAssNurseList){
			doctAssoNurseList.add(nurseMap.get(nurse.getNurseId()));
			nurseMap.remove(nurse.getNurseId());
		}
		nurseList.clear();
		for(Long nurseId:nurseMap.keySet()){
			nurseList.add(nurseMap.get(nurseId));
		}
		
		
		nursesMap.put("Association", doctAssoNurseList);
		nursesMap.put("NotAssociation", nurseList);
		
		return nursesMap;
	}
	
	
	
	@Override
	public ProviderInstitute findForExistance(Long provId,Long instId,String provType){
		return proInstRepo.findByProvIdAndInstIdAndProvType(provId, instId,provType);
			
	}
	
	@Override
	public ProviderInstitute findProviderInstitute(Long provInstId){
		System.out.println("provInstId="+provInstId);
		return proInstRepo.findByProvInstId(provInstId);
			
	}
	
	@Override
	public Collection<Long> findByInstIdAndNurseId(Long instId,Long nurseId){
	return getDoctIds(doctNurseRepo.findByInstIdAndNurseId(instId, nurseId));
	
	}
	
	private Collection<Long> getDoctIds(Collection<DoctorNurseMap> instProviders){
		Collection<Long> doctList=new HashSet<Long>();
		for(DoctorNurseMap proInst:instProviders){
			doctList.add(proInst.getDoctorId());
		}
		return doctList;
	}
	
	/*@Override
	public ProviderInstitute findProviderInstituteAndInst(Long provInstId){
		System.out.println("provInstId="+provInstId);
		
		ProviderInstitute proInst= proInstRepo.findByProvInstId(provInstId);
	    //proInst.setInstitution(institutionRepo.findByInstId(proInst.getInstId()));
	    return proInst;
	}*/
	@Override
	public ProviderInstitute saveProviderInstitute(ProviderInstitute proInst){
		if(proInst.getProvInstId()==null ||proInst.getProvInstId()==0)
		proInst.setProvInstId(getProvInstseqId());
		return proInstRepo.save(proInst);
	}
	
	@Override
	public Institution updateInstitution(Institution institution,Boolean isaddress){
 
	institution.setUpdatedDate(new Date());
	institution.setUpdateduserId(institution.getProviderId());
	Institution p=institutionRepo.save(institution);
	return p;
}
	
	
	@Override
	public Institution saveInstitution(Institution inst){
		PerSeqId seqence=getAddressSequenceId();
		System.out.println("add Id="+seqence.getAddressseq()+" proInstId="+seqence.getProvInstseq()+" inst Id="+seqence.getInstitutionseq());
		//Address address=inst.getAddress();
		//address.setId(seqence.getAddressseq());
		//address.setAddressEntity("institution");
		//address.setStatus(true);
		//address.setCreateddate(new Date());
		//List<Long> addresses=new ArrayList<Long>();
		//addresses.add(address.getId());
		//inst.setAddresses(addresses);
		inst.setInstId(seqence.getInstitutionseq());
		//address.setCreatedUserId(inst.getProviderId());
		
		//addressRepo.save(address);
		List<Department> departments=new ArrayList<Department>();
		inst.setDepartments(departments);
		Institution institution=institutionRepo.save(inst);
		ProviderInstitute proInst=new ProviderInstitute();
		proInst.setProvInstId(seqence.getProvInstseq());
		proInst.setProvId(inst.getProviderId());
		proInst.setInstId(inst.getInstId());
		//proInst.setAdminYN(true);
		proInst.setProvType("Admin");
		proInst.setStartDate(inst.getStartDate());
		proInst.setStatus(false);
		proInst.setCreatedDate(new Date());
		proInst.setCreatedUserId(inst.getProviderId());
		proInstRepo.save(proInst);
		return institution;
	}
	@Override
	public Institution findInstitution(Long instId){
		Institution inst=institutionRepo.findByInstId(instId);
		//List<Long> address=inst.getAddresses();
		//Address add=new Address();
		//if(address!=null)
			// add=addressRepo.findById(address.get(address.size()-1));
		//inst.setAddress(add);
		inst.setStartday(formatDate(inst.getStartDate()));
		//inst.setRegday(formatDate(inst.getRegDate()));
		return inst;
	}
	
	private String formatDate(Date date){
			SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");
	       return  DATE_FORMAT.format(date);
	}
	
		
	@Override
	public List<Institution> findByProvIdAndProvType(Long proId,String provType){
		List<Institution> instList=new ArrayList<Institution>();
		Collection<ProviderInstitute> provinst=proInstRepo.findByProvIdAndProvType(proId,provType);
		Set<Long> instSet=new HashSet<Long>();
		for(ProviderInstitute inst:provinst)
			if(instSet.add(inst.getInstId()))instList.add(institutionRepo.findByInstId(inst.getInstId()));
		
		return instList;
	}
	
	@Override
public Collection<ProviderInstitute> getAllProviderInstitutions(Long proId){
	//List<Institution> instList=new ArrayList<Institution>();
	Collection<ProviderInstitute> provinst=proInstRepo.findByProvIdAndProvType(proId,"Admin");
	//Set<Long> instSet=new HashSet<Long>();
	//for(ProviderInstitute inst:provinst)
		//instList.add(inst.g);
	
	return provinst;
}

	public long getonlyAddressSequenceId() {
	   	PerSeqId seq=new PerSeqId();
	   	List<PerSeqId> seqList = personSeqRepo.findAll();
	   	if(seqList==null || CollectionUtils.isEmpty(seqList) ){
	   		seq.setAddressseq(1L);
	   	}else{
	   		seq=seqList.get(0);
	   		seq.setAddressseq(seq.getAddressseq()+1);
	   		}
	   	personSeqRepo.save(seq);
	   	System.out.println("seqid==="+seq.getAddressseq());
	   	return seq.getAddressseq();

	     }	
public Long getProvInstseqId() {
    	
	PerSeqId seq=new PerSeqId();
   	List<PerSeqId> seqList = personSeqRepo.findAll();
   	if(seqList==null || CollectionUtils.isEmpty(seqList) ){
   		seq.setProvInstseq(1L);
   	}else{
   		seq=seqList.get(0);
   		seq.setProvInstseq(seq.getProvInstseq()+1);
   		}
   	personSeqRepo.save(seq);
   	System.out.println("seqid==="+seq.getProvInstseq());
   	return seq.getProvInstseq();

     }
	public PerSeqId getAddressSequenceId() {
    	
    	PerSeqId seq=new PerSeqId();
    	List<PerSeqId> seqList = personSeqRepo.findAll();
    	if(seqList==null || CollectionUtils.isEmpty(seqList) ){
    		//seq.setAddressseq(seq.getAddressseq()==null?1L:seq.getAddressseq()+1);
    		seq.setInstitutionseq(seq.getInstitutionseq()==null?1L:seq.getInstitutionseq()+1);
    		seq.setProvInstseq(seq.getProvInstseq()==null?1L:seq.getProvInstseq()+1);
    	}else{
    		seq=seqList.get(0);
    		//seq.setAddressseq(seq.getAddressseq()==null?1L:seq.getAddressseq()+1);
    		seq.setInstitutionseq(seq.getInstitutionseq()==null?1L:seq.getInstitutionseq()+1);
    		seq.setProvInstseq(seq.getProvInstseq()==null?1L:seq.getProvInstseq()+1);
    		}
    	personSeqRepo.save(seq);
    	System.out.println("seqid==="+seq.getAddressseq());
    	return seq;

      }	

}
