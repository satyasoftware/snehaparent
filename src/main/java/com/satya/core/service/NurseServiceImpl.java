package com.satya.core.service;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.satya.core.bean.CodeTable;
import com.satya.core.bean.Consult;
import com.satya.core.bean.Diseases;
import com.satya.core.bean.Drugs;
import com.satya.core.bean.Encounter;
import com.satya.core.bean.Illness;
import com.satya.core.bean.LabOrder;
import com.satya.core.bean.MastLabTests;
import com.satya.core.bean.MedFrequency;
import com.satya.core.bean.MedicalOrder;
import com.satya.core.bean.Notes;
import com.satya.core.bean.OtherOrders;
import com.satya.core.bean.SessionPatient;
import com.satya.core.bean.Vitals;
import com.satya.core.beanLimit.DrugsL;
import com.satya.core.beanLimit.ProviderL;
import com.satya.core.dto.ConsultDto;
import com.satya.core.dto.IllnessDto;
import com.satya.core.dto.LabOrderDto;
import com.satya.core.dto.MedicalOrderDto;
import com.satya.core.dto.NotesComparator;
import com.satya.core.dto.NotesDto;
import com.satya.core.dto.OtherOrdersDto;
import com.satya.core.dto.VitalsDto;
import com.satya.core.enums.OrderTypesEnum;
import com.satya.core.jsonresponse.TreatmentResponse;
import com.satya.core.repo.ConsultRepo;
import com.satya.core.repo.DiseasesRepo;
import com.satya.core.repo.DrugsRepo;
import com.satya.core.repo.EncounterRepo;
import com.satya.core.repo.IllnessRepo;
import com.satya.core.repo.LabOrderRepo;
import com.satya.core.repo.MastLabTestsRepo;
import com.satya.core.repo.MedicationRepo;
import com.satya.core.repo.NotesRepo;
import com.satya.core.repo.OtherOrdersRepo;
import com.satya.core.repo.VitalsRepo;

@Service("nurseService")
//@Transactional(readOnly = true)
public class NurseServiceImpl implements NurseService {
	
	@Autowired	private NotesRepo notesRepo; 
	@Autowired	private MongoTemplate mongoTemplate;	
	@Autowired	private VitalsRepo vitalsRepo;
	@Autowired	private MedicationRepo medicationRepo;
	@Autowired	private LabOrderRepo labOrderRepo;
	@Autowired	private EncounterRepo enconterRepo;
	@Autowired	private MastLabTestsRepo mastLabTestsRepo; 
	@Autowired	private ConsultRepo consultRepo;
	@Autowired	private OtherOrdersRepo othordersRepo;
	//@Autowired	private TreatmentDao treatmentDao;
	@Autowired	private IllnessRepo illnessRepo;
	@Autowired	private DiseasesRepo diseasesRepo;
	@Autowired	private DrugsRepo drugsRepo;
	public SessionPatient getPatientInfo(Long encounterId,Long instId){
		Encounter encou=enconterRepo.findByEncounterIdAndInstId(encounterId,instId);
		SessionPatient pat=null;
		if(encou!=null){
			pat=new SessionPatient();
			pat.setPatname(encou.getPersonL().getFirstname()+", "+encou.getPersonL().getLastname());
			pat.setPatDob(encou.getPersonL().getBirthday());
			pat.setEncoDate(encou.getEndDtTm());
			pat.setWard(encou.getWard());
			pat.setBlock(encou.getBlock());
			pat.setBedno(encou.getBedno());
			pat.setGender(encou.getPersonL().getGender());
			pat.setAdmissionNo(encou.getAdmissionNo());
			pat.setEncounterNumber(encou.getEncounterNumber());
			pat.setAge(getAge(encou.getPersonL().getBirthday()));
		}
		return pat;
	}
	
		private int getAge(Date dateOfBirth) {
		    int age = 0;
		    Calendar born = Calendar.getInstance();
		    Calendar now = Calendar.getInstance();
		    if(dateOfBirth!= null) {
		        now.setTime(new Date());
		        born.setTime(dateOfBirth);  
		        if(born.after(now)) {
		            throw new IllegalArgumentException("Can't be born in the future");
		        }
		        age = now.get(Calendar.YEAR) - born.get(Calendar.YEAR);             
		        if(now.get(Calendar.DAY_OF_YEAR) < born.get(Calendar.DAY_OF_YEAR))  {
		            age-=1;
		        }
		    }  
		    return age;
		}
		
