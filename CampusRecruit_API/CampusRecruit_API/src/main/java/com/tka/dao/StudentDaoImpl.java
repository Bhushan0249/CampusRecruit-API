package com.tka.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entity.Student;

@Repository
public class StudentDaoImpl {

	@Autowired
	private SessionFactory factory;

	// Method to authenticate user based on username and password
	@SuppressWarnings("deprecation")
	public Student authenticateStudent(String email, String password) {
		try (Session session = factory.openSession()) {

			Student student = null;

			Criteria criteria = session.createCriteria(Student.class);
			criteria.add(Restrictions.eq("email", email));
			student = (Student) criteria.uniqueResult();
			System.out.println(student);
			if (student != null) {

				if (password.equals(student.getPassword())) {
					return student;
				} else {
					return null; // invalid password
				}

			} else {
				return null; // invalid email
			}

		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return null;
	}

	// Method to create a new student
	public String createStudent(Student student) {
		Transaction transaction = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			session.save(student); // Save the student object to the database
			transaction.commit();
			return "Student created successfully"; // Return success message
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return "Error creating student: " + e.getMessage(); // Return error message
		}
	}

	// Method to read a student by ID
	public Student getStudentById(Long id) {
		try (Session session = factory.openSession()) {
			return session.get(Student.class, id); // Retrieve student by ID
		}
	}

	// Method to update an existing student
	public String updateStudent(Student student) {
		Transaction transaction = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			session.update(student); // Update the student object
			transaction.commit();
			return "Student updated successfully"; // Return success message
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
			return "Error updating student: " + e.getMessage(); // Return error message
		}
	}

	// Method to delete a student by ID
	public String deleteStudent(Long id) {
		Transaction transaction = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			Student student = session.get(Student.class, id);
			if (student != null) {
				session.delete(student); // Delete the student object
				transaction.commit();
				return "Student deleted successfully"; // Return success message
			} else {
				return "Student not found"; // Return not found message
			}
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
			return "Error deleting student: " + e.getMessage(); // Return error message
		}
	}

	// Method to retrieve all students
	@SuppressWarnings("unchecked")
	public List<Student> getAllStudents() {
		try (Session session = factory.openSession()) {
			return session.createQuery("FROM Student").list(); // Retrieve all students
		}
	}
}
