package com.satya.core.bean;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.satya.core.beanLimit.ProviderL;
@Document(collection="ILLNESS")
public class Illness extends Creation{
	@Id private Long illnessId;
	    private Long diseaseId;
	    private Long encounterId;
	    private boolean hospRelated;
	    private boolean primary;
	    private boolean principalProb;
	    private Date startDtTm;
	    private Date endDtTm;
	    @DBRef private ProviderL provider;
	    @DBRef private Diseases disease;
	    private String provType;
	    
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
		public ProviderL getProvider() {
			return provider;
		}
		public void setProvider(ProviderL provider) {
			this.provider = provider;
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
		public Diseases getDisease() {
			return disease;
		}
		public void setDisease(Diseases disease) {
			this.disease = disease;
		}
		
}
