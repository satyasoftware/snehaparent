package com.satya.core.jsonresponse;

import java.util.Collection;
import java.util.List;

import com.satya.core.bean.Encounter;
import com.satya.core.dto.ConsultDto;
import com.satya.core.dto.LabOrderDto;
import com.satya.core.dto.MedicalOrderDto;
import com.satya.core.dto.NotesDto;
import com.satya.core.dto.OtherOrdersDto;
import com.satya.core.dto.VitalsDto;

public class EncounterResponse extends Response {

	private List<Encounter> encounterList;
	private Object result = null;
	private Collection<NotesDto> notesList;
	private Collection<VitalsDto> vitalList;
	private Collection<MedicalOrderDto> medicaList;
	private Collection<LabOrderDto> laborderList;
	private Collection<ConsultDto> consultList; 
	private Collection<OtherOrdersDto> othorderList;
	
	public List<Encounter> getEncounterList() {
		return encounterList;
	}

	public void setEncounterList(List<Encounter> encounterList) {
		this.encounterList = encounterList;
	}
	
	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public Collection<NotesDto> getNotesList() {
		return notesList;
	}

	public void setNotesList(Collection<NotesDto> notesList) {
		this.notesList = notesList;
	}

	public Collection<VitalsDto> getVitalList() {
		return vitalList;
	}

	public void setVitalList(Collection<VitalsDto> vitalList) {
		this.vitalList = vitalList;
	}

	public Collection<MedicalOrderDto> getMedicaList() {
		return medicaList;
	}

	public void setMedicaList(Collection<MedicalOrderDto> medicaList) {
		this.medicaList = medicaList;
	}

	public Collection<LabOrderDto> getLaborderList() {
		return laborderList;
	}

	public void setLaborderList(Collection<LabOrderDto> laborderList) {
		this.laborderList = laborderList;
	}

	public Collection<ConsultDto> getConsultList() {
		return consultList;
	}

	public void setConsultList(Collection<ConsultDto> consultList) {
		this.consultList = consultList;
	}

	public Collection<OtherOrdersDto> getOthorderList() {
		return othorderList;
	}

	public void setOthorderList(Collection<OtherOrdersDto> othorderList) {
		this.othorderList = othorderList;
	}

}
