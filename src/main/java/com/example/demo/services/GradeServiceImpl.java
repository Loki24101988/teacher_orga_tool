package com.example.demo.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.enums.GradeTypes;
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
		List<Grade> findByExaminer = this.gradeRepository.findByExaminer(teacher);
		return findByExaminer;
	}

	@Override
	public List<Grade> getAllGradesForPupilAndTeacherForActualYear(Teacher teacher, Pupil pupil) {
		List<Grade> findByExaminerAndExaminee = this.gradeRepository.findByExaminerAndExaminee(teacher, pupil);
		int actualYear = LocalDateTime.now().getYear();
		List<Grade> collect = findByExaminerAndExaminee.stream().filter(grade -> grade.getCreatedAt().getYear() == actualYear).collect(Collectors.toList());
		return collect;
	}

	@Override
	public Grade createNewGrade(BigDecimal value, Teacher examiner, Pupil examinee, GradeTypes type) {
		Grade newGrade = Grade.builder().examiner(examiner).examinee(examinee).createdAt(LocalDateTime.now()).gradeType(type).build();
		Grade save = this.gradeRepository.save(newGrade);
		return save;
	}

	@Override
	public List<Grade> getAllGradesForPupilAndTeacherForSpecialYear(Teacher teacher, Pupil pupil,
			LocalDateTime specialYear) {
		List<Grade> findByExaminerAndExaminee = this.gradeRepository.findByExaminerAndExaminee(teacher, pupil);
		List<Grade> collect = findByExaminerAndExaminee.stream().filter(grade -> grade.getCreatedAt().getYear() == specialYear.getYear())
		.collect(Collectors.toList());
		return collect;
	}

	
}
