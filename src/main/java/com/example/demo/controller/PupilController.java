package com.example.demo.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.pojos.Pupil;
import com.example.demo.services.PupilServiceImpl;

@Controller
public class PupilController {
	
	private PupilServiceImpl pupilService;
	
	public PupilController(PupilServiceImpl pupilService) {
		this.pupilService = pupilService;
	}

	@GetMapping("pupils2")
	public ResponseEntity<List<Pupil>> getAllPupils() {
		List<Pupil> allPupils = this.pupilService.getAllPupils();
		return new ResponseEntity<>(allPupils, HttpStatus.OK);
	}
	
	@PostMapping(path = "pupils/firstname/{firstName}/lastname/{lastName}/dateofbirth/{dateOfBirth}")
	public ResponseEntity<Pupil> createNewPupil(@PathVariable String firstName, @PathVariable String lastName, @PathVariable String dateOfBirth) {
		final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		final LocalDate dateOfBirth1 = LocalDate.parse(dateOfBirth, dtf);
		Pupil pupil = new Pupil(firstName, lastName, dateOfBirth1);
		Pupil savedPupil = this.pupilService.createNewPupil(pupil);
		return new ResponseEntity<>(savedPupil, HttpStatus.OK);
	}
}
