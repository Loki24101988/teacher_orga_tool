package com.example.demo.daos;

import java.util.List;

import com.example.demo.pojos.Note;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PupilDao {

	private String firstName;
	private String lastName;
	private String pupilId;
	private List<Note> notes;
}
