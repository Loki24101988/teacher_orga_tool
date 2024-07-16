package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.pojos.Schoolclass;
import com.example.demo.repositories.SchoolclassRepository;

@Service
public class SchoolclassServiceImpl implements SchoolclassService {

	private SchoolclassRepository schoolclassRepository;
	
	public SchoolclassServiceImpl(SchoolclassRepository schoolclassRepository) {
		this.schoolclassRepository = schoolclassRepository;
	}

	@Override
	public List<Schoolclass> getAllSchoolclasses() {
		List<Schoolclass> findAll = this.schoolclassRepository.findAll();
		return findAll;
	}
}
