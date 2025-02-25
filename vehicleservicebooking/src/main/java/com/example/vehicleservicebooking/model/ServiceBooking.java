package com.example.vehicleservicebooking.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class ServiceBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vehicleModel;
    private String registrationNumber;
    private String serviceType;
    private LocalDate preferredDate;

    public ServiceBooking() {
    }

    public ServiceBooking(String vehicleModel, String registrationNumber, String serviceType, LocalDate preferredDate) {
        this.vehicleModel = vehicleModel;
        this.registrationNumber = registrationNumber;
        this.serviceType = serviceType;
        this.preferredDate = preferredDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public LocalDate getPreferredDate() {
        return preferredDate;
    }

    public void setPreferredDate(LocalDate preferredDate) {
        this.preferredDate = preferredDate;
    }
}
