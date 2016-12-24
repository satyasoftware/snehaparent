package com.satya.core.bean;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.satya.core.beanLimit.DrugsL;
import com.satya.core.beanLimit.ProviderL;

@Document(collection="MEDICALORDER")
public class MedicalOrder extends Creation {
	   @Id private Long medicalorderId;
	     private Long encounterId;
	     private String drugName;
         private Integer dosage;
        private String drugUnits;
        private String brandName;
       // private String chemicalName;
        private String frequency;
        private Integer duration;
        private String durationUnits;
        private String patInstr;
        private String pharmInstr; 
        private String admInstr;
        private String orderType;//enum scheduled continuous prn
        private String drugForm;
        private String applyRoute;
    	private  String medicationStatus;
    	private Date startDtTm;
 	    private Date endDtTm;
 	    @DBRef
	    private ProviderL providerL;
 	    private String provType;
 	    private Long approvedProvider;
 	    private String ordStatus;
 	    
		public String getDrugForm() {
			return drugForm;
		}
		public void setDrugForm(String drugForm) {
			this.drugForm = drugForm;
		}
		public String getApplyRoute() {
			return applyRoute;
		}
		public void setApplyRoute(String applyRoute) {
			this.applyRoute = applyRoute;
		}
		public String getOrderType() {
			return orderType;
		}
		public void setOrderType(String orderType) {
			this.orderType = orderType;
		}
		public ProviderL getProviderL() {
			return providerL;
		}
		public void setProviderL(ProviderL providerL) {
			this.providerL = providerL;
		}
		public Long getMedicalorderId() {
			return medicalorderId;
		}
		public void setMedicalorderId(Long medicalorderId) {
			this.medicalorderId = medicalorderId;
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
		/*public String getChemicalName() {
			return chemicalName;
		}
		public void setChemicalName(String chemicalName) {
			this.chemicalName = chemicalName;
		}
		*/
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
		public String getProvType() {
			return provType;
		}
		public void setProvType(String provType) {
			this.provType = provType;
		}
		public Long getApprovedProvider() {
			return approvedProvider;
		}
		public void setApprovedProvider(Long approvedProvider) {
			this.approvedProvider = approvedProvider;
		}
		public String getOrdStatus() {
			return ordStatus;
		}
		public void setOrdStatus(String ordStatus) {
			this.ordStatus = ordStatus;
		}   
    
}
