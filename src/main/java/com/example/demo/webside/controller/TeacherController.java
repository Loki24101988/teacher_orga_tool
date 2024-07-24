package com.example.demo.webside.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.converter.TeacherOverviewDaoConverter;
import com.example.demo.form.FormCreateTeacher;
import com.example.demo.pojos.Teacher;
import com.example.demo.services.TeacherService;

@Controller
@RequestMapping("/website")
public class TeacherController {

	private TeacherService teacherService;
	
	private TeacherOverviewDaoConverter converter;
	
	public TeacherController(TeacherService teacherService,
			TeacherOverviewDaoConverter converter) {
		this.teacherService = teacherService;
		this.converter = converter;
	}
	
	@GetMapping("/allteachers")
	public String getAllTeachers(Model model) {
		List<Teacher> allTeachers = this.teacherService.getAllTeachers();
		List<TeacherOverviewDaoConverter> collect = allTeachers
				.stream()
				.map(teacher -> this.converter.convert(teacher))
				.collect(Collectors.toList());
		model.addAttribute("teacherOverviewDaos", collect);
		model.addAttribute("formCreateTeacher", new FormCreateTeacher());
		return "teacherOverview";
	}
	
	@PostMapping("/createNewTeacher")
	public String createNewTeacher(@ModelAttribute("formCreateTeacher") FormCreateTeacher formCreateTeacher) {
		Teacher createNewTeacher = this.teacherService.createNewTeacher(formCreateTeacher);
		return "redirect:allteachers";
	}
}
