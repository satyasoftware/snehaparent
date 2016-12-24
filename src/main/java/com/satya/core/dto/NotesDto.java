package com.satya.core.dto;

import java.util.Comparator;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;


public class NotesDto extends CreationDto{
	
	           private Long notesId;
	@NotNull   private Long encounterId;
	@NotEmpty  private  String doctorNote;
	@NotEmpty  private String doctNoteType;
	           private String shortnote;
               private Long providerId;
               private String provType;
               private String stickystatus;
             @Transient  private boolean updatestatus; 
               
               public boolean isUpdatestatus() {
				return updatestatus;
			}
			public void setUpdatestatus(boolean updatestatus) {
				this.updatestatus = updatestatus;
			}
			public String getStickystatus() {
				return stickystatus;
			}
			public void setStickystatus(String stickystatus) {
				this.stickystatus = stickystatus;
			}
	/*public char getStickystatus() {
       			return stickystatus;
       		}
       		public void setStickystatus(char stickystatus) {
       			this.stickystatus = stickystatus;
       		}*/
	public String getProvType() {
				return provType;
			}
	public void setProvType(String provType) {
				this.provType = provType;
			}
	public String getShortnote() {
		return shortnote;
	}
	public void setShortnote(String shortnote) {
		this.shortnote = shortnote;
	}
	public Long getNotesId() {
		return notesId;
	}
	public void setNotesId(Long notesId) {
		this.notesId = notesId;
	}
	public Long getEncounterId() {
		return encounterId;
	}
	public void setEncounterId(Long encounterId) {
		this.encounterId = encounterId;
	}
	public String getDoctorNote() {
		return doctorNote;
	}
	public void setDoctorNote(String doctorNote) {
		this.doctorNote = doctorNote;
	}
	public String getDoctNoteType() {
		return doctNoteType;
	}
	public void setDoctNoteType(String doctNoteType) {
		this.doctNoteType = doctNoteType;
	}
	public Long getProviderId() {
		return providerId;
	}
	public void setProviderId(Long providerId) {
		this.providerId = providerId;
	}
	@Override
	public String toString() {
		return "NotesDto [stickystatus=" + stickystatus + ", getCreateTs()=" + getCreateTs() + "]";
	}

}
