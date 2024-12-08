package com.tka.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tka.dao.StudentDaoImpl; // Ensure the package path is correct
import com.tka.entity.Student; // Assuming you have a Student entity
import com.tka.model.LoginRequest;

import java.util.List;

@Service
public class StudentServiceImpl {

    @Autowired
    private StudentDaoImpl daoImpl;
    
    public Student authenticateStudent(LoginRequest loginRequest) {
		return daoImpl.authenticateStudent(loginRequest.getUsername(), loginRequest.getPassword());
	}

    // Method to create a new student
    public String createStudent(Student student) {
        return daoImpl.createStudent(student);
    }

    // Method to fetch all students
    public List<Student> getAllStudents() {
        return daoImpl.getAllStudents();
    }

    // Method to update student details
    public String updateStudent(Student student) {
        return daoImpl.updateStudent(student);
    }

    // Method to delete a student by ID
    public String deleteStudent(Long id) {
        return daoImpl.deleteStudent(id);
    }

    // Method to get a student by ID
    public Student getStudentById(Long id) {
        return daoImpl.getStudentById(id);
    }
}
