package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.exceptions.SchoolclassNotFoundException;
import com.example.demo.pojos.Pupil;
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
		Optional<Schoolclass> findBySchoolclassName = this.schoolclassRepository.findBySchoolclassName(schoolclassName);
		if(findBySchoolclassName.isPresent()) {
			return findBySchoolclassName.get();
		}
		Schoolclass schoolclass = new Schoolclass(schoolclassName);
		Schoolclass save = this.schoolclassRepository.save(schoolclass);
		return save;
	}

	@Override
	public Schoolclass addTeacherToSchoolclass(Schoolclass schoolclass, Teacher teacher) {
		if(schoolclass == null || teacher == null) {
			return schoolclass;
		}
		
		schoolclass.getSchoolclassTeachers().add(teacher);
		Schoolclass save = this.schoolclassRepository.save(schoolclass);
		return save;
	}

	@Override
	public Schoolclass addPupilToSchoolclass(Schoolclass schoolclass, Pupil pupil) {
		if(schoolclass == null || pupil == null) {
			return schoolclass;
		}
		
		List<Pupil> schoolclassMember = schoolclass.getSchoolclassMember();
		
		if(!pupilIsInSchoolclass(schoolclassMember, pupil)) {
			schoolclassMember.add(pupil);
			schoolclass.setSchoolclassMember(schoolclassMember);
			Schoolclass save = this.schoolclassRepository.save(schoolclass);
			return save;
		} 
		return schoolclass;
	}

	private boolean pupilIsInSchoolclass(List<Pupil> schoolclassMember, Pupil pupil) {
		for(Pupil inClass: schoolclassMember) {
			if(inClass.getPupilId().equals(pupil.getPupilId())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Schoolclass getSchoolclassByName(String schoolclassName) throws SchoolclassNotFoundException {
		Optional<Schoolclass> findBySchoolclassName = this.schoolclassRepository.findBySchoolclassName(schoolclassName);
		return findBySchoolclassName.orElseThrow(() -> new SchoolclassNotFoundException("Schoolclass with name: " + schoolclassName + " cannot be found"));
	}
}
