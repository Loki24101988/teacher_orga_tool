package com.example.demo.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.exceptions.PupilNotfoundForIdException;
import com.example.demo.form.FormNoteForPupil;
import com.example.demo.form.FormPupil;
import com.example.demo.pojos.Note;
import com.example.demo.pojos.Pupil;
import com.example.demo.pojos.Schoolclass;
import com.example.demo.pojos.Teacher;
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
		if(note == null) {
			return false;
		}
		
		if("".equals(note.getNoteId())) {
			return false;
		}
		
		if(pupil.getNotes() == null) {
			return false;
		}
		
		if(pupil.getNotes().stream().map(n -> n.getNoteId()).filter(n -> note.getNoteId().equals(n)).toList().size() > 0) {
			return true;
		}
		
		return false;
	}

	@Override
	public List<Pupil> getAllPupilsForTeacher(Teacher teacher) {
		List<Pupil> allPupilsForTeacher = new ArrayList<>();
		for(Schoolclass schoolclass: teacher.getSchoolclasses()) {
			List<Pupil> allPupilsForSchoolclass = this.getAllPupilsForSchoolclass(schoolclass);
			allPupilsForTeacher.addAll(allPupilsForSchoolclass);
		}
		
		return allPupilsForTeacher;
	}

	@Override
	public List<Pupil> getAllPupilsForSchoolclass(Schoolclass schoolclass) {
		if(schoolclass == null) {
			return List.of();
		}
		List<Pupil> findBySchoolclass = this.pupilRepository.findBySchoolclass(schoolclass);
		return findBySchoolclass;
	}

	@Override
	public Pupil createNewPupilFromFormPupil(FormPupil formPupil) {
		Pupil pupil = new Pupil(formPupil.getFirstName(), formPupil.getLastName(), LocalDate.now());
		Pupil createNewPupil = this.createNewPupil(pupil);
		return createNewPupil;
	}

	@Override
	public Pupil getPupilForId(String pupilId) throws PupilNotfoundForIdException {
		Optional<Pupil> findById = this.pupilRepository.findById(pupilId);
		return findById.orElseThrow(() -> new PupilNotfoundForIdException("No pupil found for pupilId: " + pupilId));
	}

	@Override
	public Pupil storePupil(Pupil pupilToStore) {
		Pupil saved = this.pupilRepository.save(pupilToStore);
		return saved;
	}

	@Override
	public Pupil addNoteToPupil(FormNoteForPupil formNoteForPupil) {
		String pupilId = formNoteForPupil.getPupilId();
		if(pupilId == null || "".equals(pupilId)) {
			return null;
		}
		Optional<Pupil> findById = this.pupilRepository.findById(pupilId);
		if(findById.isEmpty()) {
			return null;
		}
		Pupil pupil = findById.get();
		pupil.getNotes().add(new Note(formNoteForPupil.getContent(), pupil, new Teacher()));
		Pupil save = this.pupilRepository.save(pupil);
		return save;
	}

	@Override
	public Pupil deleteAllNotesForPupil(Pupil pupil) {
		pupil.setNotes(new ArrayList<>());
		Pupil save = this.pupilRepository.save(pupil);
		return save;
	}

	@Override
	public void deletePupilFromDatabase(Pupil pupil) {
		this.pupilRepository.deleteById(pupil.getPupilId());
			
	}

	@Override
	public void deletePupilByIdfromDatabase(String pupilId) {
		this.pupilRepository.deleteById(pupilId);		
	}
}
