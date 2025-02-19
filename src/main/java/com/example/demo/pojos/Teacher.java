package com.example.demo.pojos;

import java.util.List;

import org.hibernate.annotations.UuidGenerator;
import org.hibernate.annotations.UuidGenerator.Style;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

	@Id
	@UuidGenerator(style = Style.AUTO)
	public String teacherId;
	
	public String firstName;
	
	private String lastName;
	
	@ManyToMany(mappedBy = "schoolclassTeachers")
	private List<Schoolclass> schoolclasses;
	
	@OneToMany(mappedBy = "creator", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Note> created;
	
	@OneToMany(mappedBy = "examiner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Grade> grades; 
	
}
