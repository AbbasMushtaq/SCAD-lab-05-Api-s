package com.example.vehicleservicebooking.repository;

import com.example.vehicleservicebooking.model.ServiceBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceBookingRepository extends JpaRepository<ServiceBooking, Long> {
}
