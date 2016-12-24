package com.satya.core.bean;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="LABTESTS")
public class MastLabTests {
	@Id private Long id;
        private String testname;
        private String testType; //Lab or Image/radiology
        private String specimen;
        private String bodypart;
        private String modality; //image type
        
        
        public MastLabTests(){}
        
      //  private String testDescr;
        
        public MastLabTests(Long id, String testname, String testType, String specimen, String bodypart,
				String modality) {
			super();
			this.id = id;
			this.testname = testname;
			this.testType = testType;
			this.specimen = specimen;
			this.bodypart = bodypart;
			this.modality = modality;
		}

		public String getSpecimen() {
			return specimen;
		}

		public void setSpecimen(String specimen) {
			this.specimen = specimen;
		}

		public String getBodypart() {
			return bodypart;
		}

		public void setBodypart(String bodypart) {
			this.bodypart = bodypart;
		}

		public String getModality() {
			return modality;
		}

		public void setModality(String modality) {
			this.modality = modality;
		}

		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getTestname() {
			return testname;
		}
		public void setTestname(String testname) {
			this.testname = testname;
		}
		
		public String getTestType() {
			return testType;
		}

		public void setTestType(String testType) {
			this.testType = testType;
		}

		/*public String getTestDescr() {
			return testDescr;
		}
		public void setTestDescr(String testDescr) {
			this.testDescr = testDescr;
		}
*/
		// List<MastLabTests> labtests=new ArrayList<MastLabTests>();
		 //  labtests.add(new MastLabTests(1L,"ACTH Suppression","ACTH Suppression"));
//		public  List<MastLabTests> getTestList() {
//			   List<MastLabTests> labList=new ArrayList<MastLabTests>();
//			         BufferedReader br = null;
//			         try {
//			          int i=1;
//			             br = new BufferedReader(new FileReader("C:\\Users\\SatyaSoft1\\Desktop\\labtest.txt"));
//			             String line;
//			             while ((line = br.readLine()) != null) {
//			                // System.out.println(line);
//			                // if(line.contains("ml")){
//			                 String [] str=line.split("\t");
//			                if(str.length>3 || str.length<3) System.out.println(i+"="+str.length);
//			               // MastLabTests lab=new MastLabTests();// }//else System.out.println(line);
//			                labList.add(new MastLabTests(Long.parseLong(str[0].trim()),str[1].trim(),"Lab",str[2].trim(),null,null));
//			                i++;
//			             }
//			         } catch (IOException e) {
//			             e.printStackTrace();
//			         } finally {
//			             try {
//			                 if (br != null) {
//			                     br.close();
//			                 }
//			             } catch (IOException ex) {
//			                 ex.printStackTrace();
//			             }
//			         }
//			         return labList;
//			     }
//		public  List<MastLabTests> getRadiologyTestList() {
//			   List<MastLabTests> labList=new ArrayList<MastLabTests>();
//			         BufferedReader br = null;
//			         try {
//			          Long i=639L;
//			             br = new BufferedReader(new FileReader("C:\\Users\\SatyaSoft1\\Desktop\\rediology.txt"));
//			             String line;
//			             while ((line = br.readLine()) != null) {
//			                // System.out.println(line);
//			                // if(line.contains("ml")){
//			                 String [] str=line.split("\t");
//			                if(str.length>3 || str.length<3) System.out.println(i+"="+str.length);
//			               // MastLabTests lab=new MastLabTests();// }//else System.out.println(line);
//			                System.out.println("id="+i++ +"name="+ str[2].trim()+"Image"+" bodypart= "+ str[0]+" modality="+str[1].trim());
//			                labList.add(new MastLabTests(i++,str[2].trim(),"Image",null,str[0].trim(),str[1].trim()));
//			               //i++;
//			             }
//			         } catch (IOException e) {
//			             e.printStackTrace();
//			         } finally {
//			             try {
//			                 if (br != null) {
//			                     br.close();
//			                 }
//			             } catch (IOException ex) {
//			                 ex.printStackTrace();
//			             }
//			         }
//			         return labList;
//			     }
//		
//		public static void main(String[] args) {
//			new MastLabTests().getRadiologyTestList();
//		}
		/*public List<String> getList(){
			    List<String> labtestList=new ArrayList<String>();
			    labtestList.add("ACTH Suppression");
			    labtestList.add("Adrenocorticotropic Hormone (ACTH)");
			    labtestList.add("Alanine Aminotransferase (ALT)");
			    labtestList.add("Albumin");
			    labtestList.add("Alkaline Phosphatase");
			    labtestList.add("Allergy Tests");
			    labtestList.add("Alpha-Fetoprotein (AFP)");
			    labtestList.add("Amylase");
			    labtestList.add("Antibody Tests (Coombs Test)");
			    labtestList.add("Antinuclear Antibodies (ANA");
			    labtestList.add("Aspartate Aminotransferase (AST)");
				
				 labtestList.add("Bicarbonate (Carbon Dioxide)");
			     labtestList.add("Bilirubin");
			     labtestList.add("Blood Culture");
			    labtestList.add("Blood Glucose");
			     labtestList.add("Blood Type");
			     labtestList.add("Blood Urea Nitrogen (BUN)");
			     labtestList.add("Breast Cancer (BRCA) Gene");

			     labtestList.add("C-Reactive Protein (CRP)");
			     labtestList.add("Calcium (Ca)");
			     labtestList.add("Cardiac Enzyme Studies");
			     labtestList.add("CD4+ Count");
			     labtestList.add("Chemistry Screen");
			     labtestList.add("Chlamydia Tests");
			     labtestList.add("Chloride (Cl)");
			     labtestList.add("Cholesterol and Triglycerides");
			     labtestList.add("Cobalamin");
			     labtestList.add("Complete Blood Count (CBC)");
			     labtestList.add("Coombs Test");
			     labtestList.add("Creatinine and Creatinine Clearance");

			     labtestList.add("Dexamethasone Suppression Test ");

			     labtestList.add("Electrolyte Panel ");
			     labtestList.add("Estrogens");

			     labtestList.add("Folic Acid");
			     labtestList.add("Follicle-Stimulating Hormone");

			     labtestList.add("Globulin");
			     labtestList.add("Glucose");
			     labtestList.add("Glycohemoglobin (HbA1c, A1c)");
			     labtestList.add("Gonorrhea");
			     labtestList.add("Growth Hormone"); 

			     labtestList.add("HDL Cholesterol");
			     labtestList.add("Helicobacter pylori");
			     labtestList.add("Hepatitis Panel");
			     labtestList.add("Homocysteine");
			     labtestList.add("Human Chorionic Gonadotropin (hCG)");
			     labtestList.add("Human Immunodeficiency Virus (HIV)");

			     labtestList.add("Iron (Fe)");

			     labtestList.add("Ketones");

			     labtestList.add("Lactic Acid Dehydrogenase (LDH)");
			     labtestList.add("LDL Cholesterol");
			     labtestList.add("Lead (Pb)");
			     labtestList.add("Liver Function Panel");

			     labtestList.add("Magnesium (Mg)");
			     labtestList.add("Microalbumin Urine Test");
			     labtestList.add("Mononucleosis");  

			     labtestList.add("Oral Glucose Tolerance Test");

			     labtestList.add("Parathyroid Hormone (PTH)");
			     labtestList.add("Partial Thromboplastin Time");
			     labtestList.add("Phosphate (Phosphorus)");
			     labtestList.add("Potassium (K) in Blood");
			     labtestList.add("Potassium (K) in Urine");
			     labtestList.add("Pregnancy Test");
			     labtestList.add("Progesterone");
			     labtestList.add("Prolactin");
			     labtestList.add("Prostate-Specific Antigen (PSA)");
			     labtestList.add("Prothrombin Time"); 
			     labtestList.add("Reticulocyte Count");
			     labtestList.add("Rheumatoid Factor (RF)");
			     labtestList.add("Rubella");
			     labtestList.add("Sedimentation Rate");
			     labtestList.add("Sickle Cell Test");
			     labtestList.add("Sodium (Na)");
			     labtestList.add("Stool Analysis");
			     labtestList.add("Stool Analysis for Giardiasis (Ova and Parasite Test)");
			     labtestList.add("Stool Antigen Test");
			     labtestList.add("Stool Culture");
			     labtestList.add("Syphilis ");

			     labtestList.add("Testosterone");
			     labtestList.add("Thyroid Hormone");
			     labtestList.add("Thyroid-Stimulating Hormone (TSH)");
			     labtestList.add("Total Serum Protein");

			     labtestList.add("Uric Acid");
			     labtestList.add("Urine Test");

			     labtestList.add("Viral Tests");
			     labtestList.add("Vitamin B12");
			     return labtestList;
		}*/
}
