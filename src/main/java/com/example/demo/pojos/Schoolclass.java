package com.example.demo.pojos;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Schoolclass {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String schoolclassId;
	
	@OneToMany(mappedBy = "schoolclass", cascade = CascadeType.ALL)
	private List<Pupil> schoolclassMember;
	
	@Column(unique = true, nullable = false)
	private String schoolclassName;
	
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "schoolclass_teacher_id", referencedColumnName = "teacherId")
	private Teacher schoolclassTeacher;
	
	@OneToMany(mappedBy = "schoolclass")
	private List<Pupil> pupils;
}
