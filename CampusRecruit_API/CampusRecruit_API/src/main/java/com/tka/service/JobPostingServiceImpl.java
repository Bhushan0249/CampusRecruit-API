package com.tka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tka.dao.JobPostingDaoImpl; // Ensure the package path is correct
import com.tka.entity.JobPosting; // Assuming you have a JobPosting entity

import java.util.List;

@Service
public class JobPostingServiceImpl {

	@Autowired
	private JobPostingDaoImpl daoImpl;

	// Method to create a new job posting
	public String createJobPosting(JobPosting jobPosting) {
		return daoImpl.createJobPosting(jobPosting);
	}

	// Method to fetch all job postings
	public List<JobPosting> getAllJobPostings() {
		return daoImpl.getAllJobPostings();
	}

	// Method to update job posting details
	public String updateJobPosting(JobPosting jobPosting) {
		return daoImpl.updateJobPosting(jobPosting);
	}

	// Method to delete a job posting by ID
	public String deleteJobPosting(Long id) {
		return daoImpl.deleteJobPosting(id);
	}
}
