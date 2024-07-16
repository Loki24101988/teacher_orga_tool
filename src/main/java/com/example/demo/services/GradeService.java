package com.example.demo.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.enums.GradeTypes;
import com.example.demo.pojos.Grade;
import com.example.demo.pojos.Pupil;
import com.example.demo.pojos.Teacher;

public interface GradeService {

	public List<Grade> getAllGradesForTeacher(Teacher teacher);
	public List<Grade> getAllGradesForPupilAndTeacherForActualYear(Teacher teacher, Pupil pupil);
	public List<Grade> getAllGradesForPupilAndTeacherForSpecialYear(Teacher teacher, Pupil pupil, LocalDateTime specialYear);
	
	public Boolean createNewGrade(BigDecimal value, Teacher examiner, Pupil examinee, GradeTypes type);

}