		public Collection<NotesDto> closeStickyNote(Long noteId,Long enconId,Long userId){
			Notes n=notesRepo.findByEncounterIdAndNotesId(enconId, noteId);
			if(n!=null){
				n.setStickystatus("D");
				n.setUpdateTs(new Date());
				n.setUpdateUId(userId);
				notesRepo.save(n);}
			//Collection<Notes>  notesList=treatmentDao.getEncounterNotes(enconId);
			List<Notes> notesList= notesRepo.findTop10ByEncounterIdAndStickystatusNotOrderByNotesIdDesc(enconId,"D");
			System.out.println("notesList=="+notesList.size());
			Collections.sort(notesList, new NotesComparator());
			return convertNotesToNotesDto(notesList);
		}
		public Collection<NotesDto> saveNotes(NotesDto notes,boolean need){
			Notes note=new Notes();
			if(notes.getNotesId()!=null && notes.getNotesId()>0){
				    note=notesRepo.findOne(notes.getNotesId());
					note.setDoctNoteType(notes.getDoctNoteType());
					note.setDoctorNote(notes.getDoctorNote());
					notesRepo.save(note);
			   }
			else{
					note.setNotesId(getMaxNotesId());
					note.setEncounterId(notes.getEncounterId());
					note.setDoctNoteType(notes.getDoctNoteType());
					note.setDoctorNote(notes.getDoctorNote());
					ProviderL proL=new ProviderL();
					proL.setProviderID(notes.getProviderId());
					note.setProviderL(proL);
					note.setCreatedUId(notes.getProviderId());
					note.setCreateTs(new Date());
					note.setProvType(notes.getProvType());
					note.setStickystatus(notes.getStickystatus());
					System.out.println("note Id=="+note.getNotesId());
					notesRepo.save(note);
			}
				if(!need) return null;
				List<Notes> notesList= notesRepo.findTop10ByEncounterIdAndStickystatusNotOrderByNotesIdDesc(note.getEncounterId(),"D");
				System.out.println("notesList=="+notesList.size());
				Collections.sort(notesList, new NotesComparator());
			return convertNotesToNotesDto(notesList);
		  }
		public NotesDto findNotes(Long notesId){
			Notes notes=notesRepo.findOne(notesId);
			if(notes==null)return null;
			NotesDto note=new NotesDto();
			note.setNotesId(notesId);
			note.setEncounterId(notes.getEncounterId());
			note.setDoctNoteType(notes.getDoctNoteType());
			note.setDoctorNote(notes.getDoctorNote());
			note.setCreatedUId(notes.getProviderL().getProviderID());
			note.setCreateTs(notes.getCreateTs());
			notes.setCreatedUId(notes.getCreatedUId());
			note.setProvType(notes.getProvType());
			return note;
		}
		public Collection<VitalsDto> saveVitals(VitalsDto vitald,boolean need){ 
			Vitals vital=new Vitals();
			if(vitald.getVitalId()!=null && vitald.getVitalId()>0){
				
			}
			vital.setVitalId(getMaxVitalId());
			ProviderL proL=new ProviderL();
			proL.setProviderID(vitald.getProviderId());
			vital.setProviderL(proL);
			vital.setCreatedUId(vitald.getProviderId());
			vital.setCreateTs(new Date());
			vital.setTemperature(vitald.getTemperature());
			vital.setChest(vitald.getChest());
			vital.setDescription(vitald.getDescription());
			vital.setDiastolicBp(vitald.getDiastolicBp());
			vital.setEncounterId(vitald.getEncounterId());
			vital.setHeight(vitald.getHeight());
			vital.setPulseOximetry(vitald.getPulseOximetry());
			vital.setPulserate(vitald.getPulserate());
			vital.setSystolicBp(vitald.getSystolicBp());
			vital.setWeight(vitald.getWeight());
			vital.setProvType(vitald.getProvType());
			vitalsRepo.save(vital);
			List<Vitals>  vitals= vitalsRepo.findTop6ByEncounterIdOrderByCreateTsDesc(vital.getEncounterId());
			return convertVitalsToVitalsDto(vitals);
		}
		public VitalsDto findVital(Long vitalId){
			Vitals vitald=vitalsRepo.findOne(vitalId);
			VitalsDto vital=new VitalsDto();
			vital.setCreateTs(vitald.getCreateTs());
			vital.setTemperature(vitald.getTemperature());
			vital.setChest(vitald.getChest());
			vital.setDescription(vitald.getDescription());
			vital.setDiastolicBp(vitald.getDiastolicBp());
			vital.setEncounterId(vitald.getEncounterId());
			vital.setHeight(vitald.getHeight());
			vital.setPulseOximetry(vitald.getPulseOximetry());
			vital.setPulserate(vitald.getPulserate());
			vital.setSystolicBp(vitald.getSystolicBp());
			vital.setWeight(vitald.getWeight());
			vital.setCreatedUId(vitald.getCreatedUId());
			return vital;
		}
		/*public Collection<Notes> findNotes(Long encounterId){
			//return notesRepo.findAll();
			return notesRepo.findTop10ByEncounterIdOrderByNotesIdDesc(encounterId);
		}*/
		public Collection<NotesDto> findEncounterNotes(Long encounterId){
			List<Notes> notesList= notesRepo.findTop10ByEncounterIdAndStickystatusNotOrderByNotesIdDesc(encounterId,"D");
			System.out.println("notesList=="+notesList.size());
			Collections.sort(notesList, new NotesComparator());
			return convertNotesToNotesDto(notesList);
		}
		private Collection<NotesDto> convertNotesToNotesDto(Collection<Notes> notesList){
			NotesDto note;
			List<NotesDto> notes=new ArrayList<NotesDto>();
			for(Notes s:notesList){
				note=new NotesDto();
				note.setEncounterId(s.getEncounterId());
				note.setNotesId(s.getNotesId());
				note.setDoctNoteType(s.getDoctNoteType());
				note.setDoctorNote(s.getDoctorNote());
				note.setCreateTs(s.getCreateTs());
				note.setCreateduser(s.getProviderL().getFirstname()+","+s.getProviderL().getLastname()+"-"+s.getProvType());
				System.out.println("notes dto size"+s.getDoctorNote().length());
				note.setShortnote(s.getDoctorNote().length()>50?s.getDoctorNote().substring(0, 48)+".." :s.getDoctorNote() );
				notes.add(note);
			}
			//Collections.sort(notes, new NotesComparator());
			return notes;
		} 
		
