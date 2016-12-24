package com.satya.core.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.satya.core.beanLimit.ProviderL;

@Document(collection="NOTES")
public class Notes extends Creation{
	@Id private Long notesId;
	    private Long encounterId;
	    private  String doctorNote;
	    private String doctNoteType;
	    private String stickystatus;// O-open or D-deleted  or N-not a tricky
	    @DBRef
	    private ProviderL providerL;
	    private String provType;
	    
	    public String getStickystatus() {
			return stickystatus;
		}
		public void setStickystatus(String stickystatus) {
			this.stickystatus = stickystatus;
		}
		public Long getNotesId() {
			return notesId;
		}
		public void setNotesId(Long notesId) {
			this.notesId = notesId;
		}
		
		/*public char getStickystatus() {
			return stickystatus;
		}
		public void setStickystatus(char stickystatus) {
			this.stickystatus = stickystatus;
		}*/
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
		public ProviderL getProviderL() {
			return providerL;
		}
		public void setProviderL(ProviderL providerL) {
			this.providerL = providerL;
		}
		public String getProvType() {
		     return provType;
		}
		public void setProvType(String provType) {
			this.provType = provType;
		}
		@Override
		public String toString() {
			return "Notes [stickystatus=" + stickystatus + "]";
		}
	 
}
