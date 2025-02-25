package com.SCAD_LAB05.jobapplication.service;

import com.SCAD_LAB05.jobapplication.model.JobApplication;
import com.SCAD_LAB05.jobapplication.repository.JobApplicationRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class JobApplicationService {

    private final JobApplicationRepository repository;

    public JobApplicationService(JobApplicationRepository repository) {
        this.repository = repository;
    }

    public JobApplication uploadApplication(String applicantName, MultipartFile file) throws IOException {
        JobApplication application = new JobApplication(
                applicantName,
                file.getOriginalFilename(),
                file.getContentType(),
                file.getBytes(),
                LocalDateTime.now()
        );
        return repository.save(application);
    }

    public List<JobApplication> getAllApplications() {
        return repository.findAll();
    }

    public Optional<JobApplication> getApplicationById(Long id) {
        return repository.findById(id);
    }

    public void deleteApplication(Long id) {
        repository.deleteById(id);
    }
}
