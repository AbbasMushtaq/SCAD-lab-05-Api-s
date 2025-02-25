package com.SCAD_LAB05.jobapplication.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String applicantName;
    private String fileName;
    private String fileType;
    private LocalDateTime uploadDate;

    @Lob
    private byte[] fileData;

    public JobApplication() {
    }

    public JobApplication(String applicantName, String fileName, String fileType, byte[] fileData, LocalDateTime uploadDate) {
        this.applicantName = applicantName;
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileData = fileData;
        this.uploadDate = uploadDate;
    }

    public Long getId() { return id; }
    public String getApplicantName() { return applicantName; }
    public String getFileName() { return fileName; }
    public String getFileType() { return fileType; }
    public LocalDateTime getUploadDate() { return uploadDate; }
    public byte[] getFileData() { return fileData; }
}
