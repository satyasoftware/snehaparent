package com.satya.core.bean;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="DISEASES")
public class Diseases {
	@Id private Long diseaseId;
    private String icdCode;
    private String diseaseName;
    
    public Diseases(){}
	public Diseases(Long diseaseId, String icdCode, String diseaseName) {
		super();
		this.diseaseId = diseaseId;
		this.icdCode = icdCode;
		this.diseaseName = diseaseName;
	}
	
	public Long getDiseaseId() {
		return diseaseId;
	}
	public void setDiseaseId(Long diseaseId) {
		this.diseaseId = diseaseId;
	}
	public String getIcdCode() {
		return icdCode;
	}
	public void setIcdCode(String icdCode) {
		this.icdCode = icdCode;
	}
	public String getDiseaseName() {
		return diseaseName;
	}
	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	} 
	
	public static void main(String[] args) {
		new Diseases().getDeseaseList();
	}
	
	public  List<Diseases> getDeseaseList() {
		   List<Diseases> labList=new ArrayList<Diseases>();
		         BufferedReader br = null;
		         try {
		          Long i=1L;
		             br = new BufferedReader(new FileReader("C:\\Users\\SatyaSoft1\\Desktop\\icd10cm_codes_2017.txt"));
		             String line;
		             while ((line = br.readLine()) != null) {
		            	 String code=line.substring(0, 7);
		            	 String desc=line.substring(7,line.length());
		            	 labList.add(new Diseases(i++,code.trim(),desc.trim()));
		                //if(i==100)break;
		             }
		             
		            // for(Diseases d:labList){
		            	//	System.out.println(d.getDiseaseId()+"-"+d.getIcdCode().trim()+"-"+d.getDiseaseName().trim());
		            	//}
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
		         return labList;
		     }
	
}
