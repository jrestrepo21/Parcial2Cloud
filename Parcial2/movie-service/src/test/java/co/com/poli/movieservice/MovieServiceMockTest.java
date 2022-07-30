package co.com.poli.movieservice;

import co.com.poli.movieservice.persistence.entity.Movie;
import co.com.poli.movieservice.persistence.repository.MovieRepository;
import co.com.poli.movieservice.service.MovieService;
import co.com.poli.movieservice.service.MovieServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class MovieServiceMockTest {
    @Mock
    private MovieRepository movieRepository;
    private MovieService movieService;

    @BeforeEach
    public void begin() {
        MockitoAnnotations.openMocks(this);
        movieService = new MovieServiceImpl(movieRepository);

        Movie movie = Movie.builder()
                .id(4L)
                .title("breaking bad")
                .director("Johan")
                .rating(3).build();
        Mockito.when(movieRepository.findById(4L))
                .thenReturn(Optional.of(movie));
    }

    @Test
    public void when_findById_return_name() {
        Movie movie = movieService.findById(4L);
        Assertions.assertThat(movie.getTitle().equals("breaking bad"));
    }
}
