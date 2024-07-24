package com.example.demo.services;

import java.util.List;

import com.example.demo.form.FormCreateTeacher;
import com.example.demo.pojos.Teacher;

public interface TeacherService {

	public List<Teacher> getAllTeachers();
	
	public Teacher createNewTeacher(FormCreateTeacher formCreateTeacher);
}
