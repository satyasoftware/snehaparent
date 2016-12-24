package com.satya.core.jsonresponse;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.satya.core.bean.MastLabTests;
import com.satya.core.beanLimit.DrugsL;
@JsonInclude(Include.NON_NULL)
public class TreatmentResponse extends Response {
	private Map<Long,String> disMap;
	private Map<Long,String> drugMap;
	private int totelements;
	private Collection<DrugsL> drugSet;
    private List<MastLabTests> labtests;
	
	public List<MastLabTests> getLabtests() {
		return labtests;
	}
	public void setLabtests(List<MastLabTests> labtests) {
		this.labtests = labtests;
	}
	
	
	
	public int getTotelements() {
		return totelements;
	}
	public void setTotelements(int totelements) {
		this.totelements = totelements;
	}
	
	public Collection<DrugsL> getDrugSet() {
		return drugSet;
	}


	public void setDrugSet(Collection<DrugsL> drugSet) {
		this.drugSet = drugSet;
	}


	public Map<Long, String> getDisMap() {
		return disMap;
	}

	public void setDisMap(Map<Long, String> disMap) {
		this.disMap = disMap;
	}

	public Map<Long, String> getDrugMap() {
		return drugMap;
	}

	public void setDrugMap(Map<Long, String> drugMap) {
		this.drugMap = drugMap;
	}
	
	
}
