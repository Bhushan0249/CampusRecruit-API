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

import com.tka.entity.JobPosting;
import com.tka.service.JobPostingServiceImpl;

@RestController
@RequestMapping("/job-postings")
public class JobPostingController {

	@Autowired
	private JobPostingServiceImpl jobPostingServiceImpl;

	@PostMapping("/createJob")
	public String createJob(@RequestBody JobPosting jobPosting) {
		return jobPostingServiceImpl.createJobPosting(jobPosting);
	}

	@GetMapping("/allJobs")
	public List<JobPosting> getAllJobs() {
		return jobPostingServiceImpl.getAllJobPostings();
	}

	@DeleteMapping("/deleteJob/{id}")
	public String deleteJob(@PathVariable Long id) {
		return jobPostingServiceImpl.deleteJobPosting(id);
	}

	@PutMapping("/updateJob")
	public String updateJob(@RequestBody JobPosting jobPosting) {
		return jobPostingServiceImpl.updateJobPosting(jobPosting);
	}
}
