package co.com.poli.movieservice;

import co.com.poli.movieservice.persistence.entity.Movie;
import co.com.poli.movieservice.persistence.repository.MovieRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class MovieRepositoryMockTest {
    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void when_findByCategory_return_ListProduct(){
        Movie movie = Movie.builder()
                .title("test")
                .director("Ochoa")
                .rating(4).build();
        movieRepository.save(movie);
        Optional<Movie> movies = movieRepository.findById(movie.getId());
        Assertions.assertThat(movies.get().getId()).isEqualTo(1);
    }
}
