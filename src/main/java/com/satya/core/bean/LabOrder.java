package com.satya.core.bean;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.satya.core.beanLimit.ProviderL;

@Document(collection="LABORDER")
public class LabOrder extends Creation{
	@Id private Long labOrderId;
    private Long encounterId;
    private String testName;
    private String priority; // Routine/static
    private String specimen;  //blood,urine etc for non radiology tests
    private Date testTime;
    private String specimenDirection;    //obtain speciman 
    private String comments;
    //for radiology related
    private String testType; //labtest,radiology,ukg(others) need to fill at the time of creation
    private String reason;// for radiology tests
    @DBRef
    private ProviderL providerL;
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
	public Long getLabOrderId() {
		return labOrderId;
	}
	public void setLabOrderId(Long labOrderId) {
		this.labOrderId = labOrderId;
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
	public ProviderL getProviderL() {
		return providerL;
	}
	public void setProviderL(ProviderL providerL) {
		this.providerL = providerL;
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
