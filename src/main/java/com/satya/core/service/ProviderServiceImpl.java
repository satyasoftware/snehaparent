package com.satya.core.service;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.satya.core.bean.CodeTable;
import com.satya.core.bean.InstitutionType;
import com.satya.core.bean.PerSeqId;
import com.satya.core.bean.Provider;
import com.satya.core.repo.CodetablesRepo;
import com.satya.core.repo.PersonSeqRepo;
import com.satya.core.repo.ProviderRepo;
import com.satya.core.repo.ProviderSecurityRepo;

@Service("providerService")
//@Transactional(readOnly = true)
public class ProviderServiceImpl implements ProviderService {
   @Autowired
	private ProviderRepo providerRepo;
    @Autowired
	private ProviderSecurityRepo ProvSecuRepo;
	@Autowired
	private PersonSeqRepo personSeqRepo;
	
	@Autowired
	private CodetablesRepo codetableRepo;
	@Autowired
	private EncriptionService encriptionService;
	
	@Override
	public Provider findByUserIdAndPassword(String userId,String userpass){
		System.out.println("in provider service findByUserIdAndPassword");
		userpass=encriptionService.encode(userpass);
		Provider pers=providerRepo.findByUserIdAndPassword(userId,userpass);
	return pers;
	}	
	
	
	@Override
	public Provider save(Provider provider){
	
	provider.setProviderID(getProviderSequenceId());
	provider.setPassword(encriptionService.encode(provider.getPassword()));
	Provider p=providerRepo.save(provider);
	provider.getProSecure().setProviderID(p.getProviderID());
	ProvSecuRepo.save(provider.getProSecure());
	return p;
}
	
	@Override
	public Provider update(Provider provider){
	provider.setUpdateddate(new Date());
	provider.setUpdateduserId(provider.getProviderID());
	
	Provider p=providerRepo.save(provider);
	
	return p;
}

	@Override
	public Provider findProviderById(Long provId){
		Provider pro= providerRepo.findByProviderID(provId);
		//if(needaddress){
		//List<Long> address=pro.getAddresses();
		//Address add=new Address();
		//if(address!=null)
			// add=addressRepo.findById(address.get(address.size()-1));
		
		//pro.setAddress(add);
		//}
		//pro.setBirthdate(formatDate(pro.getBirthday()));
		pro.setRegdate(formatDate(pro.getRegDate()));
		return pro;
	}
	
	private String formatDate(Date date){
			SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");
	       return  DATE_FORMAT.format(date);
	}
	
/*	private Date  formatDate(String datestr) {
		Date d=null;
		if(datestr==null) return null;
			try{
		      SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
			d=formatter.parse(datestr);
			}catch(Exception e){}

		return d;
}*/
	
	@Override
public List<Provider> findAllProviders(){
	return providerRepo.findAll();
}

	@Override
	public CodeTable findAllCodes(){
	/*List<CodeTable> codetables=codetableRepo.findAll();
	//if(gendList!=null) 
	CodeTable codes=codetables.get(0);*/
		return CodeTable.getInstance();
	}

	public Collection<String> findInstRoles(String instType){
		CodeTable cod=findAllCodes();
		Collection<InstitutionType> instTypes=cod.getInstType();
		Collection<String> roles= new TreeSet<String>();
		for(InstitutionType inType:instTypes){
			if(inType.getInstType().equalsIgnoreCase(instType)){
				roles=inType.getRoles();
			}
		}
		return roles;
	}

	
	@Override
	public Provider findProviderByUserId(String userId){
		return providerRepo.findByUserId(userId);
	}
	
