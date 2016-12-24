package com.satya.core.dto;
public class ConsultDto extends CreationDto {
	    private Long consultId;
	    private Long encounterId;
		private String consultDept;
		private String consultFrom; //session user
		private Long fromPhysician;
		private String consultTo; //hosp doctors 
		private Long toPhysician;
		private String reason;
		private Boolean informed;
		private String provType;
		   
		public String getProvType() {
			return provType;
		}
		public void setProvType(String provType) {
			this.provType = provType;
		}
		public Long getConsultId() {
			return consultId;
		}
		public void setConsultId(Long consultId) {
			this.consultId = consultId;
		}
		public Long getEncounterId() {
			return encounterId;
		}
		public void setEncounterId(Long encounterId) {
			this.encounterId = encounterId;
		}
		public String getConsultDept() {
			return consultDept;
		}
		public void setConsultDept(String consultDept) {
			this.consultDept = consultDept;
		}
		public String getConsultFrom() {
			return consultFrom;
		}
		public void setConsultFrom(String consultFrom) {
			this.consultFrom = consultFrom;
		}
		public Long getFromPhysician() {
			return fromPhysician;
		}
		public void setFromPhysician(Long fromPhysician) {
			this.fromPhysician = fromPhysician;
		}
		public String getConsultTo() {
			return consultTo;
		}
		public void setConsultTo(String consultTo) {
			this.consultTo = consultTo;
		}
		public Long getToPhysician() {
			return toPhysician;
		}
		public void setToPhysician(Long toPhysician) {
			this.toPhysician = toPhysician;
		}
		public String getReason() {
			return reason;
		}
		public void setReason(String reason) {
			this.reason = reason;
		}
		public Boolean getInformed() {
			return informed;
		}
		public void setInformed(Boolean informed) {
			this.informed = informed;
		}
		
		
}
