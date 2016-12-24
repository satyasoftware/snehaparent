package com.satya.core.beanLimit;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class EncounterL {
	 @Id private Long encounterId;
	     private Long appointmentId;
	     private Date startDtTm;
	     private String encounterType;
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
		public Date getStartDtTm() {
			return startDtTm;
		}
		public void setStartDtTm(Date startDtTm) {
			this.startDtTm = startDtTm;
		}
		public String getEncounterType() {
			return encounterType;
		}
		public void setEncounterType(String encounterType) {
			this.encounterType = encounterType;
		}
	     
}
