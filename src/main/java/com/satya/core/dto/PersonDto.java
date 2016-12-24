package com.satya.core.dto;

import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.satya.core.bean.PersonSecurity;

public class PersonDto {
							 private Long id;
	@Size(min = 4, max = 15) private String userId;
	@Size(min = 4, max = 15) @JsonIgnore private String password;
	
	                         private String govtIdType;
                             private String govtId;
    @Size(min = 4, max = 15) private String firstname;
    						 private String middlename;
    @Size(min = 4, max = 15) private String lastname;
    
    @NotNull @DateTimeFormat(pattern="MM/dd/yyyy")   private Date birthday;
    						 private String pob;
                             private String race;
    @NotEmpty                private String gender;
                             private Float height;
                             private Float weight;
                             private String email;
    @NotNull @Digits(integer=10,fraction=0) private Long cell_number;
                             private Long homephone_number, workphone_number, workphone_ext;
                             private String occupation;
						     private String favorite_food;
						     private String hobbis;
						     
						      private String newpassword;
						      private String confirmpassword;
							  private String role;
							  private Long appointmentId;
							
						     private Date registerdate;
						     private Date updateddate;
						     private Long createdUserId;
						     private Long updateduserId;
						     private String dob;
						     private PersonSecurity perSecure;
							public Long getId() {
								return id;
							}
							public void setId(Long id) {
								this.id = id;
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
							public String getPob() {
								return pob;
							}
							public void setPob(String pob) {
								this.pob = pob;
							}
							public String getRace() {
								return race;
							}
							public void setRace(String race) {
								this.race = race;
							}
							public String getGender() {
								return gender;
							}
							public void setGender(String gender) {
								this.gender = gender;
							}
							public Float getHeight() {
								return height;
							}
							public void setHeight(Float height) {
								this.height = height;
							}
							public Float getWeight() {
								return weight;
							}
							public void setWeight(Float weight) {
								this.weight = weight;
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
							public Long getWorkphone_number() {
								return workphone_number;
							}
							public void setWorkphone_number(Long workphone_number) {
								this.workphone_number = workphone_number;
							}
							public Long getWorkphone_ext() {
								return workphone_ext;
							}
							public void setWorkphone_ext(Long workphone_ext) {
								this.workphone_ext = workphone_ext;
							}
							public String getOccupation() {
								return occupation;
							}
							public void setOccupation(String occupation) {
								this.occupation = occupation;
							}
							public String getFavorite_food() {
								return favorite_food;
							}
							public void setFavorite_food(String favorite_food) {
								this.favorite_food = favorite_food;
							}
							public String getHobbis() {
								return hobbis;
							}
							public void setHobbis(String hobbis) {
								this.hobbis = hobbis;
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
							public String getRole() {
								return role;
							}
							public void setRole(String role) {
								this.role = role;
							}
							public Long getAppointmentId() {
								return appointmentId;
							}
							public void setAppointmentId(Long appointmentId) {
								this.appointmentId = appointmentId;
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
							public String getDob() {
								return dob;
							}
							public void setDob(String dob) {
								this.dob = dob;
							}
							public PersonSecurity getPerSecure() {
								return perSecure;
							}
							public void setPerSecure(PersonSecurity perSecure) {
								this.perSecure = perSecure;
							}
		
						      
}
