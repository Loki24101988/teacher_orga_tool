package com.example.demo.services;

import java.util.List;

import com.example.demo.form.FormNoteForPupil;
import com.example.demo.form.FormPupil;
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
	
	public Pupil addNoteToPupil(FormNoteForPupil formNoteForPupil);
	
	public Pupil getPupilForId(String pupilId);
	
	public Pupil storePupil(Pupil pupilToStore);
	
	public Pupil deleteAllNotesForPupil(Pupil pupil);
	
	public void deletePupilFromDatabase(Pupil pupil);
	
	public void deletePupilByIdfromDatabase(String pupilId);
}
