package com.tka.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entity.User;

@Repository
public class UserDaoImpl {

	@Autowired
	private SessionFactory factory;

	// Method to authenticate user based on username and password
	public User authenticateUser(String username, String password) {
		try (Session session = factory.openSession()) {

			User user = null;

			user = session.get(User.class, username);
			if (user != null) {

				if (password.equals(user.getPassword())) {
					return user;
				} else {
					return null; // invalid password
				}

			} else {
				return null; // invalid username
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	
	}

	// Method to create a new user
	public String createUser(User user) {
		Transaction transaction = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			session.save(user); // Save the user object to the database
			transaction.commit();
			return "User created successfully"; // Return success message
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
			return "Error creating user: " + e.getMessage(); // Return error message
		}
	}

	// Method to read a user by ID
	public User getUserById(String username) {
		try (Session session = factory.openSession()) {
			return session.get(User.class, username); // Retrieve user by ID
		}
	}

	// Method to update an existing user
	public String updateUser(User user) {
		Transaction transaction = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			session.update(user); // Update the user object
			transaction.commit();
			return "User updated successfully"; // Return success message
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
			return "Error updating user: " + e.getMessage(); // Return error message
		}
	}

	// Method to delete a user by ID
	public String deleteUser(String username) {
		Transaction transaction = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			User user = session.get(User.class, username);
			if (user != null) {
				session.delete(user); // Delete the user object
				transaction.commit();
				return "User deleted successfully"; // Return success message
			} else {
				return "User not found"; // Return not found message
			}
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
			return "Error deleting user: " + e.getMessage(); // Return error message
		}
	}

	// Method to retrieve all users
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		try (Session session = factory.openSession()) {
			return session.createQuery("FROM User").list(); // Retrieve all users
		}
	}
}
