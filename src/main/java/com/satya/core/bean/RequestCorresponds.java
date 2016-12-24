package com.satya.core.bean;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="REQUESTCORRESPONDINGS")
public class RequestCorresponds {
	@Id private Long corresId;
	private Long admReqId;
	private Long instId;
	private String toaddress;
	private String fromaddress;
	private String subject;
	private String mailbody;
	private String description;
	private Date corrdate;
	private String admReqStatus;
	
	
	public String getAdmReqStatus() {
		return admReqStatus;
	}
	public void setAdmReqStatus(String admReqStatus) {
		this.admReqStatus = admReqStatus;
	}
	public Long getInstId() {
		return instId;
	}
	public void setInstId(Long instId) {
		this.instId = instId;
	}
	
	
	public Date getCorrdate() {
		return corrdate;
	}
	public void setCorrdate(Date corrdate) {
		this.corrdate = corrdate;
	}
	public Long getCorresId() {
		return corresId;
	}
	public void setCorresId(Long corresId) {
		this.corresId = corresId;
	}
	public Long getAdmReqId() {
		return admReqId;
	}
	public void setAdmReqId(Long admReqId) {
		this.admReqId = admReqId;
	}
	public String getToaddress() {
		return toaddress;
	}
	public void setToaddress(String toaddress) {
		this.toaddress = toaddress;
	}
	public String getFromaddress() {
		return fromaddress;
	}
	public void setFromaddress(String fromaddress) {
		this.fromaddress = fromaddress;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMailbody() {
		return mailbody;
	}
	public void setMailbody(String mailbody) {
		this.mailbody = mailbody;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
