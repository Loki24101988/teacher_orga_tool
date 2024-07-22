package com.example.demo.webside.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.daos.PupilDao;
import com.example.demo.pojos.Pupil;
import com.example.demo.services.PupilService;
import com.example.demo.services.PupilServiceImpl;

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
		model.addAttribute("pupils", this.convertPupilList(allPupils));
		return "pupils";
	}
	
	private List<PupilDao> convertPupilList(List<Pupil> pupilList) {
		return pupilList.stream().map(pupil -> this.converter.convert(pupil)).collect(Collectors.toList());
	}
}
