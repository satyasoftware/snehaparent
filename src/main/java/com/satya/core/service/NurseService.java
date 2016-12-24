package com.satya.core.service;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.satya.core.bean.Drugs;
import com.satya.core.bean.MastLabTests;
import com.satya.core.bean.MedFrequency;
import com.satya.core.bean.SessionPatient;
import com.satya.core.dto.ConsultDto;
import com.satya.core.dto.IllnessDto;
import com.satya.core.dto.LabOrderDto;
import com.satya.core.dto.MedicalOrderDto;
import com.satya.core.dto.NotesDto;
import com.satya.core.dto.OtherOrdersDto;
import com.satya.core.dto.VitalsDto;
import com.satya.core.jsonresponse.TreatmentResponse;

public interface NurseService {
public Collection<NotesDto> saveNotes(NotesDto note,boolean need);
//public Collection<Notes> findNotes(Long encounterId);
public Collection<NotesDto> findEncounterNotes(Long encounterId);
public Collection<NotesDto> closeStickyNote(Long noteId,Long encounterId,Long userId);
public NotesDto findNotes(Long noteId);

public Collection<VitalsDto> saveVitals(VitalsDto vital,boolean need);
//public List<Vitals> findVitals(Long encounterId);
public List<VitalsDto> findEncounterVitals(Long encounterId);
public VitalsDto findVital(Long vitalId);

//public Collection<MedicalOrder> findMedication(Long encounterId);
public Collection<MedicalOrderDto> saveMedication(MedicalOrderDto medication,boolean need);
public Collection<MedicalOrderDto> findEncounterMedication(Long encounterId);
MedicalOrderDto findMedicalorder(Long medicationId);

public Collection<LabOrderDto> saveLaborder(LabOrderDto laborder,boolean need);
//public Collection<LabOrder> findLaborder(Long encounterId);
public Collection<LabOrderDto> findEncounterLaborders(Long encounterId);
public LabOrderDto findLabOrder(Long laborderId);

public List<MastLabTests> findByTestNameLikeIgnoringCase(String testname);
public SessionPatient getPatientInfo(Long encounterId,Long instId);
public Collection<String> getNoteTypes();

public Collection<ConsultDto> saveConsult(ConsultDto laborder,boolean need);
public Collection<ConsultDto> findEncounterConsults(Long encounterId);
public ConsultDto findConsult(Long consultId);

public Collection<OtherOrdersDto> saveOtherOrder(OtherOrdersDto laborder,boolean need);
public Collection<OtherOrdersDto> findEncounterOtherOrders(Long encounterId);
public OtherOrdersDto findOtherOrder(Long othorderId);

public Collection<IllnessDto> saveIllness(IllnessDto laborder);
public Collection<IllnessDto> findEncounterIllness(Long encounterId);
public IllnessDto findIllness(Long illnessId);

 public Map<Long,String> findByDiseaseNameLikeIgnoringCase(String diseasename);
 public Page<Drugs> finddrugName(String drugname);
 public TreatmentResponse getDrugs(String drugname);
 
 public List<MedFrequency> getFreList();
 public List<String> getDurUnitList();
}
