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

import com.tka.entity.JobApplication;
import com.tka.service.JobApplicationServiceImpl;

@RestController
@RequestMapping("/jobApplication")
public class JobApplicationController {

    @Autowired
    private JobApplicationServiceImpl jobApplicationService;

    // Apply for a job
    @PostMapping("/apply")
    public String applyForJob(@RequestBody JobApplication jobApplication) {
        jobApplicationService.applyForJob(jobApplication);
        return "Job application submitted successfully";
    }

    // Update job application status
    @PutMapping("/updateStatus/{id}/{status}")
    public String updateApplicationStatus(@PathVariable Long id, @PathVariable String status) {
        jobApplicationService.updateApplicationStatus(id, status);
        return "Job application status updated successfully";
    }

    // Get all job applications
    @GetMapping("/all")
    public List<JobApplication> getAllApplications() {
        return jobApplicationService.getAllApplications();
    }

    // Get job application by ID
    @GetMapping("/{id}")
    public JobApplication getApplicationById(@PathVariable Long id) {
        return jobApplicationService.getApplicationById(id);
    }

    // Delete a job application
    @DeleteMapping("/delete/{id}")
    public String deleteJobApplication(@PathVariable Long id) {
    return jobApplicationService.deleteApplication(id);
    }
}
