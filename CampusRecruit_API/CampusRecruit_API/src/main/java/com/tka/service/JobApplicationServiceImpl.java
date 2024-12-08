package com.tka.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.JobApplicationDaoImpl;
import com.tka.entity.JobApplication;

@Service
public class JobApplicationServiceImpl {

    @Autowired
    private JobApplicationDaoImpl jobApplicationDao;

    // Apply for a job
    public void applyForJob(JobApplication jobApplication) {
        jobApplicationDao.applyForJob(jobApplication);
    }

    // Update job application status
    public void updateApplicationStatus(Long id, String status) {
        jobApplicationDao.updateApplicationStatus(id, status);
    }

    // Get all job applications
    public List<JobApplication> getAllApplications() {
        return jobApplicationDao.getAllApplications();
    }

    // Get job application by ID
    public JobApplication getApplicationById(Long id) {
        return jobApplicationDao.getApplicationById(id);
    }

    // Delete a job application
    public String deleteApplication(Long id) {
       return jobApplicationDao.deleteApplication(id);
    }
}
