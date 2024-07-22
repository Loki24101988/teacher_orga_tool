package com.example.demo.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.example.demo.pojos.FormPupil;
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
		if(note.getNoteId().equals("")) {
			return false;
		}
		
		if(pupil.getNotes().stream().map(n -> n.getNoteId()).filter(n -> note.getNoteId().equals(n)).toList().size() > 0) {
			return true;
		}
		
		return false;
	}

	@Override
	public List<Pupil> getAllPupilsForTeacher(Teacher teacher) {
		Stream<Pupil> filter = this.pupilRepository.findAll().stream()
		.filter(p -> p.getSchoolclass().getSchoolclassTeacher().teacherId.equals(teacher.teacherId));
		List<Pupil> collect = filter.collect(Collectors.toList());
		return collect;
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
}
