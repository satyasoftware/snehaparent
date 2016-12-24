package com.satya.core.bean;

import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection="SUPER_ADMIN")
public class SpAdmin {

	@Id                            private Long superID;
@NotBlank @Size(min = 4, max = 15) private String userId;
@NotBlank @Size(min = 4, max = 15) private String password;
@NotBlank                          private String govtIdType;
@NotBlank                          private String govtId;                          
@NotBlank @Size(min = 4, max = 15) private String firstname;
								   private String middlename;
@NotBlank @Size(min = 4, max = 15) private String lastname;
@NotNull @DateTimeFormat(pattern = "MM/dd/yyyy") private Date birthday;
                                        private String birthdate;
@NotBlank         				        private String gender;
@NotBlank @Email                        private String email;
@NotNull @Digits(integer=10,fraction=0) private Long cell_number;
                             private Long homephone_number;

                @NotEmpty    private String address1;
                @NotEmpty	 private String address2;
						     private String address3;
				@NotEmpty	 private String city;
				@NotEmpty    private String province;
			                 private String zip;
						     private String zip_ext;
						     
						     private boolean status;
						     private Date registerdate;
						     private Date updateddate;
						     private Long createdUserId;
						     private Long updateduserId;
							public Long getSuperID() {
								return superID;
							}
							public void setSuperID(Long superID) {
								this.superID = superID;
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
							public String getBirthdate() {
								return birthdate;
							}
							public void setBirthdate(String birthdate) {
								this.birthdate = birthdate;
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
							public String getAddress1() {
								return address1;
							}
							public void setAddress1(String address1) {
								this.address1 = address1;
							}
							public String getAddress2() {
								return address2;
							}
							public void setAddress2(String address2) {
								this.address2 = address2;
							}
							public String getAddress3() {
								return address3;
							}
							public void setAddress3(String address3) {
								this.address3 = address3;
							}
							public String getCity() {
								return city;
							}
							public void setCity(String city) {
								this.city = city;
							}
							public String getProvince() {
								return province;
							}
							public void setProvince(String province) {
								this.province = province;
							}
							public String getZip() {
								return zip;
							}
							public void setZip(String zip) {
								this.zip = zip;
							}
							public String getZip_ext() {
								return zip_ext;
							}
							public void setZip_ext(String zip_ext) {
								this.zip_ext = zip_ext;
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
						     
						     
}
