package com.example.demo.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.daos.SchoolclassOverviewDao;
import com.example.demo.pojos.Schoolclass;

@Component
public class SchoolclassOverviewConverter implements Converter<Schoolclass, SchoolclassOverviewDao> {

	@Override
	public SchoolclassOverviewDao convert(Schoolclass source) {
		return SchoolclassOverviewDao
		.builder()
		.schoolclassName(source.getSchoolclassName())
		.build();
	}

}
