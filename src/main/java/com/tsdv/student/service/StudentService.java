package com.tsdv.student.service;

import java.util.List;

import com.tsdv.student.domain.StudentDTO;

public interface StudentService {
	public List<StudentDTO> findAllStudents();
}
