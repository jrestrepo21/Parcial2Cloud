package co.com.poli.bookingservice.persistence.entity;

import co.com.poli.bookingservice.model.Movie;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @Column(name = "show_time_id", nullable = false)
    private Long showtimeId;
    @Transient
    private Movie movie;

}
