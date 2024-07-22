package com.example.demo.services;

import java.util.List;

import com.example.demo.pojos.FormPupil;
import com.example.demo.pojos.Note;
import com.example.demo.pojos.Pupil;
import com.example.demo.pojos.Schoolclass;
import com.example.demo.pojos.Teacher;

public interface PupilService {
	
	public List<Pupil> getAllPupils();
	
	public Pupil createNewPupil(Pupil pupil);
	
	public Pupil addNoteToPupil(Pupil pupil, Note note);
	
	public List<Pupil> getAllPupilsForTeacher(Teacher teacher);
	
	public List<Pupil> getAllPupilsForSchoolclass(Schoolclass schoolclass);
	
	public Pupil createNewPupilFromFormPupil(FormPupil formPupil);
}
