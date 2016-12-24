package com.satya.core.service;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.satya.core.bean.Appointment;
import com.satya.core.bean.CodeTable;
import com.satya.core.bean.Diseases;
import com.satya.core.bean.Drugs;
import com.satya.core.bean.InstitutionType;
import com.satya.core.bean.PerSeqId;
import com.satya.core.bean.Person;
import com.satya.core.bean.Provider;
import com.satya.core.dao.PersonDao;
import com.satya.core.repo.AppointmentRepo;
import com.satya.core.repo.CodetablesRepo;
import com.satya.core.repo.DrugsRepo;
import com.satya.core.repo.PersonRepo;
import com.satya.core.repo.PersonSecurityRepo;
import com.satya.core.repo.PersonSeqRepo;
import com.satya.core.repo.ProviderRepo;

@Service("personService")
//@Transactional(readOnly = true)
public class PersonServiceImpl implements  PersonService{
	private static final Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);
	@Autowired
	private PersonRepo personRepo;
	@Autowired
	private ProviderRepo providerRepo;
	
	@Autowired
	private PersonSeqRepo personSeqRepo;
	@Autowired
	private CodetablesRepo codetableRepo;
	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private AppointmentRepo appoRepo;
	
	@Autowired
	private EncriptionService encriptionService;
	
	@Autowired
	private PersonSecurityRepo perSecRepo;
	//@Autowired
	//private MastLabTestsRepo mastLabTestsRepo;
	//@Autowired private DiseasesRepo diseasesRepo;
	@Autowired private DrugsRepo drugRepo;
	
	//@Override
	public void pushLabTests(){
		/*List<MastLabTests> labtests=new ArrayList<MastLabTests>();
		MastLabTests m=new MastLabTests();
		labtests= m.getRadiologyTestList();
		System.out.println("=labtests"+labtests.size());
        mastLabTestsRepo.save(labtests);*/
		
		/*List<Diseases> disList=new ArrayList<Diseases>();
		Diseases d=new Diseases();
		disList=d.getDeseaseList();
		System.out.println("=disList=="+disList.size());
		diseasesRepo.save(disList);*/
		// List<Drugs> drugList=new ArrayList<Drugs>();
		 //Drugs drug=new Drugs();
		// drugList=drug.getDrugs();
		// System.out.println("drugs size=="+drugList.size());
		//drugRepo.save(drugList);
	}
	
	@Override
	public Person findByPersonId(Long personId){
		return personRepo.findById(personId);
	}	
	
	public boolean checkPassword(String inputpaas,String dbpass){
		if(encriptionService.encode(inputpaas).equals(dbpass)) return true;
		else return false;
	}
	
	
	@Override
	public Person findByUserIdAndPassword(String userId,String userpass){
		userpass=encriptionService.encode(userpass);
		Person pers=personRepo.findByUserIdAndPassword(userId,userpass);
		return pers;
	}	
	
	@Override
	public Person findPersonByUserId(String userId){
		return personRepo.findByUserId(userId);
	}
	
	@Override
	public Person findPersonByGovtIdAndType(String govtId,String govtIdType){
		return personRepo.findByGovtIdAndGovtIdType(govtId,govtIdType);
	}
	
	
	@Override
	public CodeTable findAll(){
		Collection<String> roles=new TreeSet<String>();
		initializeCodetable();
	    //List<CodeTable> codetables=codetableRepo.findAll();
	   // CodeTable.setInstance(codetables.get(0));
		CodeTable codes=CodeTable.getInstance();
		System.out.println("getNoteType=="+codes.getNoteType().size());
        Collection<InstitutionType> instTypes=codes.getInstType();
			for(InstitutionType inType:instTypes){
				System.out.println("inType size="+inType.getRoles().size());
				roles.addAll(inType.getRoles());
			}
		codes.setProvType(roles);
		System.out.println("roles size="+roles.size());
		return codes;
	}
	
	private void initializeCodetable(){
		logger.info("initializing ");
		if(CodeTable.getInstance()==null){
			    List<CodeTable> codetables=codetableRepo.findAll();
			    CodeTable.setInstance(codetables.get(0));
			    
			    logger.info("fetching "); 
		  }
	}
	