		public Collection<String> getNoteTypes(){
		CodeTable codes=CodeTable.getInstance();
		System.out.println("getNoteType=="+codes.getNoteType().size());
		return codes.getNoteType();
		}
		
		public List<VitalsDto> findEncounterVitals(Long encounterId){
			List<Vitals>  vitals= vitalsRepo.findTop6ByEncounterIdOrderByCreateTsDesc(encounterId);
			return convertVitalsToVitalsDto(vitals);
		}
		private List<VitalsDto> convertVitalsToVitalsDto(List<Vitals>  vitals){
			List<VitalsDto> vitalList=new ArrayList<VitalsDto>();
			VitalsDto vital;
			for(Vitals v:vitals){
				vital=new VitalsDto();
				vital.setVitalId(v.getVitalId());
				vital.setChest(v.getChest());
				vital.setDescription(v.getDescription());
				vital.setDiastolicBp(v.getDiastolicBp());
				vital.setHeight(v.getHeight());
				vital.setPulseOximetry(v.getPulseOximetry());
				vital.setPulserate(v.getPulserate());
				vital.setSystolicBp(v.getSystolicBp());
				vital.setTemperature(v.getTemperature());
				vital.setWeight(v.getWeight());
				if(v.getDiastolicBp()!=null && v.getSystolicBp()!=null)
				vital.setBp(v.getDiastolicBp()+"/"+v.getSystolicBp());
				vital.setCreateTs(v.getCreateTs());
				vitalList.add(vital);
			}
			return vitalList;
		}
		
		public List<MedFrequency> getFreList(){
		      MedFrequency medfre=new MedFrequency();
		    return medfre.getFreqList();
		}
		public List<String> getDurUnitList(){
		      MedFrequency medfre=new MedFrequency();
		    return medfre.getDurUnitList();
		}
		public Collection<MedicalOrderDto> saveMedication(MedicalOrderDto medication,boolean need){
			MedicalOrder med=new MedicalOrder();
			if(medication.getMedicalorderId()!=null&& medication.getMedicalorderId()>0)
			{
				med=medicationRepo.findOne(medication.getMedicalorderId());
			}
			med.setMedicalorderId(getMaxMedicationId());
			med.setAdmInstr(medication.getAdmInstr());
			med.setBrandName(medication.getBrandName());
			med.setApplyRoute(medication.getApplyRoute());
			med.setDrugForm(medication.getDrugForm());
			med.setCreatedUId(medication.getProviderId());
			med.setDosage(medication.getDosage());
			med.setDrugName(medication.getActdrugName());
			med.setDrugUnits(medication.getDrugUnits());
			med.setDuration(medication.getDuration());
			med.setDurationUnits(medication.getDurationUnits());
			med.setEncounterId(medication.getEncounterId());
			med.setFrequency(medication.getFrequency());
			med.setPatInstr(medication.getPatInstr());
			med.setPharmInstr(medication.getPharmInstr());
			med.setProvType(medication.getProvType());
			if(medication.getProvType()!=null && medication.getProvType().equals("Doctor")){
				med.setOrdStatus(OrderTypesEnum.Approved.toString());
				med.setApprovedProvider(medication.getProviderId());
			}
			else med.setOrdStatus(OrderTypesEnum.Pending.toString()); 
			medicationRepo.save(med);
			if(!need) return null;
			
			Collection<MedicalOrder> medOrders= medicationRepo.findTop6ByEncounterIdOrderByCreateTsDesc(medication.getEncounterId());
			return convertMedOrderToDto(medOrders);
			
		}
		
