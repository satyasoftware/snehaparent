package com.satya.core.bean;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="DRUGS")
public class Drugs {
	@Id Long drugId;
	private String productID;
	private String productNDC; 	
	private String productTypeName ; 	
	private String proprietaryName ;	
	private String proprietaryNameSuffix; 
	private String nonProprietaryName; 	
	private String dosageFormName; 	
	private String routeName ; 	
	private String startMarketingDate ;
	private String endMarketingDate ; 	
	private String marketingCategoryName;
	private String applicationNumber;    	
	private String labelerName; 	
	private String substanceName;   //SUBSTANCENAME	
	private String strengthNumber; //ACTIVE_NUMERATOR_STRENGTH
	private String strengthUnit;  //ACTIVE_INGRED_UNIT	
	private String pharmClasses;	
	private String dEASchedule;
	
	public Drugs() {}

	 public Drugs(Long drugId,String productID, String productNDC, String productTypeName, String proprietaryName,
			String proprietaryNameSuffix, String nonProprietaryName, String dosageFormName, String routeName,
			String startMarketingDate, String endMarketingDate, String marketingCategoryName, String applicationNumber,
			String labelerName, String substanceName, String strengthNumber, String strengthUnit, String pharmClasses,
			String dEASchedule) {
		//super();
		 this.drugId = drugId;
		this.productID = productID;
		this.productNDC = productNDC;
		this.productTypeName = productTypeName;
		this.proprietaryName = proprietaryName;
		this.proprietaryNameSuffix = proprietaryNameSuffix;
		this.nonProprietaryName = nonProprietaryName;
		this.dosageFormName = dosageFormName;
		this.routeName = routeName;
		this.startMarketingDate = startMarketingDate;
		this.endMarketingDate = endMarketingDate;
		this.marketingCategoryName = marketingCategoryName;
		this.applicationNumber = applicationNumber;
		this.labelerName = labelerName;
		this.substanceName = substanceName;
		this.strengthNumber = strengthNumber;
		this.strengthUnit = strengthUnit;
		this.pharmClasses = pharmClasses;
		this.dEASchedule = dEASchedule;
	}
	 
	public Long getDrugId() {
		return drugId;
	}

