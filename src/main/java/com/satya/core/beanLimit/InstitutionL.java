package com.satya.core.beanLimit;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="INSTITUTION")
public class InstitutionL {
     @Id  private Long instId;
		  private String instName;
		  private String regNo;
		  private String email;
		  private Long phone1;
		  private String instType;
		  
		public String getInstType() {
			return instType;
		}
		public void setInstType(String instType) {
			this.instType = instType;
		}
		public Long getInstId() {
			return instId;
		}
		public void setInstId(Long instId) {
			this.instId = instId;
		}
		public String getInstName() {
			return instName;
		}
		public void setInstName(String instName) {
			this.instName = instName;
		}
		public String getRegNo() {
			return regNo;
		}
		public void setRegNo(String regNo) {
			this.regNo = regNo;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public Long getPhone1() {
			return phone1;
		}
		public void setPhone1(Long phone1) {
			this.phone1 = phone1;
		}
		  
}
