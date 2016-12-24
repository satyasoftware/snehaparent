package com.satya.core.bean;

import java.util.Date;

public class Creation {
	
	// private Long patId;
	 //private Long encountId;
	 private Date createTs;
     private Date updateTs;
     private Long createdUId;
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
/*	public Long getPatId() {
		return patId;
	}
	public void setPatId(Long patId) {
		this.patId = patId;
	}
	public Long getEncountId() {
		return encountId;
	}
	public void setEncountId(Long encountId) {
		this.encountId = encountId;
	}*/
     
	
     
}