/*	static boolean codes=false;
	@Override
	public CodeTable codeTablesSave(){
		System.out.println("codeTablesSave");
       if(!codes){
    	   codes=true; 
		return  codetableRepo.save(addCodetables());
       }
       else return null;
	}*/
	
	public List<Provider> findAllProviders(){
			
		List<Provider> prolist= providerRepo.findAll();
		/*for(Provider pro:prolist){
			System.out.println("password==="+pro.getUserId());
			pro.setPassword(encriptService.encode(pro.getUserId()));
			providerRepo.save(pro);
		}*/
		return prolist;
	}
	
	
	@Override
	public Person findAppointment(Long appointId,Person pp){
		
		Appointment appo= appoRepo.findByAppointmentId(appointId);
		if(appo!=null && appo.getPersonId()==null){
			pp.setAppointmentId(appo.getAppointmentId());
			pp.setFirstname(appo.getFirstName());
			pp.setLastname(appo.getLastName());
			pp.setCell_number(appo.getPersonmobile());
		}else return null;
		return pp;
	}
	@Override
	public Person updatePass(Person person) {
		person.setPassword(encriptionService.encode(person.getPassword()));
		return personRepo.save(person);
	}
	
	
	@Override
	public Person update(Person person){
		return personRepo.save(person);
	}
	
	@Override
	public Person save(Person person){
	
		person.setId(getPersontSequenceId());
		person.setPassword(encriptionService.encode(person.getPassword()));
		
		Person p=personRepo.save(person);
		
		if(person.getAppointmentId()!=null && person.getAppointmentId()>0){
			Appointment appoint=appoRepo.findByAppointmentId(person.getAppointmentId());
			appoint.setPersonId(p.getId());
			appoRepo.save(appoint);
		}
		person.getPerSecure().setPersonID(p.getId());
		perSecRepo.save(person.getPerSecure());
		return p;
	}
	
	/*private String randomQuestion(){
		String que="";
		PersonSecurity PerSecure =perSecRepo.findOne(7L);
		List<String> quest=new ArrayList<String>();
		if(PerSecure!=null){
			quest.add(PerSecure.getSecurityquestion1());
			quest.add(PerSecure.getSecurityquestion2());
			quest.add(PerSecure.getSecurityquestion3());
		
		Long rand=System.currentTimeMillis();
		System.out.println("time="+rand);
		int i=(int)(rand%3);
		System.out.println("time=i"+i);
		que=quest.get(i);
		
		}
		System.out.println("que="+que);
		return que;
	}*/	
	
	
	public List<Person> findAllPersons(){
		
		List<Person>  perlist =personRepo.findAll();
		/*for(Person pro:perlist){
			System.out.println("password==="+pro.getUserId());
			pro.setPassword(encriptService.encode(pro.getUserId()));
			personRepo.save(pro);
		}*/
		return perlist;
	}


	public Page<Person> findAllPersonsByPage(int pageno,int limit){
		return personRepo.findAll(new PageRequest(pageno,limit));
	}
	
	
	public List<Person> searchForPerson(String name){
		return personDao.searchForPerson(name);
	}
	
	public List<Person> searchForPersonDeep(String name,String userid,String govtIdtype,String govtId,Long mobile,String mailId,String dob){
		
		System.out.println("name="+name+"userid="+userid+"govtIdtype="+govtIdtype+"govtId"+govtId+"mobile="+mobile+"mailId="+mailId+"dob="+dob);
		List<Person>  perList=personDao.searchForPerson(name, userid, govtIdtype, govtId, mailId, formatDate(dob),mobile,formatnextDate(dob));
		for(Person p:perList){
			p.setDob(formatDate(p.getBirthday()));
		}
		System.out.println("perList size="+perList.size());
		return perList;
	}
	
	 public long getPersontSequenceId() {
		    	
	    	PerSeqId seq=new PerSeqId();
	    	List<PerSeqId> seqList = personSeqRepo.findAll();
	    	if(seqList==null || CollectionUtils.isEmpty(seqList) ){
	    		seq.setPersonseq(1L);
	    	}else{
	    		seq=seqList.get(0);
	    		seq.setPersonseq(seq.getPersonseq()+1);
	    		}
	    	personSeqRepo.save(seq);
	    	System.out.println("seqid==="+seq.getPersonseq());
	    	return seq.getPersonseq();
	}	
		 
	 private Date  formatDate(String datestr) {
			Date d=null;
			if(datestr==null) return null;
				try{
			      SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			      formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
				d=formatter.parse(datestr);
				}catch(Exception e){}

			return d;
    }
		 
	 private Date  formatnextDate(String datestr) {
		Date d=null;
		System.out.println("in date="+datestr);
		if(datestr==null){
			return null;
		}
		try{
			 SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			 sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
			 Calendar c = Calendar.getInstance();
			 c.setTime(sdf.parse(datestr));
			 c.add(Calendar.DATE, 1);  // number of days to add
			 d = c.getTime();
		}catch(Exception e){}
		
      	System.out.println("out date="+d);
					return d;
	}
		 
	 private String formatDate(Date date){
		 
			SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");
			DATE_FORMAT.setTimeZone(TimeZone.getTimeZone("UTC"));
	       return  DATE_FORMAT.format(date);
	}
	 
	/* private static CodeTable addCodetables(){
		 CodeTable codes=new CodeTable();
		 Collection<String> gendList=new TreeSet<String>();
			gendList.add("M");
			gendList.add("F");
			gendList.add("O");
		 codes.setGender(gendList);
			
		 Collection<String> raceList=new TreeSet<String>();
			raceList.add("Anglo Indian");
			raceList.add("Anglo American");
			raceList.add("Nigros");
			raceList.add("Canadian");
			raceList.add("American");
			codes.setRace(raceList);
			
			 Collection<String> govtIdList=new TreeSet<String>();
			govtIdList.add("Aadhar");
			govtIdList.add("SSN");
			govtIdList.add("PAN");
			govtIdList.add("Green Card");
			codes.setGovtId(govtIdList);
			
			 Collection<String> occupList=new TreeSet<String>();
			occupList.add("Teacher");
			occupList.add("Doctor");
			occupList.add("Engineer");
			occupList.add("Accountant");
			occupList.add("Student");
			occupList.add("Gardener");
			occupList.add("Cashier");
			occupList.add("Contracter");
			occupList.add("Marketing");
			occupList.add("Others");
			codes.setOccupation(occupList);
			
			List<String> provList=new ArrayList<String>();
			provList.add("Admin");
			provList.add("Doctor");
			provList.add("Nurse");
			provList.add("Lab Assistant");
			provList.add("Compounder");
			provList.add("Lab Technician");
			
			List<InstitutionType> instList=new ArrayList<InstitutionType>();
			InstitutionType hospinst=new InstitutionType();
			hospinst.setInstType("Hospital");
			TreeSet<String> hospRoles=new TreeSet<String>();
			 hospRoles.add("Admin");
			 hospRoles.add("Doctor");
			 hospRoles.add("Nurse");
			 hospRoles.add("Front Desk");
			 hospRoles.add("Assistant");
			 hospinst.setRoles(hospRoles);
			 instList.add(hospinst);
			 
			InstitutionType phrminst=new InstitutionType();
			phrminst.setInstType("Pharmacy");
			TreeSet<String> pharRoles=new TreeSet<String>();
			pharRoles.add("Admin");
			pharRoles.add("Assistant");
			pharRoles.add("Pharmacist");
			phrminst.setRoles(pharRoles);
			instList.add(phrminst);
			
			InstitutionType labinst=new InstitutionType();
			labinst.setInstType("Laboratory");
			TreeSet<String> labRoles=new TreeSet<String>();
			labRoles.add("Admin");
			labRoles.add("Assistant");
			labRoles.add("Technician");
			labinst.setRoles(labRoles);
			instList.add(labinst);
			codes.setInstType(instList);
			
			return codes;
	 }
*/
}
