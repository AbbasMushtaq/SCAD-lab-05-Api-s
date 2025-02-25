package com.SCAD_LAB05.jobapplication.controller;

import com.SCAD_LAB05.jobapplication.model.JobApplication;
import com.SCAD_LAB05.jobapplication.service.JobApplicationService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/job-applications")
public class JobApplicationController {

    private final JobApplicationService service;

    public JobApplicationController(JobApplicationService service) {
        this.service = service;
    }

    @PostMapping("/upload")
    public ResponseEntity<JobApplication> uploadApplication(
            @RequestParam("applicantName") String applicantName,
            @RequestParam("file") MultipartFile file) {
        try {
            return ResponseEntity.ok(service.uploadApplication(applicantName, file));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<JobApplication>> getAllApplications() {
        return ResponseEntity.ok(service.getAllApplications());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobApplication> getApplicationById(@PathVariable Long id) {
        Optional<JobApplication> application = service.getApplicationById(id);
        return application.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long id) {
        Optional<JobApplication> application = service.getApplicationById(id);
        if (application.isPresent()) {
            JobApplication jobApplication = application.get();
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + jobApplication.getFileName() + "\"")
                    .body(jobApplication.getFileData());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
        service.deleteApplication(id);
        return ResponseEntity.noContent().build();
    }
}
