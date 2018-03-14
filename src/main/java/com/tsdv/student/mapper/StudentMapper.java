package com.tsdv.student.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tsdv.student.domain.StudentDTO;

@Component
public interface StudentMapper {
//	@Select("select firstName, lastName, age, gender, dob from Student")
	public List<StudentDTO> findAllStudents();
}
