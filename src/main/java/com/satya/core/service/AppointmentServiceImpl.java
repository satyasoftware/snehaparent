package com.satya.core.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.satya.core.bean.Appointment;
import com.satya.core.bean.Provider;
import com.satya.core.bean.ProviderInstitute;
import com.satya.core.bean.Treatment;
import com.satya.core.beanLimit.ProviderL;
import com.satya.core.dao.MenuDao;
import com.satya.core.dao.ProviderDao;
import com.satya.core.enums.AppintmentTypes;
import com.satya.core.repo.AppointmentRepo;
import com.satya.core.repo.ProviderInstitutionRepo;
import com.satya.core.repo.TreatmentRepo;
@Service("appointmentService")
//@Transactional(readOnly = true)
public class AppointmentServiceImpl implements AppointmentService {
	
@Autowired 	private AppointmentRepo appointRepo;

@Autowired	private MenuDao increDao;

@Autowired	private ProviderInstitutionRepo providInstRepo;

@Autowired	private ProviderDao proviDao;

@Autowired	private TreatmentRepo treatmentRepo;

//@Autowired
//private PersonRepo personRepo;


//@Autowired
//private DoctorNurseMapRepo doctNursMapRepo;
//@Autowired
//private EncounterRepo encountRepo;

	/*public Collection<String> getAppointmentThrough(){
		Collection<String> appointTypes=new HashSet<String>();
		appointTypes.add("InPatient");
		appointTypes.add("OutPatient");
		return appointTypes;
	}*/
	public Collection<AppintmentTypes> getEncounterTypes(){
		Collection<AppintmentTypes> appointTypes = new ArrayList<AppintmentTypes>( Arrays.asList(AppintmentTypes.values() ));
	
		return appointTypes;
	}
	public Collection<String> getAppointmentFor(String instType){
		Collection<String> appointTypes=new ArrayList<String>();
		if(instType==null)
		{appointTypes.add("Doctor");
		appointTypes.add("Blood Sample");
		appointTypes.add("Lab Work");
		appointTypes.add("Others");
		}
		else if(instType.contains("Lab")|| instType.contains("lab")){
			appointTypes.add("Lab Work");
		}else if(instType.contains("Pharmacy")|| instType.contains("pharmacy")){
			appointTypes.add("Others");
		}else  if(instType.contains("Hospital")|| instType.contains("hospital")){
		appointTypes.add("Doctor");
		appointTypes.add("Blood Sample");
		appointTypes.add("Others");
		
		}
		return appointTypes;
	}
	
	public Appointment saveAppointment(Appointment appoint){
		Long appId= increDao.getAppointmentId();
		appoint.setAppointmentId(appId);
		
		Appointment appo= appointRepo.save(appoint);
		if(appoint.getCreatedUId()!=appoint.getPersonId()){
		if(null==appoint.getScheduleStatus() || !appoint.getScheduleStatus()){
			sendMail(appo);
		}
		}
		return appo;
	}
	public Appointment updateAppointment(Appointment appoint){
		
		Appointment appo= appointRepo.save(appoint);
		return appo;
	}
	
	private void sendMail(Appointment appo){
		System.out.println("Sending mail beacause no schedule found to this Institute");
		
	}
	
	public Appointment findAppointment(Long appointId){
		Appointment appo= appointRepo.findByAppointmentIdAndStatus(appointId,'O');
		//if(appo.getPersonId()!=null)appo.setPerson(personRepo.findById(appo.getPersonId()));
		//if(appo.getPreferedProvider()!=null)appo.setProvider(proviDao.findProvider(appo.getPreferedProvider()));
         return appo;
	}
	
	public Collection<Provider> getInstProviders(Long instId,String instType){
		Collection<ProviderInstitute> provInst;
		if(instType.contains("Hospital"))
			 provInst= providInstRepo.findByInstIdAndProvTypeAndStatus(instId, "Doctor",true);
		else provInst= providInstRepo.findByInstId(instId);
		 
		return proviDao.getInstProviders(getProIds(provInst));
	}
	
