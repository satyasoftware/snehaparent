package com.satya.core.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.satya.core.beanLimit.ProviderL;

@Document(collection="CONSULT")
public class Consult extends Creation {
	@Id private Long consultId;
	private Long encounterId;
	private String consultDept;
	private ProviderL consultFrom; //session user
	private ProviderL consultTo; //hosp doctors 
	private String reason;
	private Boolean informed;
	private String provType;
	   
	public String getProvType() {
		return provType;
	}
	public void setProvType(String provType) {
		this.provType = provType;
	}
	public Long getConsultId() {
		return consultId;
	}
	public void setConsultId(Long consultId) {
		this.consultId = consultId;
	}
	public Long getEncounterId() {
		return encounterId;
	}
	public void setEncounterId(Long encounterId) {
		this.encounterId = encounterId;
	}
	public String getConsultDept() {
		return consultDept;
	}
	public void setConsultDept(String consultDept) {
		this.consultDept = consultDept;
	}
	public ProviderL getConsultFrom() {
		return consultFrom;
	}
	public void setConsultFrom(ProviderL consultFrom) {
		this.consultFrom = consultFrom;
	}
	public ProviderL getConsultTo() {
		return consultTo;
	}
	public void setConsultTo(ProviderL consultTo) {
		this.consultTo = consultTo;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Boolean getInformed() {
		return informed;
	}
	public void setInformed(Boolean informed) {
		this.informed = informed;
	}
	
	

}
