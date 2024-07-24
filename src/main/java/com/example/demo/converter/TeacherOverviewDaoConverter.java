package com.example.demo.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.pojos.Teacher;

@Component
public class TeacherOverviewDaoConverter implements Converter<Teacher, TeacherOverviewDaoConverter>{

	@Override
	public TeacherOverviewDaoConverter convert(Teacher source) {
		// TODO Auto-generated method stub
		return null;
	}

}
