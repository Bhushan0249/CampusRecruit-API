package com.tka.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entity.Interview;

@Repository
public class InterviewDaoImpl {

	@Autowired
	private SessionFactory factory;

	// Method to schedule a new interview
	public String scheduleInterview(Interview interview) {
		Transaction transaction = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			session.save(interview); // Save the interview object to the database
			transaction.commit();
			return "Interview scheduled successfully"; // Return success message
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
			return "Error scheduling interview: " + e.getMessage(); // Return error message
		}
	}

	// Method to fetch all scheduled interviews
	@SuppressWarnings("unchecked")
	public List<Interview> getAllInterviews() {
		try (Session session = factory.openSession()) {
			return session.createQuery("FROM Interview").list(); // Retrieve all interviews
		}
	}

	// Method to cancel an interview by ID
	public String cancelInterview(Long id) {
		Transaction transaction = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			Interview interview = session.get(Interview.class, id);
			if (interview != null) {
				session.delete(interview); // Delete the interview object
				transaction.commit();
				return "Interview canceled successfully"; // Return success message
			} else {
				return "Interview not found"; // Return not found message
			}
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
			return "Error canceling interview: " + e.getMessage(); // Return error message
		}
	}

	// Method to update interview details
	public String updateInterview(Interview interview) {
		Transaction transaction = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			session.update(interview); // Update the interview object
			transaction.commit();
			return "Interview updated successfully"; // Return success message
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
			return "Error updating interview: " + e.getMessage(); // Return error message
		}
	}
}
