package com.satya.core.dto;

import java.util.Date;

public class IllnessDto extends CreationDto{
    private Long illnessId;
    private Long diseaseId;
    private String diseasename;
    private Long encounterId;
    private boolean hospRelated;
    private boolean primary;
    private boolean principalProb;
    private Long providerId;
    private Long providername;
    private String provType;
    private Date startDtTm;
    private Date endDtTm;
    
	public String getDiseasename() {
		return diseasename;
	}
	public void setDiseasename(String diseasename) {
		this.diseasename = diseasename;
	}
	public Long getEncounterId() {
		return encounterId;
	}
	public void setEncounterId(Long encounterId) {
		this.encounterId = encounterId;
	}
	public boolean isHospRelated() {
		return hospRelated;
	}
	public void setHospRelated(boolean hospRelated) {
		this.hospRelated = hospRelated;
	}
	public boolean isPrimary() {
		return primary;
	}
	public void setPrimary(boolean primary) {
		this.primary = primary;
	}
	public boolean isPrincipalProb() {
		return principalProb;
	}
	public void setPrincipalProb(boolean principalProb) {
		this.principalProb = principalProb;
	}
	public Long getProviderId() {
		return providerId;
	}
	public void setProviderId(Long providerId) {
		this.providerId = providerId;
	}
	public Long getProvidername() {
		return providername;
	}
	public void setProvidername(Long providername) {
		this.providername = providername;
	}
	public Long getIllnessId() {
		return illnessId;
	}
	public void setIllnessId(Long illnessId) {
		this.illnessId = illnessId;
	}
	public Long getDiseaseId() {
		return diseaseId;
	}
	public void setDiseaseId(Long diseaseId) {
		this.diseaseId = diseaseId;
	}
	public String getProvType() {
		return provType;
	}
	public void setProvType(String provType) {
		this.provType = provType;
	}
	public Date getStartDtTm() {
		return startDtTm;
	}
	public void setStartDtTm(Date startDtTm) {
		this.startDtTm = startDtTm;
	}
	public Date getEndDtTm() {
		return endDtTm;
	}
	public void setEndDtTm(Date endDtTm) {
		this.endDtTm = endDtTm;
	}
	
}
