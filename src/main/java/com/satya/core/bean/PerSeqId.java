package com.satya.core.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "persequence")
public class PerSeqId {
	@Id
	private String id;

	private Long personseq;
	
	private Long addressseq;
	
	private Long providerseq;
	private Long institutionseq;
	private Long provInstseq;
	private Long admReqId;
	private Long superadmId;
	
	private Long admReqCorrId;
	
	public Long getAdmReqCorrId() {
		return admReqCorrId;
	}

	public void setAdmReqCorrId(Long admReqCorrId) {
		this.admReqCorrId = admReqCorrId;
	}

	public Long getSuperadmId() {
		return superadmId;
	}

	public void setSuperadmId(Long superadmId) {
		this.superadmId = superadmId;
	}

	public Long getAdmReqId() {
		return admReqId;
	}

	public void setAdmReqId(Long admReqId) {
		this.admReqId = admReqId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getPersonseq() {
		return personseq;
	}

	public void setPersonseq(Long personseq) {
		this.personseq = personseq;
	}

	public Long getAddressseq() {
		return addressseq;
	}

	public void setAddressseq(Long addressseq) {
		this.addressseq = addressseq;
	}

	public Long getProviderseq() {
		return providerseq;
	}

	public void setProviderseq(Long providerseq) {
		this.providerseq = providerseq;
	}

	public Long getInstitutionseq() {
		return institutionseq;
	}

	public void setInstitutionseq(Long institutionseq) {
		this.institutionseq = institutionseq;
	}

	public Long getProvInstseq() {
		return provInstseq;
	}

	public void setProvInstseq(Long provInstseq) {
		this.provInstseq = provInstseq;
	}

	
 
}
