package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.pojos.Pupil;
import com.example.demo.pojos.Schoolclass;

import java.util.List;


@Repository
public interface PupilRepository extends JpaRepository<Pupil, String>{
	
	List<Pupil> findBySchoolclass(Schoolclass schoolclass);
}