		public MedicalOrderDto findMedicalorder(Long medicationId){
			MedicalOrder medication= medicationRepo.findOne(medicationId);
			MedicalOrderDto med=new MedicalOrderDto();
			med.setMedicalorderId(medication.getMedicalorderId());
			med.setAdmInstr(medication.getAdmInstr());
			med.setBrandName(medication.getBrandName());
			med.setActdrugName(medication.getDrugName());
			med.setSearchdrugName(medication.getDrugName());
			med.setDosage(medication.getDosage());
			med.setDrugName(medication.getDrugName());
			med.setDrugUnits(medication.getDrugUnits());
			med.setDuration(medication.getDuration());
			med.setDurationUnits(medication.getDurationUnits());
			med.setEncounterId(medication.getEncounterId());
			med.setFrequency(medication.getFrequency());
			med.setPatInstr(medication.getPatInstr());
			med.setPharmInstr(medication.getPharmInstr());
			med.setProvType(medication.getProvType());
			med.setOrdStatus(medication.getOrdStatus());
			med.setCreatedUId(medication.getCreatedUId());
		//	if(medication.getProvType()!=null && medication.getProvType().equals("Doctor")){
			//	med.setOrdStatus(OrderTypesEnum.Approved.toString());
			//	med.setApprovedProvider(medication.getProviderId());
		//	}
			//else med.setOrdStatus(OrderTypesEnum.Pending.toString()); 
	     return med;
		}
		
		public Collection<MedicalOrderDto> findEncounterMedication(Long encounterId){
			Collection<MedicalOrder> medOrders= medicationRepo.findTop6ByEncounterIdOrderByCreateTsDesc(encounterId);
			return convertMedOrderToDto(medOrders);
		}
		private Collection<MedicalOrderDto> convertMedOrderToDto(Collection<MedicalOrder> medOrders){
			Collection<MedicalOrderDto> medordList=new ArrayList<MedicalOrderDto>();
			MedicalOrderDto med=null;
			for(MedicalOrder medication:medOrders){
			med=new MedicalOrderDto();
			med.setMedicalorderId(medication.getMedicalorderId());
			med.setAdmInstr(medication.getAdmInstr());
			med.setBrandName(medication.getBrandName());
			//med.setChemicalName(medication.getChemicalName()+" "+medication.getBrandName());
			med.setDosage(medication.getDosage());
			med.setDrugName(medication.getDrugName()+" "+medication.getDosage()+" "+medication.getDrugUnits()+" "+medication.getDuration()+" "+medication.getDurationUnits());
			med.setDrugUnits(medication.getDrugUnits());
			med.setDuration(medication.getDuration());
			med.setDurationUnits(medication.getDurationUnits());
			med.setFrequency(medication.getFrequency());
			med.setPatInstr(medication.getPatInstr());
			med.setPharmInstr(medication.getPharmInstr());
			med.setOrdStatus(medication.getOrdStatus());
			//if(medication.getDrugL()!=null)
			//med.setDrugL(medication.getDrugL());
			medordList.add(med);
			}
			return medordList;
		}
		
		public Collection<LabOrderDto> saveLaborder(LabOrderDto laborder,boolean need){
			LabOrder order=new LabOrder();
			order.setLabOrderId(getMaxLaborderId());
			order.setComments(laborder.getComments());
			order.setCreatedUId(laborder.getProvider());
			order.setCreateTs(new Date());
			order.setEncounterId(laborder.getEncounterId());
			order.setPriority(laborder.getPriority());
			order.setReason(laborder.getReason());
			order.setSpecimen(laborder.getSpecimen());
			order.setSpecimenDirection(laborder.getSpecimenDirection());
			order.setTestName(laborder.getTestName());
			order.setTestTime(laborder.getTestTime());
			order.setTestType(laborder.getTestType());
			order.setBodypart(laborder.getBodypart()); 
			order.setModality(laborder.getModality());
			ProviderL pro=new ProviderL();
			pro.setProviderID(laborder.getProvider());
			order.setProviderL(pro);
			order.setProvType(laborder.getProvType());
			if(laborder.getProvType()!=null && laborder.getProvType().equals("Doctor")){
				order.setOrdStatus(OrderTypesEnum.Approved.toString());
				order.setApprovedProvider(laborder.getProvider());
			}
			else order.setOrdStatus(OrderTypesEnum.Pending.toString()); 
	
			labOrderRepo.save(order);
			 Collection<LabOrder> laborders= labOrderRepo.findTop6ByEncounterIdOrderByCreateTsDesc(laborder.getEncounterId());
	    	   return convertLabOrderToDto(laborders);
		}
		public LabOrderDto findLabOrder(Long laborderId){
			LabOrder laborder=labOrderRepo.findOne(laborderId);
			LabOrderDto order=new LabOrderDto();
			order.setLabTestId(laborder.getLabOrderId());
			order.setComments(laborder.getComments());
			order.setCreateTs(laborder.getCreateTs());
			order.setEncounterId(laborder.getEncounterId());
			order.setPriority(laborder.getPriority());
			order.setReason(laborder.getReason());
			order.setSpecimen(laborder.getSpecimen());
			order.setSpecimenDirection(laborder.getSpecimenDirection());
			order.setTestName(laborder.getTestName());
			order.setTestTime(laborder.getTestTime());
			order.setProvType(laborder.getProvType());
	     return order;
		}
       public Collection<LabOrderDto> findEncounterLaborders(Long encounterId){
    	   Collection<LabOrder> laborders= labOrderRepo.findTop6ByEncounterIdOrderByCreateTsDesc(encounterId);
    	   return convertLabOrderToDto(laborders);
 		}
       
