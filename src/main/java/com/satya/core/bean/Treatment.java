package com.satya.core.bean;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.satya.core.beanLimit.ProviderL;

@Document(collection="TREATMENT")
public class Treatment {
	@Id  private Long treatmentId;
	     private Long encounterId;
         private Long providerId;
         private Date createTs;
	     private Date updateTs;
	     private Long createdUId;
	     private Long updateUId;
	     private Long instId;
	     private Long patId;
	     private String encounterType;
	     private String providerType;
	     private char attendingPhysician; //Y  ,  N
         private char status;// O-Open, C-closed;
	     private char encounterStatus; //O or C
	     
	    @Transient private Collection<String> docts;
	    @Transient private ProviderL attePhysiName;
	   // @Transient private char attePhysi;
	    
	    @DBRef
	 	@Indexed
	 	private Encounter encounter;
	    
	    @DBRef
	 	@Indexed
	 	private ProviderL providerL; 
	    
	    
		/*public char getAttePhysi() {
			return attePhysi;
		}
		public void setAttePhysi(char attePhysi) {
			this.attePhysi = attePhysi;
		}*/
		public Collection<String> getDocts() {
			return docts;
		}
		public void setDocts(Collection<String> docts) {
			this.docts = docts;
		}
		public ProviderL getAttePhysiName() {
			return attePhysiName;
		}
		public void setAttePhysiName(ProviderL attePhysiName) {
			this.attePhysiName = attePhysiName;
		}
		public String getProviderType() {
			return providerType;
		}
		public void setProviderType(String providerType) {
			this.providerType = providerType;
		}
		public char getEncounterStatus() {
			return encounterStatus;
		}
		public void setEncounterStatus(char encounterStatus) {
			this.encounterStatus = encounterStatus;
		}
		public String getEncounterType() {
			return encounterType;
		}
		public void setEncounterType(String encounterType) {
			this.encounterType = encounterType;
		}
		public ProviderL getProviderL() {
			return providerL;
		}
		public void setProviderL(ProviderL providerL) {
			this.providerL = providerL;
		}
		public Encounter getEncounter() {
			return encounter;
		}
		public void setEncounter(Encounter encounter) {
			this.encounter = encounter;
		}
		public Long getInstId() {
			return instId;
		}
		public void setInstId(Long instId) {
			this.instId = instId;
		}
		public Long getPatId() {
			return patId;
		}
		public void setPatId(Long patId) {
			this.patId = patId;
		}
		public Long getTreatmentId() {
			return treatmentId;
		}
		public void setTreatmentId(Long treatmentId) {
			this.treatmentId = treatmentId;
		}
		public Long getEncounterId() {
			return encounterId;
		}
		public void setEncounterId(Long encounterId) {
			this.encounterId = encounterId;
		}
		public Long getProviderId() {
			return providerId;
		}
		public void setProviderId(Long providerId) {
			this.providerId = providerId;
		}
		public char getAttendingPhysician() {
			return attendingPhysician;
		}
		public void setAttendingPhysician(char attendingPhysician) {
			this.attendingPhysician = attendingPhysician;
		}
		
		public char getStatus() {
			return status;
		}
		public void setStatus(char status) {
			this.status = status;
		}
		public Date getCreateTs() {
			return createTs;
		}
		public void setCreateTs(Date createTs) {
			this.createTs = createTs;
		}
		public Date getUpdateTs() {
			return updateTs;
		}
		public void setUpdateTs(Date updateTs) {
			this.updateTs = updateTs;
		}
		public Long getCreatedUId() {
			return createdUId;
		}
		public void setCreatedUId(Long createdUId) {
			this.createdUId = createdUId;
		}
		public Long getUpdateUId() {
			return updateUId;
		}
		public void setUpdateUId(Long updateUId) {
			this.updateUId = updateUId;
		}
	     
}
