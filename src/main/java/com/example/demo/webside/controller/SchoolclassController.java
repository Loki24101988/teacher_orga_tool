package com.example.demo.webside.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.converter.SchoolclassOverviewConverter;
import com.example.demo.daos.SchoolclassOverviewDao;
import com.example.demo.form.FormSchoolclass;
import com.example.demo.pojos.Schoolclass;
import com.example.demo.services.SchoolclassService;

@Controller
@RequestMapping("/website")
public class SchoolclassController {
	
	private SchoolclassService schoolclassService;
	
	private SchoolclassOverviewConverter converter;
	
	public SchoolclassController(SchoolclassService schoolclassService, SchoolclassOverviewConverter converter) {
		this.schoolclassService = schoolclassService;
		this.converter = converter;
	}

	@GetMapping("/allschoolclasses")
	public String getOverviewOfSchoolclasses(Model model) {
		
		List<Schoolclass> allSchoolclasses = this.schoolclassService.getAllSchoolclasses();
		List<SchoolclassOverviewDao> collect = allSchoolclasses.stream().map(schoolclass -> this.converter.convert(schoolclass)).collect(Collectors.toList());
		model.addAttribute("schoolclassesDao", collect);
		model.addAttribute("formSchoolclass", new FormSchoolclass());
		return "schoolclassesOverview";
	}
	
	@PostMapping("/addschoolclass")
	public String addSchoolclassToDatabase(@ModelAttribute("formSchoolclass") FormSchoolclass formSchoolclass) {
		Schoolclass createSchoolclass = this.schoolclassService.createSchoolclass(formSchoolclass.getSchoolclassName());
		
		return "redirect:allschoolclasses";
	}
}
