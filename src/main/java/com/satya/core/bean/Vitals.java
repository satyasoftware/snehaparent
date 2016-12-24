package com.satya.core.bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.satya.core.beanLimit.ProviderL;

@Document(collection="VITALS")
public class Vitals extends Creation{
	@Id private Long vitalId;
	   private Long encounterId;
	   //temparature pulserate chest systolicBP diognosticBP pulseOximetry heigth weight description
	   private Float temperature;// 97 to 110 c
	   private Integer pulserate;//30 200
	   private Integer chest;  //
	   private Integer systolicBp;
	   private Integer diastolicBp;//diastolic
	   private Integer pulseOximetry;
	   private Float height;
	   private Float weight;
	   private String description;
	   private String provType;
	   @DBRef private ProviderL providerL;

	   
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

	public String getProvType() {
		return provType;
	}

	public void setProvType(String provType) {
		this.provType = provType;
	}

	public ProviderL getProviderL() {
		return providerL;
	}

	public void setProviderL(ProviderL providerL) {
		this.providerL = providerL;
	}

	
		   
}
