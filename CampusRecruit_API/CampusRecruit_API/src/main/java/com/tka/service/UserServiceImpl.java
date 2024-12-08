package com.tka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tka.dao.UserDaoImpl; // Ensure the package path is correct
import com.tka.entity.User; // Assuming you have a User entity
import com.tka.model.LoginRequest;

import java.util.List;

@Service
public class UserServiceImpl {

	@Autowired
	private UserDaoImpl daoImpl;

	public User authenticateUser(LoginRequest loginRequest) {
		return daoImpl.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword());
	}

	// Method to create a new user
	public String createUser(User user) {
		return daoImpl.createUser(user);
	}

	// Method to fetch all users
	public List<User> getAllUsers() {
		return daoImpl.getAllUsers();
	}

	// Method to update user details
	public String updateUser(User user) {
		return daoImpl.updateUser(user);
	}

	// Method to delete a user by ID
	public String deleteUser(String username) {
		return daoImpl.deleteUser(username);
	}

	// Method to get a user by ID
	public User getUserById(String username) {
		return daoImpl.getUserById(username);
	}
}
