package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.form.FormCreateTeacher;
import com.example.demo.pojos.Teacher;
import com.example.demo.repositories.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService {
	
	private TeacherRepository teacherRepository;
	
	public TeacherServiceImpl(TeacherRepository teacherRepository) {
		this.teacherRepository = teacherRepository;
	}

	@Override
	public List<Teacher> getAllTeachers() {
		List<Teacher> findAll = this.teacherRepository.findAll();
		return findAll;
	}

	@Override
	public Teacher createNewTeacher(FormCreateTeacher formCreateTeacher) {
		Teacher newTeacher = Teacher
		.builder()
		.firstName(formCreateTeacher.getFirstName())
		.lastName(formCreateTeacher.getLastName())
		.build();
		Teacher save = this.teacherRepository.save(newTeacher);
		return save;
	}
	
	
}
