package co.com.poli.movieservice.persistence.repository;

import co.com.poli.movieservice.persistence.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {
}
