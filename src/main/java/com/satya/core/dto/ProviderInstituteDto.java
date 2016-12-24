package com.satya.core.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Transient;
import org.springframework.format.annotation.DateTimeFormat;

import com.satya.core.bean.Institution;
import com.satya.core.bean.Provider;
import com.satya.core.beanLimit.InstitutionL;
import com.satya.core.beanLimit.ProviderL;

public class ProviderInstituteDto {
	              private Long provInstId;
		@NotNull  private Long provId;
		@NotNull  private Long instId;
		@NotNull  private String provType;
		@DateTimeFormat(pattern="MM/dd/yyyy") private Date startDate;
		
		          private Date endDate;
		          private Boolean status; //true. false
		          private Date createdDate;
				  private Date updatedDate;
				  private Long createdUserId;
				  private Long updateduserId;
				  private Long phone;
				  private Long phone_ext;
				  private String roominfo;
				  private String others;
				  private Integer provEmpId;
				  private String department;
				  private String ward;
				  @Transient
				   private Provider provider;
				  @Transient
				   private Institution institution;
				  
				  private ProviderL providerL;
				  private InstitutionL institutionL;
				public Long getProvInstId() {
					return provInstId;
				}
				public void setProvInstId(Long provInstId) {
					this.provInstId = provInstId;
				}
				public Long getProvId() {
					return provId;
				}
				public void setProvId(Long provId) {
					this.provId = provId;
				}
				public Long getInstId() {
					return instId;
				}
				public void setInstId(Long instId) {
					this.instId = instId;
				}
				public String getProvType() {
					return provType;
				}
				public void setProvType(String provType) {
					this.provType = provType;
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
				public Long getPhone() {
					return phone;
				}
				public void setPhone(Long phone) {
					this.phone = phone;
				}
				public Long getPhone_ext() {
					return phone_ext;
				}
				public void setPhone_ext(Long phone_ext) {
					this.phone_ext = phone_ext;
				}
				public String getRoominfo() {
					return roominfo;
				}
				public void setRoominfo(String roominfo) {
					this.roominfo = roominfo;
				}
				public String getOthers() {
					return others;
				}
				public void setOthers(String others) {
					this.others = others;
				}
				public Integer getProvEmpId() {
					return provEmpId;
				}
				public void setProvEmpId(Integer provEmpId) {
					this.provEmpId = provEmpId;
				}
				public String getDepartment() {
					return department;
				}
				public void setDepartment(String department) {
					this.department = department;
				}
				public String getWard() {
					return ward;
				}
				public void setWard(String ward) {
					this.ward = ward;
				}
				public Provider getProvider() {
					return provider;
				}
				public void setProvider(Provider provider) {
					this.provider = provider;
				}
				public Institution getInstitution() {
					return institution;
				}
				public void setInstitution(Institution institution) {
					this.institution = institution;
				}
				public ProviderL getProviderL() {
					return providerL;
				}
				public void setProviderL(ProviderL providerL) {
					this.providerL = providerL;
				}
				public InstitutionL getInstitutionL() {
					return institutionL;
				}
				public void setInstitutionL(InstitutionL institutionL) {
					this.institutionL = institutionL;
				}
				  
				  

}
