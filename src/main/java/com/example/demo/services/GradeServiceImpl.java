package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.pojos.Grade;
import com.example.demo.pojos.Pupil;
import com.example.demo.pojos.Teacher;
import com.example.demo.repositories.GradeRepository;

@Service
public class GradeServiceImpl implements GradeService {
	
	private GradeRepository gradeRepository;
	
	public GradeServiceImpl(GradeRepository gradeRepository) {
		this.gradeRepository = gradeRepository;
	}

	@Override
	public List<Grade> getAllGradesForTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Grade> getAllGradesForPupilAndTeacherForActualYear(Teacher teacher, Pupil pupil) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
