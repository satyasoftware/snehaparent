package com.satya.core.enums;

public enum OrderTypesEnum {
    Pending, Approved;
	
	private String ordstatus;

	public String getOrdstatus() {
		return ordstatus;
	}

	public void setOrdstatus(String ordstatus) {
		this.ordstatus = ordstatus;
	}
	
}