	public Collection<Appointment> getInstAppointments(Long instId){
		Collection<Appointment> appoList=appointRepo.findByInstId(instId);
		//for(Appointment appo:appoList){
			//if(appo.getPersonId()!=null)appo.setPerson(proviDao.findPerson(appo.getPersonId()));
			//if(appo.getPreferedProvider()!=null)appo.setProvider(proviDao.findProvider(appo.getPreferedProvider()));
		//}
		return appoList;
	}
	
public Page<Appointment> getInstNurseAppointments(Long instId,Collection<Long> doctList,Date inputdate,int pageno){
		
		//Long empty=null;
		Date searchDate=getDate(inputdate);
		System.out.println(inputdate+" in searchDate=="+searchDate);
		//return appointRepo.findByInstIdAndStatusAndStartDtTmBetweenAndPreferedProviderInOrPreferedProvider(instId,'O', searchDate, getNextDate(searchDate),doctList,empty);
		return appointRepo.findByInstIdAndStatusAndStartDtTmIsBetween(instId,'O', searchDate, getNextDate(searchDate),new PageRequest(pageno,20));
}

	public Page<Appointment> getInstNurseAppointments(Long instId,Collection<Long> doctList,int pageno){
		//Long empty=null;
		//return appointRepo.findByInstIdAndStatusAndStartDtTmBetweenAndPreferedProviderInOrPreferedProvider(instId,'O', todayStart(), todayend(),doctList,empty);
		return appointRepo.findByInstIdAndStatusAndStartDtTmIsBetween(instId,'O', todayStart(), todayend(),new PageRequest(pageno,20));
	}
	
	public Map<String,Collection> getInstNurseAppointmentsAndEncounters(Long instId,Long nurseId,Collection<Long> doctList){
		Map<String,Collection> nurseMap=new HashMap<String,Collection>();
		Long empty=null;
		Collection<Appointment> appoList=appointRepo.findByInstIdAndStatusAndStartDtTmBetweenAndPreferedProviderInOrPreferedProvider(instId,'O', todayStart(), todayend(),doctList,empty);
		
		nurseMap.put("doctAppo", appoList);

		Collection<Treatment> outTreats= treatmentRepo.findByInstIdAndEncounterTypeAndProviderIdInAndStatusOrderByEncounterId(instId,"OutPatient",doctList, 'O');
		nurseMap.put("outTreats", outTreats);
		
		Collection<Treatment> nurseTreats=treatmentRepo.findByInstIdAndStatusAndProviderIdAndEncounterTypeOrderByEncounterId(instId, 'O',nurseId,"InPatient");
		Collection<Long> encIdList=getEcounterIds(nurseTreats);
		if(encIdList!=null && encIdList.size()>0){
			System.out.println("nurseTreats"+nurseTreats.size());
		Collection<Treatment> doctTreats=treatmentRepo.findByEncounterIdInAndProviderIdInAndStatusOrderByEncounterId(encIdList, doctList,'O');
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
		
		
			for(Treatment baseTree:nurseTreats){
				char attphy='N';
				ProviderL attendPhy=null;
				Collection<Treatment> doctTreets=treetMentMap.get(baseTree.getEncounterId());
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
					
					baseTree.setDocts(docts);
					baseTree.setAttendingPhysician(attphy);
					baseTree.setProviderL(attendPhy);
					
					System.out.println("in getAttendingPhysician"+baseTree.getAttendingPhysician());
				}
				
				
			}
		}
		
		nurseMap.put("inPatTreats", nurseTreats);
		
		
		Collection<Treatment> obserTreats=treatmentRepo.findByInstIdAndStatusAndProviderIdAndEncounterTypeOrderByEncounterId(instId, 'O',nurseId,"Observation");
		Collection<Long> obencIdList=getEcounterIds(obserTreats);
		if(obencIdList!=null && obencIdList.size()>0){
		Collection<Treatment> obdoctTreats=treatmentRepo.findByEncounterIdInAndProviderIdInAndStatusOrderByEncounterId(obencIdList, doctList,'O');
	
		
		Map<Long,Collection<Treatment>> obtreetMentMap=new HashMap<Long,Collection<Treatment>>();
		
		for(Treatment doctTre:obdoctTreats){
			Collection<Treatment> trList=new ArrayList<Treatment>();
			if(obtreetMentMap.get(doctTre.getEncounterId())!=null){
				obtreetMentMap.get(doctTre.getEncounterId()).add(doctTre);
			}else{
				trList.add(doctTre);
				obtreetMentMap.put(doctTre.getEncounterId(), trList);
			}
		}
	
		
		
			for(Treatment baseTree:obserTreats){
				Collection<Treatment> doctTreets=obtreetMentMap.get(baseTree.getEncounterId());
				Collection<String> docts;
				if(doctTreets!=null && doctTreets.size()>0){
					docts=new ArrayList<String>();
					for(Treatment treets: doctTreets){
						if(treets.getAttendingPhysician()=='Y'){
							baseTree.setAttendingPhysician('Y');
							baseTree.setAttePhysiName(treets.getProviderL());
						}else{
							docts.add(treets.getProviderL().getFirstname());
						}
					}
					baseTree.setDocts(docts);
				}
				
				
			}
		}
		nurseMap.put("obserTreats", obserTreats);
		System.out.println("Appo= size=="+appoList.size());
		
