package com.satya.core.dto;

import java.util.Date;

public class LabTestDto extends CreationDto{
    private Long labTestId;
    private Long treatmentId;
    private String testOrder;
    private String testResult;
	private Date orderDtTm;
	private Date sampleCollDtTm;
	private Date receivedDtTm;
	private Date resultDtTm; 
	private Float price;
	private Boolean paid;
	private String resultDoc;//RESULT_DOC BLOB,
	private String resultFilm;//RESULT_FILM BLOB,
	private String resultVideo;
	public Long getLabTestId() {
		return labTestId;
	}
	public void setLabTestId(Long labTestId) {
		this.labTestId = labTestId;
	}
	public Long getTreatmentId() {
		return treatmentId;
	}
	public void setTreatmentId(Long treatmentId) {
		this.treatmentId = treatmentId;
	}
	public String getTestOrder() {
		return testOrder;
	}
	public void setTestOrder(String testOrder) {
		this.testOrder = testOrder;
	}
	public String getTestResult() {
		return testResult;
	}
	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}
	public Date getOrderDtTm() {
		return orderDtTm;
	}
	public void setOrderDtTm(Date orderDtTm) {
		this.orderDtTm = orderDtTm;
	}
	public Date getSampleCollDtTm() {
		return sampleCollDtTm;
	}
	public void setSampleCollDtTm(Date sampleCollDtTm) {
		this.sampleCollDtTm = sampleCollDtTm;
	}
	public Date getReceivedDtTm() {
		return receivedDtTm;
	}
	public void setReceivedDtTm(Date receivedDtTm) {
		this.receivedDtTm = receivedDtTm;
	}
	public Date getResultDtTm() {
		return resultDtTm;
	}
	public void setResultDtTm(Date resultDtTm) {
		this.resultDtTm = resultDtTm;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Boolean getPaid() {
		return paid;
	}
	public void setPaid(Boolean paid) {
		this.paid = paid;
	}
	public String getResultDoc() {
		return resultDoc;
	}
	public void setResultDoc(String resultDoc) {
		this.resultDoc = resultDoc;
	}
	public String getResultFilm() {
		return resultFilm;
	}
	public void setResultFilm(String resultFilm) {
		this.resultFilm = resultFilm;
	}
	public String getResultVideo() {
		return resultVideo;
	}
	public void setResultVideo(String resultVideo) {
		this.resultVideo = resultVideo;
	}
	
}
