package com.example.demo.services;

import java.util.List;

import com.example.demo.pojos.Grade;
import com.example.demo.pojos.Pupil;
import com.example.demo.pojos.Teacher;

public interface GradeService {

	public List<Grade> getAllGradesForTeacher(Teacher teacher);
	public List<Grade> getAllGradesForPupilAndTeacherForActualYear(Teacher teacher, Pupil pupil);

}
