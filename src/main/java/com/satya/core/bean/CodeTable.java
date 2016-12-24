package com.satya.core.bean;

import java.util.Collection;
import java.util.TreeSet;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="CODETABLE")
public class CodeTable {  

	private static CodeTable codeTable;
	@Id
	private String id;
	private Collection<String> occupation;
	private Collection<String> govtId;
	private Collection<String> gender;
	private Collection<String> race;
	private @Transient Collection<String> provType;
	private Collection<InstitutionType> instType;
	
	private Collection<String> noteType;
	
	private CodeTable(){}
	public static CodeTable getInstance(){
		return codeTable;
	}
	public static void setInstance(CodeTable ct){
		codeTable = ct;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Collection<String> getOccupation() {
		return occupation;
	}
	public void setOccupation(Collection<String> occupation) {
		this.occupation = occupation;
	}
	public Collection<String> getGovtId() {
		return govtId;
	}
	public void setGovtId(Collection<String> govtId) {
		this.govtId = govtId;
	}
	public Collection<String> getGender() {
		return gender;
	}
	public void setGender(Collection<String> gender) {
		this.gender = gender;
	}
	public Collection<String> getRace() {
		return race;
	}
	public void setRace(Collection<String> race) {
		this.race = race;
	}
	public Collection<String> getProvType() {
		return provType;
	}
	public void setProvType(Collection<String> provType) {
		this.provType = provType;
	}
	public Collection<InstitutionType> getInstType() {
		return instType;
	}
	public void setInstType(Collection<InstitutionType> instType) {
		this.instType = instType;
	}
	public Collection<String> getNoteType() {
		return noteType;
	}
	public void setNoteType(Collection<String> noteType) {
		this.noteType = noteType;
	}
	@Override
	public String toString() {
		return "CodeTable [id=" + id + ", occupation=" + occupation + ", govtId=" + govtId + ", gender=" + gender
				+ ", race=" + race + ", provType=" + provType + ", instType=" + instType + ", noteType=" + noteType
				+ "]";
	}
	
	
		
}
