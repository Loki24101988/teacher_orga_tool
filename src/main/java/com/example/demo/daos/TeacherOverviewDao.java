package com.example.demo.daos;

import java.util.List;

import com.example.demo.pojos.Schoolclass;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TeacherOverviewDao {

	private String teacherId;
	private String firstName;
	private String lastName;
	private List<Schoolclass> schoolclasses;
	
}
