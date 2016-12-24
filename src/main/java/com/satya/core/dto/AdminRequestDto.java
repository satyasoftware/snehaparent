package com.satya.core.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Transient;

import com.satya.core.bean.FileVo;
import com.satya.core.bean.Institution;
import com.satya.core.bean.Provider;

public class AdminRequestDto {

		private Long admReqId;
@NotNull	private Long instId;
		private Long providerId;
		private String closedBy;
		private Date closeTime;
		private String admReqStatus; //Pending, Approved, Cancelled, Waiting
		private boolean status;
	    private Date createddate;
	    private Date updateddate;
	    private Long createdUserId;
	    private Long updateduserId;
		private List<FileVo> reqFiles;
		private String description;
		
		
	    // @Transient
	   // private List<MultipartFile> files;
	    
	       /*  @Transient
	         @NotNull private MultipartFile licencefile;
		     @Transient
		     @NotNull private MultipartFile govtIdfile;
		     
		     @Transient
		     private MultipartFile otherdocs1;
		     @Transient
			  private MultipartFile otherdocs2;
		     @Transient
			  private MultipartFile otherdoc;*/
		     
		     @Transient
              private Institution institution;
		     
		     @Transient
             private Provider provider;
		     
		  public Institution getInstitution() {
				return institution;
			}

		 public void setInstitution(Institution institution) {
				this.institution = institution;
			}

			
		public Provider getProvider() {
				return provider;
			}

			public void setProvider(Provider provider) {
				this.provider = provider;
			}

		/*public MultipartFile getOtherdoc() {
				return otherdoc;
			}

			public void setOtherdoc(MultipartFile otherdoc) {
				this.otherdoc = otherdoc;
			}

		public MultipartFile getLicencefile() {
				return licencefile;
			}

			public void setLicencefile(MultipartFile licencefile) {
				this.licencefile = licencefile;
			}

			public MultipartFile getGovtIdfile() {
				return govtIdfile;
			}

			public void setGovtIdfile(MultipartFile govtIdfile) {
				this.govtIdfile = govtIdfile;
			}

			public MultipartFile getOtherdocs1() {
				return otherdocs1;
			}

			public void setOtherdocs1(MultipartFile otherdocs1) {
				this.otherdocs1 = otherdocs1;
			}

			public MultipartFile getOtherdocs2() {
				return otherdocs2;
			}

			public void setOtherdocs2(MultipartFile otherdocs2) {
				this.otherdocs2 = otherdocs2;
			}
*/
		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Long getAdmReqId() {
			return admReqId;
		}

		public void setAdmReqId(Long admReqId) {
			this.admReqId = admReqId;
		}

		public Long getInstId() {
			return instId;
		}

		public void setInstId(Long instId) {
			this.instId = instId;
		}

		public Long getProviderId() {
			return providerId;
		}

		public void setProviderId(Long providerId) {
			this.providerId = providerId;
		}

		public String getClosedBy() {
			return closedBy;
		}

		public void setClosedBy(String closedBy) {
			this.closedBy = closedBy;
		}

		public Date getCloseTime() {
			return closeTime;
		}

		public void setCloseTime(Date closeTime) {
			this.closeTime = closeTime;
		}

		

		public String getAdmReqStatus() {
			return admReqStatus;
		}

		public void setAdmReqStatus(String admReqStatus) {
			this.admReqStatus = admReqStatus;
		}

		public boolean isStatus() {
			return status;
		}

		public void setStatus(boolean status) {
			this.status = status;
		}

		public Date getCreateddate() {
			return createddate;
		}

		public void setCreateddate(Date createddate) {
			this.createddate = createddate;
		}

		public Date getUpdateddate() {
			return updateddate;
		}

		public void setUpdateddate(Date updateddate) {
			this.updateddate = updateddate;
		}

		public Long getCreatedUserId() {
			return createdUserId;
		}

		public void setCreatedUserId(Long createdUserId) {
			this.createdUserId = createdUserId;
		}

		public Long getUpdateduserId() {
			return updateduserId;
		}

		public void setUpdateduserId(Long updateduserId) {
			this.updateduserId = updateduserId;
		}

		public List<FileVo> getReqFiles() {
			return reqFiles;
		}

		public void setReqFiles(List<FileVo> reqFiles) {
			this.reqFiles = reqFiles;
		}

}

