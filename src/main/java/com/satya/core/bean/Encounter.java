package com.satya.core.bean;

import java.util.Collection;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.satya.core.beanLimit.PersonL;
import com.satya.core.beanLimit.ProviderL;

@Document(collection="ENCOUNTER")
public class Encounter {
	 @Id private Long encounterId;
	     private Long appointmentId;
	     private Long personId;
@NotNull  private Long instId;
@NotEmpty private String encounterType;
	     private String patientComplaint;
 @DateTimeFormat(pattern="MM/dd/yyyy HH:mm")
	     private Date startDtTm;
	     private Date endDtTm;
	     private Double price;
	     private char paid;// P-Paid,N-Not Paid, H-Half Paid
	     private char status;// O-Open, C-closed;
	     private String block;//ward,room,bedno,admissionNo
	     private String ward;
	     private String room;
	     private String bedno;
	     private String admissionNo;
	     private String encounterNumber;
	     private  boolean emergency;
		 private Date createTs;
	     private Date updateTs;
	     private Long createdUId;
	     private Long updateUId;
	     private Boolean treatstart; //true, false
	     
	     @Transient private Long preferedProvider;
	     @Transient private Treatment treatment;
	     @Transient private Long assignDoctor;
	     @Transient private Collection<String> docts;
		 @Transient private ProviderL attePhysiName;
		 @Transient private char attendingPhysician; //Y  ,  N
	     
	        @DBRef
		 	@Indexed
		 	private PersonL personL;
		
	        
	        
	        public char getAttendingPhysician() {
				return attendingPhysician;
			}
			public void setAttendingPhysician(char attendingPhysician) {
				this.attendingPhysician = attendingPhysician;
			}
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
			public Boolean getTreatstart() {
				return treatstart;
			}
			public void setTreatstart(Boolean treatstart) {
				this.treatstart = treatstart;
			}
			public boolean isEmergency() {
				return emergency;
			}
			public void setEmergency(boolean emergency) {
				this.emergency = emergency;
			}
			public String getEncounterNumber() {
				return encounterNumber;
			}
			public void setEncounterNumber(String encounterNumber) {
				this.encounterNumber = encounterNumber;
			}
			public String getBlock() {
				return block;
			}
			public void setBlock(String block) {
				this.block = block;
			}
			public String getWard() {
				return ward;
			}
			public void setWard(String ward) {
				this.ward = ward;
			}
			public String getRoom() {
				return room;
			}
			public void setRoom(String room) {
				this.room = room;
			}
			public String getBedno() {
				return bedno;
			}
			public void setBedno(String bedno) {
				this.bedno = bedno;
			}
			public String getAdmissionNo() {
				return admissionNo;
			}
			public void setAdmissionNo(String admissionNo) {
				this.admissionNo = admissionNo;
			}
			public PersonL getPersonL() {
				return personL;
			}
			public void setPersonL(PersonL personL) {
				this.personL = personL;
			}
		public Long getAssignDoctor() {
			return assignDoctor;
		}
		public void setAssignDoctor(Long assignDoctor) {
			this.assignDoctor = assignDoctor;
		}
		public Long getEncounterId() {
			return encounterId;
		}
		public void setEncounterId(Long encounterId) {
			this.encounterId = encounterId;
		}
		public Long getAppointmentId() {
			return appointmentId;
		}
		public void setAppointmentId(Long appointmentId) {
			this.appointmentId = appointmentId;
		}
		public Long getPersonId() {
			return personId;
		}
		public void setPersonId(Long personId) {
			this.personId = personId;
		}
		public Long getInstId() {
			return instId;
		}
		public void setInstId(Long instId) {
			this.instId = instId;
		}
		public String getEncounterType() {
			return encounterType;
		}
		public void setEncounterType(String encounterType) {
			this.encounterType = encounterType;
		}
		public String getPatientComplaint() {
			return patientComplaint;
		}
		public void setPatientComplaint(String patientComplaint) {
			this.patientComplaint = patientComplaint;
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
		public Double getPrice() {
			return price;
		}
		public void setPrice(Double price) {
			this.price = price;
		}
		public char getPaid() {
			return paid;
		}
		public void setPaid(char paid) {
			this.paid = paid;
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
		public Long getPreferedProvider() {
			return preferedProvider;
		}
		public void setPreferedProvider(Long preferedProvider) {
			this.preferedProvider = preferedProvider;
		}
		public Treatment getTreatment() {
			return treatment;
		}
		public void setTreatment(Treatment treatment) {
			this.treatment = treatment;
		}
	     
		
	     
}
