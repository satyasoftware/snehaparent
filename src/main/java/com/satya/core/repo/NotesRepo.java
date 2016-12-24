package com.satya.core.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.satya.core.bean.Notes;


public interface NotesRepo extends MongoRepository<Notes, Long> {

	// @Query( fields="{_id : 1}") 
	List<Notes> findTop6ByEncounterIdOrderByCreateTsDesc(Long encounterId);
	List<Notes> findTop10ByEncounterIdOrderByNotesIdDesc(Long encounterId);
	List<Notes> findTop10ByEncounterIdAndStickystatusOrderByNotesIdDesc(Long encounterId,String status);
	Notes findByEncounterIdAndNotesId(Long encounterId,Long noteId);
	List<Notes> findTop10ByEncounterIdOrderByStickystatus(Long encounterId);
	List<Notes> findTop10ByEncounterIdAndStickystatusNotOrderByNotesIdDesc(Long encounterId,String status);
}
