package com.example.demo.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.daos.TeacherOverviewDao;
import com.example.demo.pojos.Teacher;

@Component
public class TeacherOverviewDaoConverter implements Converter<Teacher, TeacherOverviewDao>{

	@Override
	public TeacherOverviewDao convert(Teacher source) {
		return TeacherOverviewDao
		.builder()
		.firstName(source.getFirstName())
		.lastName(source.getLastName())
		.teacherId(source.getTeacherId())
		.build();
	}

}
