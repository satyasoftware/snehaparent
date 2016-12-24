package com.satya.core.bean;

import java.util.Date;

public class SessionPatient {

   private	Long enconterId;
   //pat hospital info
   private String block;//ward,room,bedno,admissionNo
   private String ward;
   private String room;
   private String bedno;
   private String admissionNo;
   private String encounterNumber;
   private Float weight;
   //pat personal info
   private String patname;
   private Date patDob;
   private String gender;
   private int age;
   
   private Date encoDate;
   //pat vital info
   private float temperature;
   private String bp;
   private int pulse;
   
   
	public String getEncounterNumber() {
	     return encounterNumber;
	}
	
	public void setEncounterNumber(String encounterNumber) {
		this.encounterNumber = encounterNumber;
	}

	public String getAdmissionNo() {
	    return admissionNo;
	}
	
	public void setAdmissionNo(String admissionNo) {
		this.admissionNo = admissionNo;
	}
	
	public Float getWeight() {
		return weight;
	}
	
	public void setWeight(Float weight) {
		this.weight = weight;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public Long getEnconterId() {
		return enconterId;
	}
	
	public void setEnconterId(Long enconterId) {
		this.enconterId = enconterId;
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

	public String getPatname() {
		return patname;
	}

	public void setPatname(String patname) {
		this.patname = patname;
	}

	public Date getPatDob() {
		return patDob;
	}

	public void setPatDob(Date patDob) {
		this.patDob = patDob;
	}

	public Date getEncoDate() {
		return encoDate;
	}

	public void setEncoDate(Date encoDate) {
		this.encoDate = encoDate;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public String getBp() {
		return bp;
	}

	public void setBp(String bp) {
		this.bp = bp;
	}

	public int getPulse() {
		return pulse;
	}

	public void setPulse(int pulse) {
		this.pulse = pulse;
	}
	
	
	
}