		//System.out.println(outTreats.size()+"=outTreats appo assignTreats=="+assignTreats.size());
	 return nurseMap;
	}
	 private Collection<Long> getEcounterIds(Collection<Treatment> nurseTreats){
		 Collection<Long> encoIds=new HashSet<Long> ();
		 for(Treatment tre:nurseTreats){
			 encoIds.add(tre.getEncounterId());
		 }
		 return encoIds;
	 }
	public Page<Appointment> getInstAppointmentsPaging(Long instId,int pageno){
		Page<Appointment> appoList=appointRepo.findByInstId(instId,new PageRequest(pageno,10));
		for(Appointment appo:appoList.getContent()){
			if(appo.getPersonId()!=null)appo.setPerson(proviDao.findPerson(appo.getPersonId()));
			if(appo.getPreferedProvider()!=null)appo.setProvider(proviDao.findProvider(appo.getPreferedProvider()));
		}
		return appoList;
	}	
	
	private Collection<Long> getProIds(Collection<ProviderInstitute> instProviders){
		Collection<Long> proList=new HashSet<Long>();
		for(ProviderInstitute proInst:instProviders){
			proList.add(proInst.getProvId());
		}
		return proList;
	}
	
	/*private Collection<Long> getDoctIds(Collection<DoctorNurseMap> instProviders){
		Collection<Long> doctList=new HashSet<Long>();
		for(DoctorNurseMap proInst:instProviders){
			doctList.add(proInst.getDoctorId());
		}
		return doctList;
	}
	
	private String formatDate(Date date){
		
       return  DATE_FORMAT1.format(date);
   }*/

	private Date  getDate(Date datestr) {
		
			 Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
			 cal.setTime(datestr);
			 //cal.add(Calendar.DAY_OF_MONTH+1, 0);
			    try{
			    	String date=DATE_FORMAT.format(cal.getTime());
			    	datestr=formatter.parse(date);
			   	}catch(Exception e){e.printStackTrace();}
		       System.out.println("search Date="+datestr);
		     return datestr;
	 }

	 private Date  getNextDate(Date tommarow) {
		// Date tommarow = new Date();
		 Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		 cal.setTime(tommarow);
		 cal.add(Calendar.DAY_OF_MONTH+1, 1);
		    try{
		    	String date=DATE_FORMAT.format(cal.getTime());
		    	tommarow=formatter.parse(date);
		   	}catch(Exception e){e.printStackTrace();}
	       System.out.println("getNextDate-"+tommarow);
	     return tommarow;
	 }

	
SimpleDateFormat DATE_FORMAT1 = new SimpleDateFormat("MM/dd/yyyy");	
SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd");
SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
 
	 
	 private  Date  todayStart() {
		 Date today = new Date();
		 Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		 cal.setTime(today);
		 //cal.add(Calendar.DAY_OF_MONTH+1, 0);
		    try{
		    	String date=DATE_FORMAT.format(cal.getTime());
		    	today=formatter.parse(date);
		   	}catch(Exception e){e.printStackTrace();}
	       System.out.println("today-"+today);
	     return today;
     }
		 
	 private Date  todayend() {
		 Date tommarow = new Date();
		 Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		 cal.setTime(tommarow);
		 cal.add(Calendar.DAY_OF_MONTH+1, 1);
		    try{
		    	String date=DATE_FORMAT.format(cal.getTime());
		    	tommarow=formatter.parse(date);
		   	}catch(Exception e){e.printStackTrace();}
	       System.out.println("tommarow-"+tommarow);
	     return tommarow;
	 }
}
