package com.tsdv.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tsdv.student.domain.StudentDTO;
import com.tsdv.student.service.StudentService;

@RestController
@RequestMapping("/student/")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/listStudent")
	public ModelAndView listStudent() {
		ModelAndView modelAndView = new ModelAndView("student/listStudent");
		List<StudentDTO> studentDTOs = studentService.findAllStudents();
		
		studentDTOs.forEach(studentDTO -> {
			System.out.println("==>>" + studentDTO.toString());
		});
		
		return modelAndView;
	}
}
