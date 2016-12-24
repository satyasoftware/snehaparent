package com.satya.core.service;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.satya.core.bean.Institution;
import com.satya.core.bean.Provider;
import com.satya.core.bean.ProviderInstitute;
import com.satya.core.dto.ProviderDto;

public interface InstitutionService {
	
	public List<Institution> findByProvIdAndProvType(Long proId,String provType);
	
	public Institution saveInstitution(Institution inst);
	
	public Collection<ProviderInstitute> getAllProviderInstitutions(Long proId);
	
	public Institution findInstitution(Long instId);
	
	public List<Provider> searchForProvider(String name);
	
	public List<Provider> searchForProviderByReg(String regNo);
	
	public ProviderInstitute findForExistance(Long provId,Long instId,String provType);
	
	public ProviderInstitute saveProviderInstitute(ProviderInstitute proInst);
	
	public Collection<Provider> findByInstIdAndProvType(Long instId,String provType);
	
	public ProviderInstitute findProviderInstitute(Long provInstId);
	
	public Collection<ProviderInstitute> findProviderInstitutes(Long provId);
	
	public Institution updateInstitution(Institution institution,Boolean isaddress);
	
	//public ProviderInstitute findProviderInstituteAndInst(Long provInstId);
	
	public  Collection<Provider> findByInstId(Long instId);
	
	public List<Institution> searchForInstitution(String instname,String appointFor);
	
	public Page<Institution> searchForInstitution(String instName,String zip,String address1,String province,String city,int pageno,int limit);
	
	public Map<String,Collection<Provider>> findDoctorMapNurses(Long instId,Long doctId,String provType);
	
	public void saveDoctNurseAssociation(Long instId,Long doctId,String nurseIds,Long userId);
	
	public void removeDoctNurseAssociation(Long instId,Long doctId,String nurseIds,Long userId);
	
	public Institution addDepartment(Long instId,String deptName);
	
	public Institution updateDepartment(Long instId,String deptName,String status);
	
	public Institution addWard(Long instId,String wardName);
	
	public Institution updateWard(Long instId,String wardName,String status);
	
	public Collection<ProviderInstitute> getAllInstProvider(Long instId);
	
	public Collection<Long> findByInstIdAndNurseId(Long instId,Long nurseId);
	
	public Collection<ProviderDto> findByInstIdAndOtherthanDoctors(Long instId);
}
