package com.satya.core.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class AddressDto {
	@NotEmpty    private String address1;
	@NotEmpty	private String address2;
				private String address3;
	@NotEmpty	private String city;
	@NotEmpty   private String province;
	@NotEmpty	private String zip;
				private String zip_ext;
				private String country;
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
				
				
}
