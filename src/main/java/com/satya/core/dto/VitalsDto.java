package com.satya.core.dto;

import javax.validation.constraints.NotNull;

public class VitalsDto extends CreationDto{
	private Long vitalId;
	@NotNull 
	private Long encounterId;
	private Float temperature;
	private Integer pulserate;
	private Integer chest;
	private Integer systolicBp;
	private Integer diastolicBp;
	private Integer pulseOximetry;
	private Float height;
	private Float weight;
	private String description;
	private Long providerId;
	private String provType;
	private String bp;
	public String getBp() {
		return bp;
	}
	public void setBp(String bp) {
		this.bp = bp;
	}
	public Long getVitalId() {
		return vitalId;
	}
	public void setVitalId(Long vitalId) {
		this.vitalId = vitalId;
	}
	public Long getEncounterId() {
		return encounterId;
	}
	public void setEncounterId(Long encounterId) {
		this.encounterId = encounterId;
	}
	public Float getTemperature() {
		return temperature;
	}
	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}
	public Integer getPulserate() {
		return pulserate;
	}
	public void setPulserate(Integer pulserate) {
		this.pulserate = pulserate;
	}
	public Integer getChest() {
		return chest;
	}
	public void setChest(Integer chest) {
		this.chest = chest;
	}
	public Integer getSystolicBp() {
		return systolicBp;
	}
	public void setSystolicBp(Integer systolicBp) {
		this.systolicBp = systolicBp;
	}
	public Integer getDiastolicBp() {
		return diastolicBp;
	}
	public void setDiastolicBp(Integer diastolicBp) {
		this.diastolicBp = diastolicBp;
	}
	public Integer getPulseOximetry() {
		return pulseOximetry;
	}
	public void setPulseOximetry(Integer pulseOximetry) {
		this.pulseOximetry = pulseOximetry;
	}
	public Float getHeight() {
		return height;
	}
	public void setHeight(Float height) {
		this.height = height;
	}
	public Float getWeight() {
		return weight;
	}
	public void setWeight(Float weight) {
		this.weight = weight;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getProviderId() {
		return providerId;
	}
	public void setProviderId(Long providerId) {
		this.providerId = providerId;
	}
	 
	public String getProvType() {
	     return provType;
	}
	public void setProvType(String provType) {
		this.provType = provType;
	}
     
	}
