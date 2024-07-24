package com.example.demo.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.UuidGenerator;
import org.hibernate.annotations.UuidGenerator.Style;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class Pupil {

	@Id
	@UuidGenerator(style = Style.AUTO)
	private String pupilId;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(nullable = false)
	private LocalDate dateOfBirth;
	
	@OneToMany(mappedBy = "receiver", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	private List<Note> notes;
	
	@ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name = "schoolclass_pupil_id", referencedColumnName = "schoolclassId")
	private Schoolclass schoolclass;
	
	public Pupil(String firstName, String lastName, LocalDate dateOfBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.notes = new ArrayList<>();
		this.grades = new ArrayList<>();
	}
	
	@OneToMany(mappedBy = "examinee", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	private List<Grade> grades;
}
