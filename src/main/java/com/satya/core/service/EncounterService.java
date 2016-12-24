package com.satya.core.service;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.satya.core.bean.Encounter;
import com.satya.core.bean.Treatment;
import com.satya.core.beanLimit.ProviderL;

public interface EncounterService {
	public Encounter saveEncounter(Encounter encounter);
	public Encounter saveEmrgeEncounter(Encounter encounter);
	public Encounter findEncounter(Long encounterId);
	public Encounter closeEncounter(Encounter encounter);
	public Encounter updateEncounter(Encounter encounter);
	public List<Encounter> getInstEncounters(Long instId);
	public Page<Encounter> getInstActive20Encounters(Long instId,int pageno);
	public Collection<Encounter> findInstActiveEncounters(Long instId);
	
	public Collection<Encounter>  getInstActiveEncounters(Long instId);
	public Page<Encounter>  getInstActiveWardEncounters(Long instId,String ward,String encountType,int pageno);
	
	public Map<String,Collection<ProviderL>> findAssignedNotAssignProviders(Long instId,String provType,Long encounId);
	public Encounter findByEncounterIdAndInstId(Long instId,Long encounId);
	public Treatment saveTreatment(Treatment treatment,Long userId);
	
	public Treatment closeTreatment(Long encounterId,Long instId,Long proId,Long userId);
	public Treatment updateTreatment(Long encounterId,Long instId,Long proId,Long userId);
	public Treatment findProviderTreatment(Long encounterId,Long instId,Long proId);
	public Collection<Treatment> findInstActiveOutPatientEncounters(Long instId);
	
	public Collection<Encounter>findInstActiveInPatientEncounters(Long instId,String encounterType,String ward);

}
