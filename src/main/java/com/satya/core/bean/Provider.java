package com.satya.core.bean;

import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection="PROVIDER")
public class Provider extends Address{

	@Id                      private Long providerID;
	@Size(min = 4, max = 15) private String userId;
	@JsonIgnore private String password;
	                         private String govtIdType;
                             private String govtId;
                             private String providerType;
                             private String regNo;
    @DateTimeFormat(pattern="MM/dd/yyyy") private Date regDate;
                             private String regDept;
    @Size(min = 4, max = 15) private String firstname;
    						 private String middlename;
    @Size(min = 4, max = 15) private String lastname;
    @JsonFormat(pattern="yyyy-MM-dd") 
    @NotNull @DateTimeFormat(pattern="MM/dd/yyyy")private Date birthday;
    @NotEmpty                private String gender;
    @NotEmpty @Email         private String email;
    @NotNull @Digits(integer=10,fraction=0) private Long cell_number;
                             private Long homephone_number;
                             private boolean status;
                             
						     private Date registerdate;
						     private Date updateddate;
						     private Long createdUserId;
						     private Long updateduserId;
						     @Transient private String newpassword;
						     @Transient private String confirmpassword;
						     
						    
						     //@Transient private String birthdate;
						     //@Transient
						     private String regdate;
						     @Transient
						     private boolean modifyAddress;
						     @Transient private ProviderSecurity proSecure;
						   
						     
						     
						    
							public ProviderSecurity getProSecure() {
								return proSecure;
							}
							public void setProSecure(ProviderSecurity proSecure) {
								this.proSecure = proSecure;
							}
							public String getNewpassword() {
								return newpassword;
							}
							public void setNewpassword(String newpassword) {
								this.newpassword = newpassword;
							}
							public String getConfirmpassword() {
								return confirmpassword;
							}
							public void setConfirmpassword(String confirmpassword) {
								this.confirmpassword = confirmpassword;
							}
							public boolean isModifyAddress() {
								return modifyAddress;
							}
							public void setModifyAddress(boolean modifyAddress) {
								this.modifyAddress = modifyAddress;
							}
							public String getRegdate() {
								return regdate;
							}
							public void setRegdate(String regdate) {
								this.regdate = regdate;
							}
							/*public String getBirthdate() {
								return birthdate;
							}
							public void setBirthdate(String birthdate) {
								this.birthdate = birthdate;
							}*/
							public Provider(){}
						     public Provider(Long providerID, String firstname) {
						    	 this.providerID=providerID;
						    	 this.firstname=firstname;
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
							public String getPassword() {
								return password;
							}
							public void setPassword(String password) {
								this.password = password;
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
							
							public String getProviderType() {
								return providerType;
							}
							public void setProviderType(String providerType) {
								this.providerType = providerType;
							}
							public String getRegNo() {
								return regNo;
							}
							public void setRegNo(String regNo) {
								this.regNo = regNo;
							}
							public Date getRegDate() {
								return regDate;
							}
							public void setRegDate(Date regDate) {
								this.regDate = regDate;
							}
							public String getRegDept() {
								return regDept;
							}
							public void setRegDept(String regDept) {
								this.regDept = regDept;
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
							public Date getBirthday() {
								return birthday;
							}
							public void setBirthday(Date birthday) {
								this.birthday = birthday;
							}
							public String getGender() {
								return gender;
							}
							public void setGender(String gender) {
								this.gender = gender;
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
							public Long getHomephone_number() {
								return homephone_number;
							}
							public void setHomephone_number(Long homephone_number) {
								this.homephone_number = homephone_number;
							}
							public boolean isStatus() {
								return status;
							}
							public void setStatus(boolean status) {
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
							/*public List<Long> getAddresses() {
								return addresses;
							}
							public void setAddresses(List<Long> addresses) {
								this.addresses = addresses;
							}
							public Address getAddress() {
								return address;
							}
							public void setAddress(Address address) {
								this.address = address;
							}
						     */
						     
						     
						     
}
