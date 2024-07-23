package com.example.demo.services;

import java.util.List;

import com.example.demo.pojos.Schoolclass;
import com.example.demo.pojos.Teacher;

public interface SchoolclassService {

	public List<Schoolclass> getAllSchoolclasses();
	
	public Schoolclass createSchoolclass(String schoolclassName);
	
	public Schoolclass addTeacherToSchoolclass(Schoolclass schoolclass, Teacher Teacher);
}
