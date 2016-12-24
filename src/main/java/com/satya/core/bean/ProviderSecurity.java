package com.satya.core.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="PROVIDERSECURITY")
public class ProviderSecurity {
	@Id private Long providerID;
		  private String securityquestion1;
		  private String answer1;
		  private String securityquestion2;
		  private String answer2;
		  private String securityquestion3;
		  private String answer3;
		  
		public Long getProviderID() {
			return providerID;
		}
		public void setProviderID(Long providerID) {
			this.providerID = providerID;
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