       private Collection<LabOrderDto> convertLabOrderToDto( Collection<LabOrder> laborders){
			  Collection<LabOrderDto> labordList=new ArrayList<LabOrderDto>();
	    	   LabOrderDto order=null;
	    	   for(LabOrder laborder :laborders){
	    	    order=new LabOrderDto();
	    	    order.setLabTestId(laborder.getLabOrderId());
				order.setComments(laborder.getComments());
				order.setEncounterId(laborder.getEncounterId());
				order.setPriority(laborder.getPriority());
				order.setReason(laborder.getReason());
				order.setSpecimen(laborder.getSpecimen());
				order.setSpecimenDirection(laborder.getSpecimenDirection());
				order.setTestName(laborder.getTestName());
				order.setTestTime(laborder.getTestTime());
				order.setOrdStatus(laborder.getOrdStatus());
				labordList.add(order);
	    	   }
	    	   return labordList;
		}
		
       public Collection<ConsultDto> saveConsult(ConsultDto consultdto,boolean need){
    	   Consult consult=new Consult();
    	   consult.setConsultId(getMaxConsultId());
    	   consult.setCreateTs(new Date());
    	   consult.setCreatedUId(consultdto.getCreatedUId());
    	   consult.setConsultDept(consultdto.getConsultDept());
    	   consult.setEncounterId(consultdto.getEncounterId());
    	   consult.setInformed(consultdto.getInformed());
    	   consult.setReason(consultdto.getReason());
    	   consult.setProvType(consultdto.getProvType());
    	   ProviderL fromprovider=new ProviderL();
    	   fromprovider.setProviderID(consultdto.getCreatedUId());
    	   consult.setConsultFrom(fromprovider);
    	   if(consultdto.getToPhysician()!=null){
    	   ProviderL toprovider=new ProviderL();
    	   toprovider.setProviderID(consultdto.getToPhysician());
    	   consult.setConsultFrom(toprovider);
    	   }
    	   consultRepo.save(consult);
    	   Collection<Consult> consultList=consultRepo.findTop6ByEncounterIdOrderByCreateTsDesc(consultdto.getEncounterId());
    	   return convertConsultDto(consultList);
       }
       public ConsultDto findConsult(Long consultId){
    	   Consult consult=consultRepo.findOne(consultId);
    	   ConsultDto consultDt=new ConsultDto();
    	   consultDt.setConsultId(consult.getConsultId());
    	   consultDt.setCreateTs(consult.getCreateTs());
    	   consultDt.setCreatedUId(consult.getCreatedUId());
    	   consultDt.setConsultDept(consult.getConsultDept());
    	   consultDt.setEncounterId(consult.getEncounterId());
    	   consultDt.setInformed(consult.getInformed());
    	   consultDt.setReason(consult.getReason());
    	   consultDt.setProvType(consult.getProvType());
    	   if(consult.getConsultTo()!=null){
    	 //  ProviderL toprovider=new ProviderL();
    	   consultDt.setToPhysician(consult.getConsultTo().getProviderID());
    	  // consult.setConsultFrom(toprovider)
    	   };
    	   return consultDt;
       }
       public Collection<ConsultDto> findEncounterConsults(Long encounterId){
    	   Collection<Consult> consultList=consultRepo.findTop6ByEncounterIdOrderByCreateTsDesc(encounterId);
    	   return convertConsultDto(consultList);
       }
       
