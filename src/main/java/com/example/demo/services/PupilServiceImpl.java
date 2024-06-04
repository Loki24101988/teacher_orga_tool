package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.pojos.Note;
import com.example.demo.pojos.Pupil;
import com.example.demo.repositories.PupilRepository;

@Service
public class PupilServiceImpl implements PupilService {

	private PupilRepository pupilRepository;
	
	public PupilServiceImpl(PupilRepository pupilRepository) {
		this.pupilRepository = pupilRepository;
	}
	
	public List<Pupil> getAllPupils() {
		return this.pupilRepository.findAll();
	}
	
	public Pupil createNewPupil(Pupil pupil) {
		Pupil save = this.pupilRepository.save(pupil);
		return save;
	}
	
	public Pupil addNoteToPupil(Pupil pupil, Note note) {
		if(!isNoteAlredyAddedToPupil(pupil, note)) {
			pupil.getNotes().add(note);
		}
		
		Pupil save = this.pupilRepository.save(pupil);
		return save;
	}
	
	private boolean isNoteAlredyAddedToPupil(Pupil pupil, Note note) {
		if(note.getNoteId().equals("")) {
			return false;
		}
		
		if(pupil.getNotes().stream().map(n -> n.getNoteId()).filter(n -> note.getNoteId().equals(n)).toList().size() > 0) {
			return true;
		}
		
		return false;
	}
}
