package com.example.demo.pojos;

import java.time.LocalDateTime;

import org.hibernate.annotations.UuidGenerator;
import org.hibernate.annotations.UuidGenerator.Style;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	@UuidGenerator(style = Style.AUTO)
	private String noteId;
	
	@Lob
	@Column(columnDefinition = "TEXT")
	private String content;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "receiver_Id", referencedColumnName = "pupilId")
	private Pupil receiver;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "creator_id", referencedColumnName = "teacherId")
	private Teacher creator;
	
	@Column(updatable = false)
	private LocalDateTime createdAt;
}
