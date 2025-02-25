package com.example.vehicleservicebooking.controller;

import com.example.vehicleservicebooking.model.ServiceBooking;
import com.example.vehicleservicebooking.service.ServiceBookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
public class ServiceBookingController {

    private final ServiceBookingService service;

    public ServiceBookingController(ServiceBookingService service) {
        this.service = service;
    }

    // 1. Register a new service booking
    @PostMapping
    public ResponseEntity<ServiceBooking> createBooking(@RequestBody ServiceBooking booking) {
        return ResponseEntity.ok(service.createBooking(booking));
    }

    // 2. Retrieve all service bookings
    @GetMapping
    public ResponseEntity<List<ServiceBooking>> getAllBookings() {
        return ResponseEntity.ok(service.getAllBookings());
    }

    // 3. Retrieve a booking by ID
    @GetMapping("/{id}")
    public ResponseEntity<ServiceBooking> getBookingById(@PathVariable Long id) {
        Optional<ServiceBooking> booking = service.getBookingById(id);
        return booking.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 4. Update booking details
    @PutMapping("/{id}")
    public ResponseEntity<ServiceBooking> updateBooking(@PathVariable Long id, @RequestBody ServiceBooking updatedBooking) {
        return ResponseEntity.ok(service.updateBooking(id, updatedBooking));
    }

    // 5. Delete a booking
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        service.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}
