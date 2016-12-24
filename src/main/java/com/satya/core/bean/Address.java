package com.satya.core.bean;

import org.hibernate.validator.constraints.NotEmpty;

//@Document(collection="ADDRESS")
public class Address {
	//@Id     private Long id;
	//		private String addressEntity;
			//private String addressType;
@NotEmpty    private String address1;
@NotEmpty	private String address2;
			private String address3;
@NotEmpty	private String city;
@NotEmpty    private String province;
@NotEmpty	private String zip;
			private String zip_ext;
			private String country;
			
			/*private String[] securityquestion;
			private String[] answer;
						
		  
	public String[] getSecurityquestion() {
				return securityquestion;
			}
			public void setSecurityquestion(String[] securityquestion) {
				this.securityquestion = securityquestion;
			}
			public String[] getAnswer() {
				return answer;
			}
			public void setAnswer(String[] answer) {
				this.answer = answer;
			}*/
			
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
	 
     
     public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		
	
/*	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Date getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
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
	}*/
    
	
/*
    String name = null;
    @NotNull: false
    @NotEmpty: false
    @NotBlank: false

    String name = "";
    @NotNull: true
    @NotEmpty: false
    @NotBlank: false

    String name = " ";
    @NotNull: true
    @NotEmpty: true
    @NotBlank: false

    String name = "Great answer!";
    @NotNull: true
    @NotEmpty: true
    @NotBlank: true

Alabama
Alaska
Arizona
Arkansas
California
Colorado
Connecticut
Delaware
Florida
Georgia
Hawaii
Idaho
Illinois
Indiana
Iowa
Kansas
Kentucky
Louisiana
Maine
Maryland
Massachusetts
Michigan
Minnesota
Mississippi
Missouri
Montana
Nebraska
Nevada
New Hampshire
New Jersey
New Mexico
New York
North Carolina
North Dakota
Ohio
Oklahoma
Oregon
Pennsylvania
Rhode Island
South Carolina
South Dakota
Tennessee
Texas
Utah
Vermont
Virginia
Washington
West Virginia
Wisconsin
Wyoming
*/
}
