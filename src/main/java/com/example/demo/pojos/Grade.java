package com.example.demo.pojos;

import java.math.BigDecimal;

import org.hibernate.annotations.UuidGenerator;
import org.hibernate.annotations.UuidGenerator.Style;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Grade {

	@Id
	@UuidGenerator(style = Style.AUTO)
	private String gradeId;	 
	
	@Column(nullable = false)
	private BigDecimal grade;
	
	@ManyToOne
	@JoinColumn(name = "pupilId")
	private Pupil graduate;
}
