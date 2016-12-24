package com.satya.core.bean;

import java.util.Collection;

public class SessionUser {

	private Long userId;
	private String firstname;
	private String lastname;
	private String email;
	private Long mobile;
	private String usertype;
	private String role;
	private String provType;
	private Long provInstId;
	private Long instId;
	private String instType;
	private String instProvType;
	private Collection<Long> nurseDocts;
	private String ward;
	
	private SessionPatient sessionPat;
	
	public SessionPatient getSessionPat() {
		return sessionPat;
	}
	public void setSessionPat(SessionPatient sessionPat) {
		this.sessionPat = sessionPat;
	}
	
	public String getInstProvType() {
		return instProvType;
	}
	public void setInstProvType(String instProvType) {
		this.instProvType = instProvType;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public Collection<Long> getNurseDocts() {
		return nurseDocts;
	}
	public void setNurseDocts(Collection<Long> nurseDocts) {
		this.nurseDocts = nurseDocts;
	}
	public String getProvType() {
		return provType;
	}
	public void setProvType(String provType) {
		this.provType = provType;
	}
	
	public Long getProvInstId() {
		return provInstId;
	}
	public void setProvInstId(Long provInstId) {
		this.provInstId = provInstId;
	}
	public Long getInstId() {
		return instId;
	}
	public void setInstId(Long instId) {
		this.instId = instId;
	}
	
	public String getInstType() {
		return instType;
	}
	public void setInstType(String instType) {
		this.instType = instType;
	}
	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/*public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}*/
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
