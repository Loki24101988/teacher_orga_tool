package com.example.demo.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.daos.PupilDao;
import com.example.demo.pojos.Pupil;

@Component
public class PupilConverter implements Converter<Pupil, PupilDao>{

	@Override
	public PupilDao convert(Pupil source) {
		return new PupilDao(source.getFirstName(), source.getLastName());
	}



}
