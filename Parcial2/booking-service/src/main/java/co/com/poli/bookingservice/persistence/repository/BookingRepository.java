package co.com.poli.bookingservice.persistence.repository;

import co.com.poli.bookingservice.persistence.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
