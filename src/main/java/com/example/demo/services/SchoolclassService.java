package com.example.demo.services;

import java.util.List;

import com.example.demo.pojos.Pupil;
import com.example.demo.pojos.Schoolclass;
import com.example.demo.pojos.Teacher;

public interface SchoolclassService {

	public List<Schoolclass> getAllSchoolclasses();
	
	public Schoolclass createSchoolclass(String schoolclassName);
	
	public Schoolclass addTeacherToSchoolclass(Schoolclass schoolclass, Teacher teacher);
	
	public Schoolclass addPupilToSchoolclass(Schoolclass schoolclass, Pupil pupil);
	
	public Schoolclass getSchoolclassByName(String schoolclassName);
}
