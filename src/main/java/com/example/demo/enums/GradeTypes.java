package com.example.demo.enums;

public enum GradeTypes {

	CLASS_WORK("CLASS_WORK"), TEST("TEST"), EXAM("EXAM");
	
	private String code;
	
	private GradeTypes(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}
}
