package com.example.demo.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exceptions.PupilNotfoundForIdException;
import com.example.demo.exceptions.TeacherNotFoundException;
import com.example.demo.form.FormNoteForPupil;
import com.example.demo.pojos.Note;
import com.example.demo.pojos.Pupil;
import com.example.demo.pojos.Teacher;
import com.example.demo.repositories.NoteRepository;

@Service
public class NoteServiceImpl implements NoteService {

	private NoteRepository noteRepository;
	
	private PupilService pupilService;
	
	private TeacherService teacherService;
	
	public NoteServiceImpl(NoteRepository noteRepository, 
			PupilService pupilService, 
			TeacherService teacherService) {
		this.noteRepository = noteRepository;
		this.pupilService = pupilService;
		this.teacherService = teacherService;
	}

	@Override
	public List<Note> getAllNotesForPupil(Pupil pupil) {
		List<Note> findByReceiver = this.noteRepository.findByReceiverOrderByCreatedAtDesc(pupil);
		return findByReceiver;
	}

	@Override
	public List<Note> getAllNotesForTeacher(Teacher teacher) {
		List<Note> findByCreator = this.noteRepository.findByCreator(teacher);
		return findByCreator;
	}

	@Override
	public Note storeNote(Note note) {
		Note save = this.noteRepository.save(note);
		return save;
	}

	@Override
	public Note storeNote(FormNoteForPupil formNote) throws PupilNotfoundForIdException, TeacherNotFoundException {
		Note newNote = Note.builder()
		.receiver(this.pupilService.getPupilForId(formNote.getPupilId()))
		.creator(this.teacherService.getTeacherForIs(formNote.getTeacherId()))
		.content(formNote.getContent())
		.createdAt(LocalDateTime.now())
		.build();
		Note save = this.noteRepository.save(newNote);
		return save;
	}
	
	

}
