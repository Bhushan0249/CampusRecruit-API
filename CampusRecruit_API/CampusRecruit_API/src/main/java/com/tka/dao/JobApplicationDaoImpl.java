package com.tka.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entity.JobApplication;
import com.tka.enums.ApplicationStatus;

import java.util.List;

@Repository
public class JobApplicationDaoImpl {

	@Autowired
	private SessionFactory sessionFactory;

	// Apply for a job
	public void applyForJob(JobApplication jobApplication) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(jobApplication);
		transaction.commit();
		session.close();
	}

	// Update job application status
	public void updateApplicationStatus(Long id, String status) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		JobApplication jobApplication = session.get(JobApplication.class, id);
		if (jobApplication != null) {
			jobApplication.setStatus(ApplicationStatus.valueOf(status));
			session.update(jobApplication);
		}
		transaction.commit();
		session.close();
	}

	// Get all job applications
	public List<JobApplication> getAllApplications() {
		Session session = sessionFactory.openSession();
		List<JobApplication> applications = session.createQuery("FROM JobApplication", JobApplication.class).list();
		session.close();
		return applications;
	}

	// Get job application by ID
	public JobApplication getApplicationById(Long id) {
		Session session = sessionFactory.openSession();
		JobApplication jobApplication = session.get(JobApplication.class, id);
		session.close();
		return jobApplication;
	}

	// Delete a job application
	public String deleteApplication(Long id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		JobApplication jobApplication = session.get(JobApplication.class, id);
		if (jobApplication != null) {
			session.delete(jobApplication);
			transaction.commit();
			return "Job Application Deleted";
		}else {
			return "Already Deleted'";
		}
	}
}
