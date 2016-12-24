package com.satya.core.beanLimit;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection="PERSON")
public class PersonL {
	@Id      private Long id;
			 private String userId;
			 private String firstname;
			 private String middlename;
		     private String lastname;
		     private String gender;
		     private String email;
		     private Long cell_number;
		     
	@DateTimeFormat(pattern="MM/dd/yyyy")    private Date birthday;
		     
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
			public Date getBirthday() {
				return birthday;
			}
			public void setBirthday(Date birthday) {
				this.birthday = birthday;
			}
		   
			
}
