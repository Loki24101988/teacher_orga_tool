package com.example.demo.converter;

import java.util.stream.Stream;

import com.example.demo.enums.GradeTypes;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;

@Convert
public class GradeTypeConverter implements AttributeConverter<GradeTypes, String>{

	@Override
	public String convertToDatabaseColumn(GradeTypes attribute) {
		if(attribute == null) {
			return null;
		}
		return attribute.getCode();
	}

	@Override
	public GradeTypes convertToEntityAttribute(String code) {
		if(code == null || "".equals(code)) {
			return null;
		}
		return Stream.of(GradeTypes.values()).filter(c -> c.getCode().equals(code))
				.findFirst().orElseThrow(IllegalArgumentException::new);
	}

}
