package com.satya.core.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.satya.core.beanLimit.ProviderL;

@Document(collection="OTHERORDERS")
public class OtherOrders extends Creation {
 @Id private Long otherOrderId;
     private Long encounterId;
     @DBRef
	 private ProviderL orderfrom;
     @DBRef
	 private ProviderL orderto;
	 private String ordertype;
	 private String ordername;
	 private String specialInstructions;
	 private String provType;
	   
		public String getProvType() {
			return provType;
		}
		public void setProvType(String provType) {
			this.provType = provType;
		}
	public Long getOtherOrderId() {
		return otherOrderId;
	}
	public void setOtherOrderId(Long otherOrderId) {
		this.otherOrderId = otherOrderId;
	}
	public Long getEncounterId() {
		return encounterId;
	}
	public void setEncounterId(Long encounterId) {
		this.encounterId = encounterId;
	}
	
	public ProviderL getOrderfrom() {
		return orderfrom;
	}
	public void setOrderfrom(ProviderL orderfrom) {
		this.orderfrom = orderfrom;
	}
	public ProviderL getOrderto() {
		return orderto;
	}
	public void setOrderto(ProviderL orderto) {
		this.orderto = orderto;
	}
	public String getOrdertype() {
		return ordertype;
	}
	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}
	public String getOrdername() {
		return ordername;
	}
	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}
	public String getSpecialInstructions() {
		return specialInstructions;
	}
	public void setSpecialInstructions(String specialInstructions) {
		this.specialInstructions = specialInstructions;
	}
	 
}
