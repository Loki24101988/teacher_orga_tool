package com.example.demo.webside.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.pojos.Pupil;
import com.example.demo.services.PupilService;
import com.example.demo.services.PupilServiceImpl;

@Controller
public class WebsiteController {

	private PupilService pupilService;
	
	public WebsiteController(PupilService pupilService) {
		this.pupilService = pupilService;
	}
	
	@GetMapping("/website")
	public String getIndex(Model model) {
		model.addAttribute("Teacher", "Hans");
		return "index";
	}
	
	@GetMapping("/pupils")
	public String getPupilSite(Model model) {
		List<Pupil> allPupils = this.pupilService.getAllPupils();
		model.addAttribute("pupils", allPupils);
		return "pupils";
	}
}
