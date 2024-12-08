package com.tka.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entity.JobPosting;

@Repository
public class JobPostingDaoImpl {

    @Autowired
    private SessionFactory factory;

    // Method to create a new job posting
    public String createJobPosting(JobPosting jobPosting) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.save(jobPosting); // Save the jobPosting object to the database
            transaction.commit();
            return "Job posting created successfully"; // Return success message
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return "Error creating job posting: " + e.getMessage(); // Return error message
        }
    }

    // Method to read a job posting by ID
    public JobPosting getJobPostingById(Long id) {
        try (Session session = factory.openSession()) {
            return session.get(JobPosting.class, id); // Retrieve job posting by ID
        }
    }

    // Method to update an existing job posting
    public String updateJobPosting(JobPosting jobPosting) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.update(jobPosting); // Update the jobPosting object
            transaction.commit();
            return "Job posting updated successfully"; // Return success message
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return "Error updating job posting: " + e.getMessage(); // Return error message
        }
    }

    // Method to delete a job posting by ID
    public String deleteJobPosting(Long id) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            JobPosting jobPosting = session.get(JobPosting.class, id);
            if (jobPosting != null) {
                session.delete(jobPosting); // Delete the jobPosting object
                transaction.commit();
                return "Job posting deleted successfully"; // Return success message
            } else {
                return "Job posting not found"; // Return not found message
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return "Error deleting job posting: " + e.getMessage(); // Return error message
        }
    }

    // Method to retrieve all job postings
    @SuppressWarnings("unchecked")
    public List<JobPosting> getAllJobPostings() {
        try (Session session = factory.openSession()) {
            return session.createQuery("FROM JobPosting").list(); // Retrieve all job postings
        }
    }
}
