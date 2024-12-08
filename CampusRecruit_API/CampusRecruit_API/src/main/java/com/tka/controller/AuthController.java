package com.tka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.Student;
import com.tka.entity.User;
import com.tka.model.LoginRequest;
import com.tka.service.StudentServiceImpl;
import com.tka.service.UserServiceImpl;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@Autowired
	private StudentServiceImpl studentServiceImpl;

	@PostMapping("/user-login")
	public User userLogin(@RequestBody LoginRequest loginRequest) {

		return userServiceImpl.authenticateUser(loginRequest);
	}

	@PostMapping("/student-login")
	public Student studentLogin(@RequestBody LoginRequest loginRequest) {

		return studentServiceImpl.authenticateStudent(loginRequest);
	}

}
