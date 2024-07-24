package com.example.demo.webside.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.daos.PupilDao;
import com.example.demo.form.FormDeletePupil;
import com.example.demo.form.FormNoteForPupil;
import com.example.demo.form.FormPupil;
import com.example.demo.form.FormPupilDetail;
import com.example.demo.pojos.Note;
import com.example.demo.pojos.Pupil;
import com.example.demo.services.PupilService;

@Controller
@RequestMapping("/website")
public class WebsiteController {

	private PupilService pupilService;
	private Converter<Pupil, PupilDao> converter;
	
	public WebsiteController(PupilService pupilService, Converter<Pupil, PupilDao> converter) {
		this.pupilService = pupilService;
		this.converter = converter;
	}
	
	@GetMapping("/index")
	public String getIndex(Model model) {
		model.addAttribute("Teacher", "Hans");
		return "index";
	}
	
	@GetMapping("/pupils")
	public String getPupilSite(Model model) {
		List<Pupil> allPupils = this.pupilService.getAllPupils();
		
		model.addAttribute("headerName", "Name");
		model.addAttribute("headerClass", "Klasse");
		model.addAttribute("headerId", "ID");
		model.addAttribute("pupils", this.convertPupilList(allPupils));
		model.addAttribute("formPupil", new FormPupil());
		model.addAttribute("formNote", new FormNoteForPupil());
		model.addAttribute("formDelete", new FormDeletePupil());
		model.addAttribute("formDetailDao", new FormPupilDetail());
		return "pupils";
	}
	
	@PostMapping("/pupils")
	public String createNewPupil(@ModelAttribute("formPupil") FormPupil pupil, BindingResult result, Model model) {
		if(result.hasErrors()) {
			System.out.println(result.getErrorCount());
			return "pupils";
		}
		Pupil createNewPupil = this.pupilService.createNewPupilFromFormPupil(pupil);
		return "redirect:pupils";
	}
	
	@PostMapping("/addNoteForPupil")
	public String addNoteToPupil(@ModelAttribute("formNote") FormNoteForPupil formNote) {
		Pupil addNoteToPupil = this.pupilService.addNoteToPupil(formNote);
		return "redirect:pupils";
	}
	
	@PostMapping("/deletePupil")
	public String deletePupilFromDatabase(@ModelAttribute("formDelete") FormDeletePupil pupil) {
		this.pupilService.deletePupilByIdfromDatabase(pupil.getPupilId());
		
		return "redirect:pupils";
	}
	
	private List<PupilDao> convertPupilList(List<Pupil> pupilList) {
		return pupilList.stream().map(pupil -> this.converter.convert(pupil)).collect(Collectors.toList());
	}
}