       private Collection<ConsultDto> convertConsultDto( Collection<Consult> consults){
			  Collection<ConsultDto> consultList=new ArrayList<ConsultDto>();
			  ConsultDto consultdto=null;
	    	   for(Consult consult :consults){
	    		   consultdto=new ConsultDto();
	    		   consultdto.setCreateTs(consult.getCreateTs());
	    		   consultdto.setConsultDept(consult.getConsultDept());
	    		   consultdto.setEncounterId(consult.getEncounterId());
	    		   consultdto.setInformed(consult.getInformed());
	    		   consultdto.setReason(consult.getReason());
	    		   consultdto.setProvType(consult.getProvType());
	    		   consultdto.setConsultId(consult.getConsultId());
	    		   System.out.println("from name="+consult.getConsultFrom().getFirstname()+","+consult.getConsultFrom().getLastname());
	    		   consultdto.setConsultFrom(consult.getConsultFrom().getFirstname()+","+consult.getConsultFrom().getLastname());
	    		   if(consult.getConsultTo()!=null)
	    		   consultdto.setConsultTo(consult.getConsultTo().getFirstname()+","+consult.getConsultTo().getLastname());
	     	     consultList.add(consultdto);
	    	   }
	    	   return consultList;
		}
       public Collection<OtherOrdersDto> saveOtherOrder(OtherOrdersDto othorderdt,boolean need){
    	   OtherOrders othorder=new OtherOrders();
    	   System.out.println("to  othorderdt.getOtherOrderId  ="+othorderdt.getOtherOrderId());
    	   if(othorderdt.getOtherOrderId()!=null && othorderdt.getOtherOrderId()>1L){
    	      
    		   othorder= othordersRepo.findOne(othorderdt.getOtherOrderId());
    	       othorder.setOrdername(othorderdt.getOrdername());
        	   othorder.setSpecialInstructions(othorderdt.getSpecialInstructions());
        	   othorder.setOrdertype(othorderdt.getOrdertype());
        	   othorder.setUpdateUId(othorderdt.getCreatedUId());
        	   System.out.println("update=====");
    	       othordersRepo.save(othorder);
    	   }else{
    		   othorder.setOtherOrderId(getMaxOtherOrderId());
    	   othorder.setEncounterId(othorderdt.getEncounterId());
    	   othorder.setCreateTs(new Date());
    	   othorder.setCreatedUId(othorderdt.getCreatedUId());
    	   othorder.setProvType(othorderdt.getProvType());
    	   othorder.setOrdername(othorderdt.getOrdername());
    	   othorder.setSpecialInstructions(othorderdt.getSpecialInstructions());
    	   othorder.setOrdertype(othorderdt.getOrdertype());
    	   ProviderL fromprovider=new ProviderL();
    	   fromprovider.setProviderID(othorderdt.getCreatedUId());
    	   othorder.setOrderfrom(fromprovider);
    	   if(othorderdt.getToPhysician()!=null){
    	   ProviderL toprovider=new ProviderL();
    	   toprovider.setProviderID(othorderdt.getToPhysician());
    	   othorder.setOrderto(toprovider);
    	   }
    	   othordersRepo.save(othorder);
    	   }
    	   if(!need) return null;
    	   Collection<OtherOrders> orderList=othordersRepo.findTop6ByEncounterIdOrderByCreateTsDesc(othorderdt.getEncounterId());
    	   return convertOtherOrderDto(orderList);
       }
       
       public OtherOrdersDto findOtherOrder(Long othorderId){
    	   OtherOrders othorderdt= othordersRepo.findOne(othorderId);
    	   OtherOrdersDto othorder=new OtherOrdersDto();
    	   othorder.setOtherOrderId(getMaxOtherOrderId());
    	   othorder.setEncounterId(othorderdt.getEncounterId());
    	   othorder.setCreateTs(new Date());
    	   othorder.setCreatedUId(othorderdt.getCreatedUId());
    	   othorder.setProvType(othorderdt.getProvType());
    	   othorder.setOrdername(othorderdt.getOrdername());
    	   othorder.setSpecialInstructions(othorderdt.getSpecialInstructions());
    	   othorder.setOrdertype(othorderdt.getOrdertype());
    	  // othorder.setOrderfrom(fromprovider);
    	   if(othorderdt.getOrderto()!=null){
    		   othorder.setToPhysician(othorderdt.getOrderto().getProviderID());
    	   }
    	  return othorder; 
       }
       
       public Collection<OtherOrdersDto> findEncounterOtherOrders(Long encounterId){
    	   Collection<OtherOrders> orderList=othordersRepo.findTop6ByEncounterIdOrderByCreateTsDesc(encounterId);
    	   return convertOtherOrderDto(orderList);
       }
       private Collection<OtherOrdersDto> convertOtherOrderDto( Collection<OtherOrders> othorders){
			  Collection<OtherOrdersDto> orderList=new ArrayList<OtherOrdersDto>();
			  OtherOrdersDto othorderdt=null;
			  for(OtherOrders othorder:othorders){
				  othorderdt=new OtherOrdersDto();
				  othorderdt.setOtherOrderId(othorder.getOtherOrderId());
				  othorderdt.setEncounterId(othorder.getEncounterId());
				  othorderdt.setCreateTs(othorder.getCreateTs());
				  othorderdt.setSpecialInstructions(othorder.getSpecialInstructions());
				  othorderdt.setProvType(othorder.getProvType());
				  othorderdt.setOrdername(othorder.getOrdername());
				  othorderdt.setOrdertype(othorder.getOrdertype());
				  othorderdt.setOrderfrom(othorder.getOrderfrom().getFirstname());
		      	   if(othorder.getOrderto()!=null){
		      		   System.out.println("order to first"+othorder.getOrderto().getFirstname());
		      		 othorderdt.setOrderto(othorder.getOrderto().getFirstname());
		      	   }
	      	 orderList.add(othorderdt);
	        }
			  return orderList;
       }
       