	@Override
	public Provider findProviderByGovtIdAndType(String govtId,String govtIdType){
		return providerRepo.findByGovtIdAndGovtIdType(govtId,govtIdType);
	}
	@Override
	public Page<Provider> searchForProvider(String firstname,String lastname,String zip,String address1,String province,String city,int pageno,int limit){
		System.out.println("firstname"+firstname+"lastname"+lastname+"zip"+zip+"address1"+address1+"province"+province+"city"+city);
		Page<Provider> proList=null;
		
		
		if(firstname!=null && firstname !="" && lastname!=null && lastname !="" && zip!=null && zip !="" && zip.length()>2) {
			System.out.println("Name zip");
			proList= providerRepo.findByFirstnameLikeIgnoringCaseAndLastnameLikeIgnoringCaseAndZip(firstname,lastname, zip, new PageRequest(pageno,limit));
		}else if(firstname!=null && firstname !="" && zip!=null && zip !="" && zip.length()>2) {
			System.out.println("Name zip");
			proList= providerRepo.findByFirstnameLikeIgnoringCaseAndZip(firstname, zip, new PageRequest(pageno,limit));
		}
		else if(lastname!=null && lastname !="" && zip!=null && zip !="" && zip.length()>2) {
			System.out.println("Name zip");
			proList= providerRepo.findByLastnameLikeIgnoringCaseAndZip(lastname, zip, new PageRequest(pageno,limit));
		}
		else if(firstname!=null && firstname !="" && lastname!=null && lastname !="" && address1!="" && address1!=null && province!="" && province!=null && city !=null){ 
			System.out.println("Name address1 province city");
			proList =providerRepo.findByFirstnameLikeIgnoringCaseAndLastnameLikeIgnoringCaseAndAddress1LikeIgnoringCaseAndProvinceAndCity(firstname,lastname, address1, province, city,new PageRequest(pageno,limit));
		}else if(firstname!=null && firstname !=""  && address1!="" && address1!=null && province!="" && province!=null && city !=null){ 
			System.out.println("Name address1 province city");
			proList =providerRepo.findByFirstnameLikeIgnoringCaseAndAddress1LikeIgnoringCaseAndProvinceAndCity(firstname, address1, province, city,new PageRequest(pageno,limit));
		}
	     else if(lastname!=null && lastname !="" && address1!="" && address1!=null && province!="" && province!=null && city !=null) {
				System.out.println("Name  province city");
				proList= providerRepo.findByLastnameLikeIgnoringCaseAndAddress1LikeIgnoringCaseAndProvinceAndCity(lastname, address1, province, city, new PageRequest(pageno,limit));//(instName, address1, province,city,new PageRequest(pageno,limit));
		}
		else if(firstname!=null && firstname !="" && lastname!=null && lastname !="" &&  province!="" && province!=null && city !=null){ 
				System.out.println("Name address1 province city");
				proList =providerRepo.findByFirstnameLikeIgnoringCaseAndLastnameLikeIgnoringCaseAndProvinceAndCity(firstname, lastname, province, city,new PageRequest(pageno,limit));
			}
				else if(firstname!=null && firstname !="" && province!="" && province!=null && city !=null) {
					System.out.println("Name  province city");
					proList= providerRepo.findByFirstnameLikeIgnoringCaseAndProvinceAndCity(firstname, province, city, new PageRequest(pageno,limit));//(instName, address1, province,city,new PageRequest(pageno,limit));
				}
				else if(lastname!=null && lastname !="" && province!="" && province!=null && city !=null) {
					System.out.println("Name  province city");
					proList= providerRepo.findByLastnameLikeIgnoringCaseAndProvinceAndCity(lastname, province, city, new PageRequest(pageno,limit));//(instName, address1, province,city,new PageRequest(pageno,limit));
				}
		
	return proList;
	}
	
public long getProviderSequenceId() {
   	
   	PerSeqId seq=new PerSeqId();
   	List<PerSeqId> seqList = personSeqRepo.findAll();
   	if(seqList==null || CollectionUtils.isEmpty(seqList) ){
   		seq.setProviderseq(1L);
   	}else{
   		seq=seqList.get(0);
   		seq.setProviderseq(seq.getProviderseq()+1);
   		}
   	personSeqRepo.save(seq);
   	System.out.println("seqid==="+seq.getProviderseq());
   	return seq.getProviderseq();

     }	
public long getAddressSequenceId() {
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
   	return  seq.getAddressseq();
}
}