package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojos.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, String> {

	
}
