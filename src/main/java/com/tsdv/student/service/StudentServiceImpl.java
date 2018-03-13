package com.tsdv.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsdv.student.domain.StudentDTO;
import com.tsdv.student.mapper.StudentMapper;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentMapper studentMapper;
	
	public List<StudentDTO> findAllStudents() {
		return studentMapper.findAllStudents();
	}
}
