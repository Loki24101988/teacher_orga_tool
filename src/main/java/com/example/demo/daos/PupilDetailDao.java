package com.example.demo.daos;

import java.util.List;

import com.example.demo.pojos.Grade;
import com.example.demo.pojos.Note;
import com.example.demo.pojos.Schoolclass;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class PupilDetailDao {

	private String firstName;
	private String lastName;
	private Schoolclass schoolclass;
	private List<Note> notes;
	private List<Grade> grades;
}
