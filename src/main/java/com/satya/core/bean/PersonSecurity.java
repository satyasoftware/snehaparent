package com.satya.core.bean;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="PERSONSECURITY")
public class PersonSecurity {
     @Id private Long personID;
	  private String securityquestion1;
	  @NotBlank  private String answer1;
	  private String securityquestion2;
	  @NotBlank private String answer2;
	  private String securityquestion3;
	  @NotBlank private String answer3;
	  
	public Long getPersonID() {
		return personID;
	}
	public void setPersonID(Long personID) {
		this.personID = personID;
	}
	public String getSecurityquestion1() {
		return securityquestion1;
	}
	public void setSecurityquestion1(String securityquestion1) {
		this.securityquestion1 = securityquestion1;
	}
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public String getSecurityquestion2() {
		return securityquestion2;
	}
	public void setSecurityquestion2(String securityquestion2) {
		this.securityquestion2 = securityquestion2;
	}
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	public String getSecurityquestion3() {
		return securityquestion3;
	}
	public void setSecurityquestion3(String securityquestion3) {
		this.securityquestion3 = securityquestion3;
	}
	public String getAnswer3() {
		return answer3;
	}
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	  
}
