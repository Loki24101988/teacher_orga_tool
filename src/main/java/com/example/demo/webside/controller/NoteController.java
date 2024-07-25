package com.example.demo.webside.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.exceptions.PupilNotfoundForIdException;
import com.example.demo.form.FormNoteForPupil;
import com.example.demo.pojos.Pupil;
import com.example.demo.services.NoteService;
import com.example.demo.services.PupilService;

import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("/website")
public class NoteController {
	
	private PupilService pupilService;
	private NoteService noteService;
	
	public NoteController(PupilService pupilService, NoteService noteService) {
		this.noteService = noteService;
		this.pupilService = pupilService;
	}
	
	@PostMapping("/addnote")
	public String addNoteForPupil(@ModelAttribute("formNoteForPupil") FormNoteForPupil formNoteForPupil, Model model) throws PupilNotfoundForIdException {
		Pupil pupilForId = this.pupilService.getPupilForId(formNoteForPupil.getPupilId());
		
		
		return "redirect:pupils";
	}

}
