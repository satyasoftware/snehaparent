package com.satya.core.dto;

import java.util.Date;

public class CreationDto {
	 private Date createTs;
     private Date updateTs;
     private Long createdUId;
     private String createduser;
     private Long updateUId;
     private Boolean status;
	public Date getCreateTs() {
		return createTs;
	}
	public void setCreateTs(Date createTs) {
		this.createTs = createTs;
	}
	public Date getUpdateTs() {
		return updateTs;
	}
	public void setUpdateTs(Date updateTs) {
		this.updateTs = updateTs;
	}
	public Long getCreatedUId() {
		return createdUId;
	}
	public void setCreatedUId(Long createdUId) {
		this.createdUId = createdUId;
	}
	public Long getUpdateUId() {
		return updateUId;
	}
	public void setUpdateUId(Long updateUId) {
		this.updateUId = updateUId;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getCreateduser() {
		return createduser;
	}
	public void setCreateduser(String createduser) {
		this.createduser = createduser;
	}
     
}
