package com.satya.core.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class LabOrderDto extends CreationDto {
	private Long labTestId;
	//encounterId testName priority specimen testTime specimenDirection comments reason
	@NotNull private Long encounterId;
	@NotEmpty private String testName;
	          private String testNamelist;
	@NotEmpty private String priority; // Routine/static
    private String specimen;  //blood,urine etc for non radiology tests
    @NotNull @DateTimeFormat(pattern="MM/dd/yyyy HH:mm") private Date testTime;
    private String specimenDirection;    //obtain speciman 
    private String comments;
    //for radiology related
    private String testType; //labtest,radiology,ukg(others) need to fill at the time of creation
    private String reason;// for radiology tests
    private Long provider;
    
    private String provType;
    private Long approvedProvider;
    private String ordStatus;
    
    private String  bodypart;
    private String modality;
    
	public String getBodypart() {
		return bodypart;
	}
	public void setBodypart(String bodypart) {
		this.bodypart = bodypart;
	}
	public String getModality() {
		return modality;
	}
	public void setModality(String modality) {
		this.modality = modality;
	}
	public String getTestNamelist() {
		return testNamelist;
	}
	public void setTestNamelist(String testNamelist) {
		this.testNamelist = testNamelist;
	}
	public Long getLabTestId() {
		return labTestId;
	}
	public void setLabTestId(Long labTestId) {
		this.labTestId = labTestId;
	}
	public Long getEncounterId() {
		return encounterId;
	}
	public void setEncounterId(Long encounterId) {
		this.encounterId = encounterId;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getSpecimen() {
		return specimen;
	}
	public void setSpecimen(String specimen) {
		this.specimen = specimen;
	}
	public Date getTestTime() {
		return testTime;
	}
	public void setTestTime(Date testTime) {
		this.testTime = testTime;
	}
	public String getSpecimenDirection() {
		return specimenDirection;
	}
	public void setSpecimenDirection(String specimenDirection) {
		this.specimenDirection = specimenDirection;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getTestType() {
		return testType;
	}
	public void setTestType(String testType) {
		this.testType = testType;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Long getProvider() {
		return provider;
	}
	public void setProvider(Long provider) {
		this.provider = provider;
	}
	public String getProvType() {
		return provType;
	}
	public void setProvType(String provType) {
		this.provType = provType;
	}
	public Long getApprovedProvider() {
		return approvedProvider;
	}
	public void setApprovedProvider(Long approvedProvider) {
		this.approvedProvider = approvedProvider;
	}
	public String getOrdStatus() {
		return ordStatus;
	}
	public void setOrdStatus(String ordStatus) {
		this.ordStatus = ordStatus;
	}  
}
