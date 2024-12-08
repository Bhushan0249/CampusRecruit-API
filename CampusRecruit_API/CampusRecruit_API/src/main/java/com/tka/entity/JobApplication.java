package com.tka.entity;

import javax.persistence.*;

import com.tka.enums.ApplicationStatus;

@Entity
@Table(name = "job_applications")
public class JobApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long studentId;

	private Long jobPostingId;

	@Enumerated(EnumType.STRING)
	private ApplicationStatus status; // Example: APPLIED, APPROVED, REJECTED

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Long getJobPostingId() {
		return jobPostingId;
	}

	public void setJobPostingId(Long jobPostingId) {
		this.jobPostingId = jobPostingId;
	}

	public ApplicationStatus getStatus() {
		return status;
	}

	public void setStatus(ApplicationStatus status) {
		this.status = status;
	}

	
}


