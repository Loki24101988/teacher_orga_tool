package com.example.demo.services;

import java.util.List;

import com.example.demo.exceptions.PupilNotfoundForIdException;
import com.example.demo.exceptions.TeacherNotFoundException;
import com.example.demo.form.FormNoteForPupil;
import com.example.demo.pojos.Note;
import com.example.demo.pojos.Pupil;
import com.example.demo.pojos.Teacher;

public interface NoteService {

	List<Note> getAllNotesForPupil(Pupil pupil);
	List<Note> getAllNotesForTeacher(Teacher teacher);
	
	Note storeNote(Note note);
	
	Note storeNote(FormNoteForPupil formNote) throws PupilNotfoundForIdException, TeacherNotFoundException;
}
