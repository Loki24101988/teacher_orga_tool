package com.example.demo.pojos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.UuidGenerator;
import org.hibernate.annotations.UuidGenerator.Style;

import com.example.demo.enums.GradeTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Grade {

	@Id
	@UuidGenerator(style = Style.AUTO)
	private String gradeId;	 
	
	@Column(nullable = false)
	private BigDecimal grade;
	
	@ManyToOne
	@JoinColumn(name = "pupilId", referencedColumnName = "pupilId")
	private Pupil examinee;
	
	@Column(updatable = false)
	private LocalDateTime createdAt;
	
	@ManyToOne
	@JoinColumn(name = "examinerId", referencedColumnName = "teacherId")
	private Teacher examiner;
	
	private GradeTypes gradeType;
}
