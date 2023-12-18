package com.example.demo.pojos;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	public String teacherId;
	
	@ManyToMany
	@JoinTable(name = "teacher_classes", joinColumns = @JoinColumn(name = "schoolclassId"),
	inverseJoinColumns = @JoinColumn(name = "teacherId"))
	private List<Schoolclass> classes;
}
