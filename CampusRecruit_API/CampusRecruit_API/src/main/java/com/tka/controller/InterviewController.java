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

import com.tka.entity.Interview;
import com.tka.service.InterviewServiceImpl;

@RestController
@RequestMapping("/interviews")
public class InterviewController {

	@Autowired
	private InterviewServiceImpl interviewServiceImpl;

	@PostMapping("/scheduleInterview")
	public String scheduleInterview(@RequestBody Interview selectionInterview) {

		return interviewServiceImpl.scheduleInterview(selectionInterview);
	}

	@GetMapping("/allInterviews")
	public List<Interview> getAllInterviews() {
		return interviewServiceImpl.getAllInterviews();
	}

	@DeleteMapping("/cancelInterview/{id}")
	public String cancelInterview(@PathVariable Long id) {
		return interviewServiceImpl.cancelInterview(id);
	}

	@PutMapping("/reschedule")
	public String updateInterview(@RequestBody Interview interview) {
		return interviewServiceImpl.updateInterview(interview);
	}
}
