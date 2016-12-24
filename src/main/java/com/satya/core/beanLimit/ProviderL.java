package com.satya.core.beanLimit;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="PROVIDER")
public class ProviderL{

	@Id    private Long providerID;
	       private String userId;
	       private String govtIdType;
           private String govtId;
           private String firstname;
           private String middlename;
           private String lastname;
           private String email;
           private Long cell_number;
           
           @Transient
           private char attendingPhysician;
           
		public char getAttendingPhysician() {
			return attendingPhysician;
		}
		public void setAttendingPhysician(char attendingPhysician) {
			this.attendingPhysician = attendingPhysician;
		}
		public Long getProviderID() {
			return providerID;
		}
		public void setProviderID(Long providerID) {
			this.providerID = providerID;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getGovtIdType() {
			return govtIdType;
		}
		public void setGovtIdType(String govtIdType) {
			this.govtIdType = govtIdType;
		}
		public String getGovtId() {
			return govtId;
		}
		public void setGovtId(String govtId) {
			this.govtId = govtId;
		}
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getMiddlename() {
			return middlename;
		}
		public void setMiddlename(String middlename) {
			this.middlename = middlename;
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
		public Long getCell_number() {
			return cell_number;
		}
		public void setCell_number(Long cell_number) {
			this.cell_number = cell_number;
		}
           
           
           
}