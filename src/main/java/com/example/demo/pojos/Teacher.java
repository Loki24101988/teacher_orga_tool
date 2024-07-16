package com.example.demo.pojos;

import java.util.List;

import org.hibernate.annotations.UuidGenerator;
import org.hibernate.annotations.UuidGenerator.Style;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Teacher {

	@Id
	@UuidGenerator(style = Style.AUTO)
	public String teacherId;
	
	@OneToMany(mappedBy = "schoolclassTeacher", fetch = FetchType.LAZY)
	private List<Schoolclass> schoolclasses;
	
	@OneToMany(mappedBy = "creator", fetch = FetchType.LAZY)
	private List<Note> created;
	
	@OneToMany(mappedBy = "examiner", fetch = FetchType.LAZY)
	private List<Grade> grades; 
	
}
