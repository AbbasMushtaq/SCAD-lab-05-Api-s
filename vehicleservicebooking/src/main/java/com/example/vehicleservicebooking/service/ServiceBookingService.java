package com.example.vehicleservicebooking.service;
import com.example.vehicleservicebooking.model.ServiceBooking;
import com.example.vehicleservicebooking.repository.ServiceBookingRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class ServiceBookingService {
    private final ServiceBookingRepository repository;
    public ServiceBookingService(ServiceBookingRepository repository) {
        this.repository = repository;}
    public ServiceBooking createBooking(ServiceBooking booking) {
        return repository.save(booking);}
    public List<ServiceBooking> getAllBookings() {
        return repository.findAll();
    }
    public Optional<ServiceBooking> getBookingById(Long id) {
        return repository.findById(id);}
    public ServiceBooking updateBooking(Long id, ServiceBooking updatedBooking) {
        return repository.findById(id)
                .map(booking -> {
                    booking.setVehicleModel(updatedBooking.getVehicleModel());
                    booking.setRegistrationNumber(updatedBooking.getRegistrationNumber());
                    booking.setServiceType(updatedBooking.getServiceType());
                    booking.setPreferredDate(updatedBooking.getPreferredDate());
                    return repository.save(booking);
                })
                .orElseThrow(() -> new RuntimeException("Booking not found"));}
    public void deleteBooking(Long id) {
        repository.deleteById(id);}
}
