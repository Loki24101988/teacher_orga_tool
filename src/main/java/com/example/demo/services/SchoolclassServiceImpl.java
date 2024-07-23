package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.pojos.Schoolclass;
import com.example.demo.pojos.Teacher;
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

	@Override
	public Schoolclass createSchoolclass(String schoolclassName) {
		List<Schoolclass> findBySchoolclassName = this.schoolclassRepository.findBySchoolclassName(schoolclassName);
		if(findBySchoolclassName.size() != 0) {
			return findBySchoolclassName.get(0);
		}
		Schoolclass schoolclass = new Schoolclass(schoolclassName);
		Schoolclass save = this.schoolclassRepository.save(schoolclass);
		return save;
	}

	@Override
	public Schoolclass addTeacherToSchoolclass(Schoolclass schoolclass, Teacher Teacher) {
		// TODO Auto-generated method stub
		return null;
	}
}
