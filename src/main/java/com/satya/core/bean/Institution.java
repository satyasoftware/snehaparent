package com.satya.core.bean;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="INSTITUTION")
public class Institution extends Address {
@Id                private Long instId;
@Size(min = 4, max = 50) private String instName;
                        private String providerType;
@NotNull               private String regNo;
					   private Date regDate;
@NotNull               private String regDept;
					   private Date startDate;
					   private Date endDate;
					   private String instType;
@Size(min = 4, max = 50) private String nearLandmark;
@NotEmpty @Email        private String email;
@NotNull @Digits(integer=10,fraction=0)private Long phone1;
					   private Long phone2;
					   private Long fax;
					   //private String country;
@NotEmpty			   private String contactPerson;
@NotNull @Digits(integer=10,fraction=0)private Long contPersonPhone;
@NotEmpty @Email       private String contPersonEmail;
					   private Boolean feePaid;
					   private Boolean status;
					   private Date createdDate;
					   private Date updatedDate;
					   private Long createdUserId;
					   private Long updateduserId;
					   private String timezone;
					   private Boolean onlineschedule;
		    @Transient private Department department;
				       private Collection<Department> departments;	   
		    @Transient private Boolean deptAddStatus;	   
			@Transient private String startday;
			//@Transient private String regday;
					   
			@Transient private Long providerId;
			@Transient private Ward ward;
				       private Collection<Ward> wards;		 
				       
					   public Ward getWard() {
						return ward;
					}
					public void setWard(Ward ward) {
						this.ward = ward;
					}
					public Collection<Ward> getWards() {
						return wards;
					}
					public void setWards(Collection<Ward> wards) {
						this.wards = wards;
					}
					public Boolean getDeptAddStatus() {
						return deptAddStatus;
					}
					public void setDeptAddStatus(Boolean deptAddStatus) {
						this.deptAddStatus = deptAddStatus;
					}
					public Department getDepartment() {
						return department;
					}
					public void setDepartment(Department department) {
						this.department = department;
					}
					
					
					
					public Collection<Department> getDepartments() {
						return departments;
					}
					public void setDepartments(Collection<Department> departments) {
						this.departments = departments;
					}



					private List<Long> providerList;
					   @Transient
					   private Boolean modifyAddress=false; 
					
					public String getTimezone() {
						return timezone;
					}
					public void setTimezone(String timezone) {
						this.timezone = timezone;
					}
					
					public Boolean getModifyAddress() {
						return modifyAddress;
					}
					public void setModifyAddress(Boolean modifyAddress) {
						this.modifyAddress = modifyAddress;
					}
					public String getStartday() {
						return startday;
					}
					public void setStartday(String startday) {
						this.startday = startday;
					}
					/*public String getRegday() {
						return regday;
					}
					public void setRegday(String regday) {
						this.regday = regday;
					}*/
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
					public String getProviderType() {
						return providerType;
					}
					public void setProviderType(String providerType) {
						this.providerType = providerType;
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
					public Date getStartDate() {
						return startDate;
					}
					public void setStartDate(Date startDate) {
						this.startDate = startDate;
					}
					public Date getEndDate() {
						return endDate;
					}
					public void setEndDate(Date endDate) {
						this.endDate = endDate;
					}
					public String getInstType() {
						return instType;
					}
					public void setInstType(String instType) {
						this.instType = instType;
					}
					public String getNearLandmark() {
						return nearLandmark;
					}
					public void setNearLandmark(String nearLandmark) {
						this.nearLandmark = nearLandmark;
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
					public Long getPhone2() {
						return phone2;
					}
					public void setPhone2(Long phone2) {
						this.phone2 = phone2;
					}
					public Long getFax() {
						return fax;
					}
					public void setFax(Long fax) {
						this.fax = fax;
					}
					public String getContactPerson() {
						return contactPerson;
					}
					public void setContactPerson(String contactPerson) {
						this.contactPerson = contactPerson;
					}
					public Long getContPersonPhone() {
						return contPersonPhone;
					}
					public void setContPersonPhone(Long contPersonPhone) {
						this.contPersonPhone = contPersonPhone;
					}
					public String getContPersonEmail() {
						return contPersonEmail;
					}
					public void setContPersonEmail(String contPersonEmail) {
						this.contPersonEmail = contPersonEmail;
					}
					public Boolean getFeePaid() {
						return feePaid;
					}
					public void setFeePaid(Boolean feePaid) {
						this.feePaid = feePaid;
					}
					public Boolean getStatus() {
						return status;
					}
					public void setStatus(Boolean status) {
						this.status = status;
					}
					public Date getCreatedDate() {
						return createdDate;
					}
					public void setCreatedDate(Date createdDate) {
						this.createdDate = createdDate;
					}
					public Date getUpdatedDate() {
						return updatedDate;
					}
					public void setUpdatedDate(Date updatedDate) {
						this.updatedDate = updatedDate;
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
					/*public Address getAddress() {
						return address;
					}
					public void setAddress(Address address) {
						this.address = address;
					}
					public List<Long> getAddresses() {
						return addresses;
					}
					public void setAddresses(List<Long> addresses) {
						this.addresses = addresses;
					}*/
					public Long getProviderId() {
						return providerId;
					}
					public void setProviderId(Long providerId) {
						this.providerId = providerId;
					}
					public List<Long> getProviderList() {
						return providerList;
					}
					public void setProviderList(List<Long> providerList) {
						this.providerList = providerList;
					}
					public Boolean getOnlineschedule() {
						return onlineschedule;
					}
					public void setOnlineschedule(Boolean onlineschedule) {
						this.onlineschedule = onlineschedule;
					}
					
					
					   
}
