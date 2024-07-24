package com.example.demo.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.daos.PupilDao;
import com.example.demo.pojos.Pupil;

@Component
public class PupilConverter implements Converter<Pupil, PupilDao>{

	@Override
	public PupilDao convert(Pupil source) {
		String schoolclassName = "";
		if(source.getSchoolclass() == null) {
			schoolclassName = "no class set yet";
		} else {
			schoolclassName = source.getSchoolclass().getSchoolclassName();
		}
		return PupilDao
				.builder()
				.firstName(source.getFirstName())
				.lastName(source.getLastName())
				.schoolclassName(schoolclassName)
				.pupilId(source.getPupilId())
				.notes(source.getNotes())
				.build();
	}



}
