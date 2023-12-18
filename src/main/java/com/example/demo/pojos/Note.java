package com.example.demo.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String noteId;
	
	@Lob
	@Column(columnDefinition = "TEXT")
	private String content;
	
	@ManyToOne
	@JoinColumn(name = "pupilId")
	private Pupil receiver;
}
