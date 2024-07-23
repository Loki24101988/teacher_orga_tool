package com.example.demo.webside.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.converter.PupilDetailConverter;
import com.example.demo.daos.PupilDetailDao;
import com.example.demo.form.FormPupilDetail;
import com.example.demo.pojos.Pupil;
import com.example.demo.services.PupilService;

@Controller
@RequestMapping("/website")
public class PupilDetailController {

	private PupilService pupilService;
	private PupilDetailConverter converter;
	
	public PupilDetailController(PupilService pupilService, PupilDetailConverter converter) {
		this.pupilService = pupilService;
		this.converter = converter;
	}
	
	@GetMapping("/pupilsDetailPage")
	public String showdetailsForPupil(@ModelAttribute("formDetail") FormPupilDetail detail, Model model) {
		Pupil pupilForId = this.pupilService.getPupilForId(detail.getPupilId());
		PupilDetailDao convert = this.converter.convert(pupilForId);
		model.addAttribute("pupilDetailDao", convert);
		return "pupilsDetailPage";
	}
}
