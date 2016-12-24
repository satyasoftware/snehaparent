package com.satya.core.dao;
import java.util.Collection;
import java.util.List;

import com.satya.core.bean.Notes;
import com.satya.core.bean.Treatment;

public interface TreatmentDao {
	public Collection<Treatment> getTreatmentDocts(Collection<Long> doctIds,Long encounterId);
	public List<Notes> getEncounterNotes(Long encounterId);
}
