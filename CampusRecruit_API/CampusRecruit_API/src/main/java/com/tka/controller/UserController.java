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

import com.tka.entity.User;
import com.tka.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@PostMapping("/createUser")
	public String createUser(@RequestBody User user) {
		return userServiceImpl.createUser(user);
	}

	@DeleteMapping("/deleteUser/{username}")
	public String deleteUser(@PathVariable String username) {
		return userServiceImpl.deleteUser(username);
	}

	@GetMapping("/allUsers")
	public List<User> getAllUsers() {
		return userServiceImpl.getAllUsers();
	}

	@GetMapping("/getUser/{username}")
	public User getUserById(@PathVariable String username) {
		return userServiceImpl.getUserById(username);
	}

	@PutMapping("/updateUser")
	public String updateUser(@RequestBody User user) {
		return userServiceImpl.updateUser(user);
	}
}
