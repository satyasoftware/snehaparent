package com.satya.core.service;
import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;

import com.satya.core.bean.CodeTable;
import com.satya.core.bean.Provider;

public interface ProviderService {
public Provider findByUserIdAndPassword(String userId,String userpass);
	
	public Provider save(Provider provider);
	public List<Provider> findAllProviders();
	public Collection<String> findInstRoles(String instType);
	public CodeTable findAllCodes();
	
    public Provider findProviderByUserId(String userId);
	
	public Provider findProviderByGovtIdAndType(String govtId,String govtIdType);
	
	public Provider findProviderById(Long provId);
	public Provider update(Provider provider);
	public Page<Provider> searchForProvider(String firstname,String lastname,String zip,String address1,String province,String city,int pageno,int limit);
}
