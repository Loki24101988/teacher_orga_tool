package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojos.Grade;
import java.util.List;
import com.example.demo.pojos.Teacher;
import com.example.demo.pojos.Pupil;
import java.time.LocalDateTime;


public interface GradeRepository extends JpaRepository<Grade, String>{

	public List<Grade> findByExaminerAndExamineeAndCreatedAt(Teacher examiner, Pupil examinee, LocalDateTime createdAt);
	public List<Grade> findByExaminerAndExaminee(Teacher examiner, Pupil examinee);
	public List<Grade> findByExaminer(Teacher examiner);
}
