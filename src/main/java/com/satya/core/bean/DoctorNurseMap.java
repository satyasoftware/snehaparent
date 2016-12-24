package com.satya.core.bean;

import java.math.BigInteger;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="DOCTOR_NURSE_MAP")
public class DoctorNurseMap {

	@Id private BigInteger  mapId;
	    private Long doctorId;
	    private Long nurseId;
	    private Long instId;
	    private String status;
	    
	     private Date registerdate;
	     private Date updateddate;
	     private Long createdUserId;
	     private Long updateduserId;
	     
		
		public BigInteger getMapId() {
			return mapId;
		}
		public void setMapId(BigInteger mapId) {
			this.mapId = mapId;
		}
		public Long getDoctorId() {
			return doctorId;
		}
		public void setDoctorId(Long doctorId) {
			this.doctorId = doctorId;
		}
		public Long getNurseId() {
			return nurseId;
		}
		public void setNurseId(Long nurseId) {
			this.nurseId = nurseId;
		}
		public Long getInstId() {
			return instId;
		}
		public void setInstId(Long instId) {
			this.instId = instId;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public Date getRegisterdate() {
			return registerdate;
		}
		public void setRegisterdate(Date registerdate) {
			this.registerdate = registerdate;
		}
		public Date getUpdateddate() {
			return updateddate;
		}
		public void setUpdateddate(Date updateddate) {
			this.updateddate = updateddate;
		}
		public Long getCreatedUserId() {
			return createdUserId;
		}
		public void setCreatedUserId(Long createdUserId) {
			this.createdUserId = createdUserId;
		}
		public Long getUpdateduserId() {
			return updateduserId;
		}
		public void setUpdateduserId(Long updateduserId) {
			this.updateduserId = updateduserId;
		}
	
	
}
