package com.satya.core.bean;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
//import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.satya.core.beanLimit.PersonL;
import com.satya.core.beanLimit.ProviderL;


@Document(collection="APPOINTMENT")
public class Appointment {
 @Id private Long appointmentId;
     private Long personId;
     private String firstName;
     private String lastName;
     private Long personmobile;
     private Long instId;
@NotEmpty   private String appointmentType;
     private String patientComplaint;
 @NotNull
 @DateTimeFormat(pattern="MM/dd/yyyy HH:mm")
     private Date  startDtTm;
     private Date endDtTm;
     private char status;// O-Open,C-closed;
	 private Date createTs;
     private Date updateTs;
     private Long createdUId;
     private Long updateUId;
     private Long preferedProvider;
     private String appointFor;
    @Transient
    @DateTimeFormat(pattern="MM/dd/yyyy") private Date searchDate;  
     
     @Transient
     private Boolean scheduleStatus;
     
     @Transient
     private Person person;
     
     @Transient
     private Provider provider;
     
     @DBRef
     @Indexed
     private PersonL personL;
   
     @DBRef
     @Indexed
     private ProviderL providerL;
     
     
	public PersonL getPersonL() {
		return personL;
	}

	public void setPersonL(PersonL personL) {
		this.personL = personL;
	}

	public ProviderL getProviderL() {
		return providerL;
	}

	public void setProviderL(ProviderL providerL) {
		this.providerL = providerL;
	}

	public Boolean getScheduleStatus() {
		return scheduleStatus;
	}

	public void setScheduleStatus(Boolean scheduleStatus) {
		this.scheduleStatus = scheduleStatus;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		this.provider = provider;
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
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Long getPersonmobile() {
		return personmobile;
	}
	public void setPersonmobile(Long personmobile) {
		this.personmobile = personmobile;
	}
	public Long getInstId() {
		return instId;
	}
	public void setInstId(Long instId) {
		this.instId = instId;
	}
	public String getAppointmentType() {
		return appointmentType;
	}
	public void setAppointmentType(String appointmentType) {
		this.appointmentType = appointmentType;
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
	public String getAppointFor() {
		return appointFor;
	}
	public void setAppointFor(String appointFor) {
		this.appointFor = appointFor;
	}

	public Date getSearchDate() {
		return searchDate;
	}

	public void setSearchDate(Date searchDate) {
		this.searchDate = searchDate;
	}
     
     
     
}