       public Collection<IllnessDto> saveIllness(IllnessDto illness){
    	   Illness ill=new Illness();
    	   if(illness.getIllnessId()!=null && illness.getIllnessId()>0){
    		  ill= illnessRepo.findOne(illness.getIllnessId());
    		  ill.setHospRelated(illness.isHospRelated());
       	      ill.setPrimary(illness.isPrimary());
       	      ill.setPrincipalProb(illness.isPrincipalProb());
       	       Diseases dises=new Diseases();
       	      dises.setDiseaseId(illness.getDiseaseId());
       	      ill.setDisease(dises);
    		  ill.setEndDtTm(illness.getEndDtTm());
    		  ill.setUpdateUId(illness.getCreatedUId());
    		  ill.setUpdateTs(new Date());
    		  illnessRepo.save(ill);
    	   }else{
    	   ill.setIllnessId(getMaxIllnessId());
    	   ill.setEncounterId(illness.getEncounterId());
    	   ill.setHospRelated(illness.isHospRelated());
    	   ill.setPrimary(illness.isPrimary());
    	   ill.setPrincipalProb(illness.isPrincipalProb());
    	       Diseases dises=new Diseases();
    	   dises.setDiseaseId(illness.getDiseaseId());
    	   ill.setDisease(dises);
    	   ill.setCreatedUId(illness.getCreatedUId());
    	   ill.setCreateTs(new Date());
    	   ill.setProvType(illness.getProvType());
    	      ProviderL provider=new ProviderL();
    	   provider.setProviderID(illness.getCreatedUId());
    	   
    	   ill.setProvider(provider);
    	   ill.setStartDtTm(illness.getStartDtTm());
    	   ill.setEndDtTm(illness.getEndDtTm());
    	   illnessRepo.save(ill);
    	   }
    	   return null;
       }
       public Collection<IllnessDto> findEncounterIllness(Long encounterId){
    	  Collection<Illness> illnessList= illnessRepo.findByEncounterId(encounterId);
    	  Collection<IllnessDto> illList=new ArrayList<IllnessDto>();
    	  for(Illness illness:illnessList){
    		  IllnessDto  ill=new IllnessDto();
	   		   ill.setIllnessId(getMaxIllnessId());
	       	   ill.setEncounterId(illness.getEncounterId());
	       	   ill.setHospRelated(illness.isHospRelated());
	       	   ill.setPrimary(illness.isPrimary());
	       	   ill.setPrincipalProb(illness.isPrincipalProb());
	       	   ill.setDiseaseId(illness.getDisease().getDiseaseId());
	       	   ill.setDiseasename(illness.getDisease().getDiseaseName());
	       	   ill.setCreatedUId(illness.getCreatedUId());
	       	   ill.setCreateTs(new Date());
	       	   ill.setProvType(illness.getProvType());
	           ill.setStartDtTm(illness.getStartDtTm());
        	   ill.setEndDtTm(illness.getEndDtTm());
        	   illList.add(ill);
    	    }
    	   return illList;
       }
       public IllnessDto findIllness(Long illnessId){
    	   Illness illness= illnessRepo.findOne(illnessId);
    	   IllnessDto ill=null;
    	   if(illness!=null){
    		   ill=new IllnessDto();
    		   
    		   ill.setIllnessId(illness.getIllnessId());
        	   ill.setEncounterId(illness.getEncounterId());
        	   ill.setHospRelated(illness.isHospRelated());
        	   ill.setPrimary(illness.isPrimary());
        	   ill.setPrincipalProb(illness.isPrincipalProb());
        	   ill.setDiseaseId(illness.getDiseaseId());
        	   ill.setCreatedUId(illness.getCreatedUId());
        	   ill.setCreateTs(new Date());
        	   ill.setProvType(illness.getProvType());
        	   ill.setStartDtTm(illness.getStartDtTm());
        	   ill.setEndDtTm(illness.getEndDtTm());
        	   ill.setDiseaseId(illness.getDisease().getDiseaseId());
	       	   ill.setDiseasename(illness.getDisease().getDiseaseName());
    	   }
    	     return ill;
    	   
    	   
       }
       
       
       public List<MastLabTests> findByTestNameLikeIgnoringCase(String testname){
    	   //List<String> labtests=new ArrayList<String>();
    	   List<MastLabTests> testList=mastLabTestsRepo.findByTestnameLikeIgnoringCase(testname);
    	   System.out.println("testList "+testList.size());
    	  /* for(MastLabTests test:testList){
    		   StringBuffer str=new StringBuffer();
    		   str.append(test.getSpecimen()==null?"":" "+test.getSpecimen()).append(test.getBodypart()==null?"":" "+test.getBodypart()).append(test.getModality()==null?"":" "+test.getModality());
    		   labtests.add(test.getTestname()+" "+test.getTestType()+" "+str.toString());
    	      }*/
    	   return testList;
       }
       public Map<Long,String> findByDiseaseNameLikeIgnoringCase(String diseasename){
    	   Map<Long,String> dissMap=new HashMap<Long,String>();
    	   Page<Diseases> disList=diseasesRepo.findByDiseaseNameLikeIgnoringCase(diseasename,new PageRequest(0, 30));
    	  if(disList!=null) System.out.println("disList=="+disList.getContent().size());
    	   for(Diseases test:disList.getContent()){
    		   dissMap.put(test.getDiseaseId(), test.getDiseaseName());
    	      }
    	   System.out.println("dissMap=="+dissMap.size());
    	   return dissMap;
       } 
       public Page<Drugs> finddrugName(String drugname){
    	   //Map<Long,String> drugMap=new HashMap<Long,String>();drugname
    	   Page<Drugs> disList=drugsRepo.findByNonProprietaryNameLikeIgnoringCase(drugname,new PageRequest(1,500));
    	  //if(disList!=null) System.out.println("disList=="+disList.getTotalElements());
    	   //for(Drugs dr:disList){
    		//   drugMap.put(dr.getDrugId(), dr.getNonProprietaryName());
    	    //  }
    	  // System.out.println("dissMap=="+drugMap.size());
    	   return disList;
       } 
       
