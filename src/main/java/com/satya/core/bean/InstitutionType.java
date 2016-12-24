package com.satya.core.bean;

import java.util.Collection;
import java.util.TreeSet;

public class InstitutionType {

	private String instType;
	private TreeSet<String> roles;
	
	public String getInstType() {
		return instType;
	}
	public void setInstType(String instType) {
		this.instType = instType;
	}
	public Collection<String> getRoles() {
		return roles;
	}
	public void setRoles(TreeSet<String> roles) {
		this.roles = roles;
	}
	
}
