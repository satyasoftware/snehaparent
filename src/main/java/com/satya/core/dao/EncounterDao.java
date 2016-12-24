package com.satya.core.dao;

import java.util.List;

import com.satya.core.bean.Encounter;

public interface EncounterDao {

	public Long getEncounterId();
	public Long getTreatmentId();
	public List<Encounter> getInstEncounters(Long instId);
}
