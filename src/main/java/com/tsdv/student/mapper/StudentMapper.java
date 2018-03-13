package com.tsdv.student.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.tsdv.student.domain.StudentDTO;

//@Component
public interface StudentMapper {
	@Select("select firstName, lastName, age, gender, dob from Student")
	public List<StudentDTO> findAllStudents();
}
