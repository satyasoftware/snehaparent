package com.satya.core.beanLimit;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="DRUGS")
public class DrugsL {
	@Id Long drugId;
	private String proprietaryName ;	
	private String nonProprietaryName; 	
	private String dosageFormName; 	
	private String strengthNumber; //ACTIVE_NUMERATOR_STRENGTH
	private String strengthUnit;  //ACTIVE_INGRED_UNIT	
	private String labelerName;
	private String  routeName;
	
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public String getLabelerName() {
		return labelerName;
	}
	public void setLabelerName(String labelerName) {
		this.labelerName = labelerName;
	}
	public Long getDrugId() {
		return drugId;
	}
	public void setDrugId(Long drugId) {
		this.drugId = drugId;
	}
	public String getProprietaryName() {
		return proprietaryName;
	}
	public void setProprietaryName(String proprietaryName) {
		this.proprietaryName = proprietaryName;
	}
	public String getNonProprietaryName() {
		return nonProprietaryName;
	}
	public void setNonProprietaryName(String nonProprietaryName) {
		this.nonProprietaryName = nonProprietaryName;
	}
	public String getDosageFormName() {
		return dosageFormName;
	}
	public void setDosageFormName(String dosageFormName) {
		this.dosageFormName = dosageFormName;
	}
	public String getStrengthNumber() {
		return strengthNumber;
	}
	public void setStrengthNumber(String strengthNumber) {
		this.strengthNumber = strengthNumber;
	}
	public String getStrengthUnit() {
		return strengthUnit;
	}
	public void setStrengthUnit(String strengthUnit) {
		this.strengthUnit = strengthUnit;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dosageFormName == null) ? 0 : dosageFormName.hashCode());
		result = prime * result + ((nonProprietaryName == null) ? 0 : nonProprietaryName.hashCode());
		result = prime * result + ((proprietaryName == null) ? 0 : proprietaryName.hashCode());
		result = prime * result + ((strengthNumber == null) ? 0 : strengthNumber.hashCode());
		result = prime * result + ((strengthUnit == null) ? 0 : strengthUnit.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DrugsL other = (DrugsL) obj;
		if (dosageFormName == null) {
			if (other.dosageFormName != null)
				return false;
		} else if (!dosageFormName.equalsIgnoreCase(other.dosageFormName))
			return false;
		if (nonProprietaryName == null) {
			if (other.nonProprietaryName != null)
				return false;
		} else if (!nonProprietaryName.equalsIgnoreCase(other.nonProprietaryName))
			return false;
		if (proprietaryName == null) {
			if (other.proprietaryName != null)
				return false;
		} else if (!proprietaryName.equalsIgnoreCase(other.proprietaryName))
			return false;
		if (strengthNumber == null) {
			if (other.strengthNumber != null)
				return false;
		} else if (!strengthNumber.equalsIgnoreCase(other.strengthNumber))
			return false;
		if (strengthUnit == null) {
			if (other.strengthUnit != null)
				return false;
		} else if (!strengthUnit.equalsIgnoreCase(other.strengthUnit))
			return false;
		return true;
	}
	@Override
	public String toString() {
		String str= "DrugsL [proprietaryName=" + proprietaryName + ", nonProprietaryName=" + nonProprietaryName
				+ ", dosageFormName=" + dosageFormName + ", strengthNumber=" + strengthNumber + ", strengthUnit="
				+ strengthUnit + "]";
		
		
		System.out.println(str);
		return str;
	}

	
	
}
