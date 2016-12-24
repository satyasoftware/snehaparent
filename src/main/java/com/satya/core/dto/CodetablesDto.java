package com.satya.core.dto;

import java.util.Collection;
import java.util.List;


import com.satya.core.bean.InstitutionType;

public class CodetablesDto {
	private List<String> genders;
	private List<String> occupations;
	private List<String> govtIds;
	private List<String> gender;
	private List<String> races;
	private Collection<String> provTypes;
	private Collection<InstitutionType> instTypes;
	public List<String> getGenders() {
		return genders;
	}
	public void setGenders(List<String> genders) {
		this.genders = genders;
	}
	public List<String> getOccupations() {
		return occupations;
	}
	public void setOccupations(List<String> occupations) {
		this.occupations = occupations;
	}
	public List<String> getGovtIds() {
		return govtIds;
	}
	public void setGovtIds(List<String> govtIds) {
		this.govtIds = govtIds;
	}
	public List<String> getGender() {
		return gender;
	}
	public void setGender(List<String> gender) {
		this.gender = gender;
	}
	public List<String> getRaces() {
		return races;
	}
	public void setRaces(List<String> races) {
		this.races = races;
	}
	public Collection<String> getProvTypes() {
		return provTypes;
	}
	public void setProvTypes(Collection<String> provTypes) {
		this.provTypes = provTypes;
	}
	public Collection<InstitutionType> getInstTypes() {
		return instTypes;
	}
	public void setInstTypes(Collection<InstitutionType> instTypes) {
		this.instTypes = instTypes;
	}
	
	
}
