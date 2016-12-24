package com.satya.core.dto;

import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class MedicationDto extends CreationDto {
	  private Long medicationId;
	 @NotNull  private Long encounterId;
	 @NotEmpty  private String drugName;
     @NotNull @Digits(fraction=0, integer = 1)   private Integer dosage;
     @NotEmpty   private String drugUnits;
     @NotEmpty   private String brandName;
		     	private String chemicalName;
		     	private String frequency;
		     	private Integer duration;
		     	private String durationUnits;
		     	private String patInstr;
		     	private String pharmInstr; 
		      	private String admInstr;
		  		private  String medicationStatus;
		  		private Date startDtTm;
			    private Date endDtTm;
			    private Long providerId;
			    
				public Long getProviderId() {
					return providerId;
				}
				public void setProviderId(Long providerId) {
					this.providerId = providerId;
				}
				public Long getMedicationId() {
					return medicationId;
				}
				public void setMedicationId(Long medicationId) {
					this.medicationId = medicationId;
				}
				public Long getEncounterId() {
					return encounterId;
				}
				public void setEncounterId(Long encounterId) {
					this.encounterId = encounterId;
				}
				public String getDrugName() {
					return drugName;
				}
				public void setDrugName(String drugName) {
					this.drugName = drugName;
				}
				public Integer getDosage() {
					return dosage;
				}
				public void setDosage(Integer dosage) {
					this.dosage = dosage;
				}
				public String getDrugUnits() {
					return drugUnits;
				}
				public void setDrugUnits(String drugUnits) {
					this.drugUnits = drugUnits;
				}
				public String getBrandName() {
					return brandName;
				}
				public void setBrandName(String brandName) {
					this.brandName = brandName;
				}
				public String getChemicalName() {
					return chemicalName;
				}
				public void setChemicalName(String chemicalName) {
					this.chemicalName = chemicalName;
				}
				public String getFrequency() {
					return frequency;
				}
				public void setFrequency(String frequency) {
					this.frequency = frequency;
				}
				public Integer getDuration() {
					return duration;
				}
				public void setDuration(Integer duration) {
					this.duration = duration;
				}
				public String getDurationUnits() {
					return durationUnits;
				}
				public void setDurationUnits(String durationUnits) {
					this.durationUnits = durationUnits;
				}
				public String getPatInstr() {
					return patInstr;
				}
				public void setPatInstr(String patInstr) {
					this.patInstr = patInstr;
				}
				public String getPharmInstr() {
					return pharmInstr;
				}
				public void setPharmInstr(String pharmInstr) {
					this.pharmInstr = pharmInstr;
				}
				public String getAdmInstr() {
					return admInstr;
				}
				public void setAdmInstr(String admInstr) {
					this.admInstr = admInstr;
				}
				public String getMedicationStatus() {
					return medicationStatus;
				}
				public void setMedicationStatus(String medicationStatus) {
					this.medicationStatus = medicationStatus;
				}
				public Date getStartDtTm() {
					return startDtTm;
				}
				public void setStartDtTm(Date startDtTm) {
					this.startDtTm = startDtTm;
				}
				public Date getEndDtTm() {
					return endDtTm;
				}
				public void setEndDtTm(Date endDtTm) {
					this.endDtTm = endDtTm;
				}
			    
			    
}