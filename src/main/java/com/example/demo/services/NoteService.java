package com.example.demo.services;

import java.util.List;

import com.example.demo.pojos.Note;
import com.example.demo.pojos.Pupil;
import com.example.demo.pojos.Teacher;

public interface NoteService {

	List<Note> getAllNotesForPupil(Pupil pupil);
	List<Note> getAllNotesForTeacher(Teacher teacher);
}
