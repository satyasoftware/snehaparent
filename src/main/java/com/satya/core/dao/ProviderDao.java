package com.satya.core.dao;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

import com.satya.core.bean.Institution;
import com.satya.core.bean.Person;
import com.satya.core.bean.Provider;

public interface ProviderDao {

	public List<Provider> searchForProvider(String name);
	public List<Provider> searchForProviderByReg(String regNo);
	public Collection<Provider> getInstProviders(Collection<Long> proIds);
	
	public Provider findProvider(Long proId);
	public Person findPerson(Long personId);
	
	public List<Institution> searchForInstitution(String instname,String instType);
	
	public BigInteger getMaxDoctNurseMapId();
}
