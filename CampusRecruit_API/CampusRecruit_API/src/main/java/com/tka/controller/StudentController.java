package com.tka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.Student;
import com.tka.service.StudentServiceImpl;

@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentServiceImpl studentServiceImpl;

	@PostMapping("/register")
	public String registerStudent(@RequestBody Student student) {
		return studentServiceImpl.createStudent(student);
	}

	@GetMapping("/allStudents")
	public List<Student> getAllStudents() {
		return studentServiceImpl.getAllStudents();
	}

	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable Long id) {
		return studentServiceImpl.deleteStudent(id);
	}

	@PutMapping("/updateStudent")
	public String updateStudent(@RequestBody Student student) {
		return studentServiceImpl.updateStudent(student);
	}
}