	public void setDrugId(Long drugId) {
		this.drugId = drugId;
	}

	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getProductNDC() {
		return productNDC;
	}
	public void setProductNDC(String productNDC) {
		this.productNDC = productNDC;
	}
	public String getProductTypeName() {
		return productTypeName;
	}
	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}
	public String getProprietaryName() {
		return proprietaryName;
	}
	public void setProprietaryName(String proprietaryName) {
		this.proprietaryName = proprietaryName;
	}
	public String getProprietaryNameSuffix() {
		return proprietaryNameSuffix;
	}
	public void setProprietaryNameSuffix(String proprietaryNameSuffix) {
		this.proprietaryNameSuffix = proprietaryNameSuffix;
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
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public String getStartMarketingDate() {
		return startMarketingDate;
	}
	public void setStartMarketingDate(String startMarketingDate) {
		this.startMarketingDate = startMarketingDate;
	}
	public String getEndMarketingDate() {
		return endMarketingDate;
	}
	public void setEndMarketingDate(String endMarketingDate) {
		this.endMarketingDate = endMarketingDate;
	}
	public String getMarketingCategoryName() {
		return marketingCategoryName;
	}
	public void setMarketingCategoryName(String marketingCategoryName) {
		this.marketingCategoryName = marketingCategoryName;
	}
	public String getApplicationNumber() {
		return applicationNumber;
	}
	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}
	public String getLabelerName() {
		return labelerName;
	}
	public void setLabelerName(String labelerName) {
		this.labelerName = labelerName;
	}
	public String getSubstanceName() {
		return substanceName;
	}
	public void setSubstanceName(String substanceName) {
		this.substanceName = substanceName;
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
	public String getPharmClasses() {
		return pharmClasses;
	}
	public void setPharmClasses(String pharmClasses) {
		this.pharmClasses = pharmClasses;
	}
	public String getdEASchedule() {
		return dEASchedule;
	}
	public void setdEASchedule(String dEASchedule) {
		this.dEASchedule = dEASchedule;
	} 
	

	
	
	@Override
	public String toString() {
		String str= "Drugs [proprietaryName=" + proprietaryName + ", nonProprietaryName=" + nonProprietaryName
				+ ", dosageFormName=" + dosageFormName + ", strengthNumber=" + strengthNumber + ", strengthUnit="
				+ strengthUnit + "]";
		System.out.println(str);
		return str;
		
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
		Drugs other = (Drugs) obj;
		if (dosageFormName == null) {
			if (other.dosageFormName != null)
				return false;
		} else if (!dosageFormName.equals(other.dosageFormName))
			return false;
		if (nonProprietaryName == null) {
			if (other.nonProprietaryName != null)
				return false;
		} else if (!nonProprietaryName.equals(other.nonProprietaryName))
			return false;
		if (proprietaryName == null) {
			if (other.proprietaryName != null)
				return false;
		} else if (!proprietaryName.equals(other.proprietaryName))
			return false;
		if (strengthNumber == null) {
			if (other.strengthNumber != null)
				return false;
		} else if (!strengthNumber.equals(other.strengthNumber))
			return false;
		if (strengthUnit == null) {
			if (other.strengthUnit != null)
				return false;
		} else if (!strengthUnit.equals(other.strengthUnit))
			return false;
		return true;
	}

	public static void main(String[] args) {
		
	
		//public  List<Drugs> getDrugs() {
				   List<Drugs> drugList=new ArrayList<Drugs>();
				         BufferedReader br = null;
				         Long i=1L;
				          int eig=1;
				          int sev=1;
				          int six=1;
				          int thi=1;
				         try {
				         
				             br = new BufferedReader(new FileReader("C:\\Users\\SatyaSoft1\\Downloads\\ndctext\\product.txt"));
				             String line;
				             while ((line = br.readLine()) != null) {
				            	 String[] code=line.split("\\t");
				            	// System.out.println(i+"="+code.length);
				            	 if(code.length==18){
				            		 //eig++;
				            		 //drugList.add(createDrug(i,code[0],code[1],code[2],code[3],code[4],code[5],code[6],code[7],code[8],code[9],code[10],code[11],code[12],code[13],code[14],code[15],code[16],code[17]));
				            		 //System.out.println( i+"==code length 18="+code.length);
				            	 }
				            	 else  if(code.length==17){
				            		 sev++;
				            		// drugList.add(createDrug(i,code[0],code[1],code[2],code[3],code[4],code[5],code[6],code[7],code[8],code[9],code[10],code[11],code[12],code[13],code[14],code[15],code[16],null));
				            	 }
				            	 else  if(code.length==16){
				            		 six++;
				            		// drugList.add(createDrug(i,code[0],code[1],code[2],code[3],code[4],code[5],code[6],code[7],code[8],code[9],code[10],code[11],code[12],code[13],code[14],code[15],null,null));
				            	 }
				            	 else  if(code.length==13){
				            		 thi++;
				            		 drugList.add(createDrug(i,code[0],code[1],code[2],code[3],null,code[4],code[5],code[6],code[7],null,code[8],null,code[9],code[10],code[11],code[12],null,null));
				            	
				            	 
				            	 }else{ 
				            		 System.out.println(i +"==code length ="+code.length);
				            		 }
				            	 i++;
				            	 if(i==1000) break;
				             }
				             
				         } catch (IOException e) {
				             e.printStackTrace();
				         } finally {
				             try {
				                 if (br != null) {
				                     br.close();
				                 }
				             } catch (IOException ex) {
				                 ex.printStackTrace();
				             }
				         }
				         System.out.println(eig+" sev "+sev+" six "+six+" thi "+thi);
				    // return drugList;   
		     // }
	}
		private static Drugs createDrug(Long drugId,String productID, String productNDC, String productTypeName, String proprietaryName,
				String proprietaryNameSuffix, String nonProprietaryName, String dosageFormName, String routeName,
				String startMarketingDate, String endMarketingDate, String marketingCategoryName, String applicationNumber,
				String labelerName, String substanceName, String strengthNumber, String strengthUnit, String pharmClasses,
				String dEASchedule) {
			System.out.println(drugId+"\t"+productID+"\t"+productNDC+"\t"+productTypeName+"\t"+proprietaryName+"\t"+proprietaryNameSuffix+"\t"+nonProprietaryName+"\t"+dosageFormName+"\t"+routeName+"\t"+startMarketingDate+"\t"+endMarketingDate+"\t"+
					marketingCategoryName+"\t"+applicationNumber+"\t"+labelerName+"\t"+substanceName+"\t"+strengthNumber+"\t"+strengthUnit+"\t"+pharmClasses+"\t"+dEASchedule);
			return new Drugs(drugId,productID,productNDC,productTypeName,proprietaryName,proprietaryNameSuffix,nonProprietaryName,dosageFormName,routeName,startMarketingDate,endMarketingDate,
					marketingCategoryName,applicationNumber,labelerName,substanceName,strengthNumber,strengthUnit,pharmClasses,dEASchedule);
		}
     }
