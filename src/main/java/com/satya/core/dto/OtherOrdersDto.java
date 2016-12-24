package com.satya.core.dto;

public class OtherOrdersDto extends CreationDto {
	private Long otherOrderId;
    private Long encounterId;
	 private String orderfrom;
	 private String orderto;
	 private String ordertype;
	 private String ordername;
	 private String specialInstructions;
	 private Long fromPhysician;
	 private Long toPhysician;
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
	public String getOrderfrom() {
		return orderfrom;
	}
	public void setOrderfrom(String orderfrom) {
		this.orderfrom = orderfrom;
	}
	public String getOrderto() {
		return orderto;
	}
	public void setOrderto(String orderto) {
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
	public Long getFromPhysician() {
		return fromPhysician;
	}
	public void setFromPhysician(Long fromPhysician) {
		this.fromPhysician = fromPhysician;
	}
	public Long getToPhysician() {
		return toPhysician;
	}
	public void setToPhysician(Long toPhysician) {
		this.toPhysician = toPhysician;
	}
	 
}
