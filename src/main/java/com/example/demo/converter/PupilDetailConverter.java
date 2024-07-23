package com.example.demo.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.daos.PupilDetailDao;
import com.example.demo.pojos.Pupil;

@Component
public class PupilDetailConverter implements Converter<Pupil, PupilDetailDao>{

	@Override
	public PupilDetailDao convert(Pupil source) {
		return PupilDetailDao.builder()
				.firstName(source.getFirstName())
				.lastName(source.getLastName())
				.schoolclass(source.getSchoolclass())
				.notes(source.getNotes())
				.grades(source.getGrades())
				.build();
	}

}