      public TreatmentResponse getDrugs(String drugname){ 
    	  TreatmentResponse response=new TreatmentResponse();
    	  Query query = new Query();
  		  query.addCriteria(Criteria.where("nonProprietaryName").regex(Pattern.compile(".*"+drugname+".*", Pattern.CASE_INSENSITIVE)));  
  		  long total = mongoTemplate.count(query, DrugsL.class);
  		System.out.println("total=="+total);
         if(total>200){
        	 response.setStatus(250L);
        	 return response;
         }
  		  query.fields().include("_id").include("nonProprietaryName").include("dosageFormName").include("strengthNumber").include("strengthUnit").include("strengthUnit").include("proprietaryName").include("routeName");
  		  List<DrugsL> drugList=mongoTemplate.find(query, DrugsL.class);
  		 Collection<DrugsL> drugSet=new LinkedHashSet<DrugsL>(drugList);
  		  response.setDrugSet(drugSet);
  		 response.setTotelements(drugSet.size());
          System.out.println(drugSet.size()+" =total= criteria = "+query.toString());
          return response;
      }
      
      
      private String toLikeRegex(String source) {
          return  "%"+source+"%";
      }
		public Long getMaxNotesId(){
			Long max=1L;
			try{
			Query query = new Query();
			query.with(new Sort(Sort.Direction.DESC,"notesId"));
		    query.limit(1);
			query.fields().include("_id");
			Notes note=mongoTemplate.findOne(query, Notes.class);
			if(note==null || note.getNotesId()==null) 
				return max;
			return max=note.getNotesId()+1;
			}catch(NullPointerException e){e.printStackTrace();}
			return max;
		}
		public Long getMaxIllnessId(){
			Long max=1L;
			try{
			Query query = new Query();
			query.with(new Sort(Sort.Direction.DESC,"illnessId"));
		    query.limit(1);
			query.fields().include("_id");
			Illness ill=mongoTemplate.findOne(query, Illness.class);
			if(ill==null || ill.getIllnessId()==null) 
				return max;
			return max=ill.getIllnessId()+1;
			}catch(NullPointerException e){e.printStackTrace();}
			return max;
		}
		public Long getMaxVitalId(){
			Long max=1L;
			try{
			Query query = new Query();
			query.with(new Sort(Sort.Direction.DESC,"vitalId"));
		    query.limit(1);
			query.fields().include("_id");
			Vitals vital=mongoTemplate.findOne(query, Vitals.class);
			if(vital==null || vital.getVitalId()==null) return max;
			return max=vital.getVitalId()+1;
			}catch(NullPointerException e){e.printStackTrace();}
			return max;
		}
		
		public Long getMaxMedicationId(){
			Long max=1L;
			try{
			Query query = new Query();
			query.with(new Sort(Sort.Direction.DESC,"MedicalOrder"));
		    query.limit(1);
			query.fields().include("_id");
			MedicalOrder medic=mongoTemplate.findOne(query, MedicalOrder.class);
			if(medic==null || medic.getMedicalorderId()==null) return max;
			return max=medic.getMedicalorderId()+1;
			}catch(NullPointerException e){e.printStackTrace();}
			return max;
		}
		public Long getMaxLaborderId(){
			Long max=1L;
			try{
			Query query = new Query();
			query.with(new Sort(Sort.Direction.DESC,"labOrderId"));
		    query.limit(1);
			query.fields().include("_id");
			LabOrder note=mongoTemplate.findOne(query, LabOrder.class);
			if(note==null || note.getLabOrderId()==null) return max;
			return max=note.getLabOrderId()+1;
			}catch(NullPointerException e){e.printStackTrace();}
			return max;
		}
		public Long getMaxConsultId(){
			Long max=1L;
			try{
			Query query = new Query();
			query.with(new Sort(Sort.Direction.DESC,"consultId"));
		    query.limit(1);
			query.fields().include("_id");
			Consult consult=mongoTemplate.findOne(query, Consult.class);
			if(consult==null || consult.getConsultId()==null) return max;
			return max=consult.getConsultId()+1;
			}catch(NullPointerException e){e.printStackTrace();}
			return max;
		}
		
		public Long getMaxOtherOrderId(){
			Long max=1L;
			try{
			Query query = new Query();
			query.with(new Sort(Sort.Direction.DESC,"otherOrderId"));
		    query.limit(1);
			query.fields().include("_id");
			OtherOrders othorder=mongoTemplate.findOne(query, OtherOrders.class);
			if(othorder==null || othorder.getOtherOrderId()==null) return max;
			return max=othorder.getOtherOrderId()+1;
			}catch(NullPointerException e){e.printStackTrace();}
			return max;
		}
  }
