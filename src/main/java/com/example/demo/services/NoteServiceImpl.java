package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.pojos.Note;
import com.example.demo.pojos.Pupil;
import com.example.demo.pojos.Teacher;
import com.example.demo.repositories.NoteRepository;

@Service
public class NoteServiceImpl implements NoteService {

	private NoteRepository noteRepository;
	
	public NoteServiceImpl(NoteRepository noteRepository) {
		this.noteRepository = noteRepository;
	}

	@Override
	public List<Note> getAllNotesForPupil(Pupil pupil) {
		List<Note> findByReceiver = this.noteRepository.findByReceiver(pupil);
		return findByReceiver;
	}

	@Override
	public List<Note> getAllNotesForTeacher(Teacher teacher) {
		List<Note> findByCreator = this.noteRepository.findByCreator(teacher);
		return findByCreator;
	}
}
