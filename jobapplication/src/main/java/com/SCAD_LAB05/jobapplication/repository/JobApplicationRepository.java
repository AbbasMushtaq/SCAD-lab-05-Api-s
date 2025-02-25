package com.SCAD_LAB05.jobapplication.repository;

import com.SCAD_LAB05.jobapplication.model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
}
