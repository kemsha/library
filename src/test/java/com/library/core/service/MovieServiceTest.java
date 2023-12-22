package com.library.core.service;

import com.library.core.model.Movie;
import com.library.core.repository.MovieRepository;
import com.library.rest.dto.MovieRequestDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest
public class MovieServiceTest {

    @MockBean
    MovieRepository movieRepository;

    @Autowired
    MovieService movieService;

    @Test
    public void shouldReturnMovieWhenCreated() {
        Movie movie = new Movie();
        movie.setTitle("The Godfather");
        movie.setGenre("Thriller");
        movie.setYearOfRelease(1972);

        Mockito.when(movieRepository.save(ArgumentMatchers.any(Movie.class))).thenReturn(movie);

        Movie savedMovie = movieService.addMovie(new MovieRequestDTO(movie));
        Assertions.assertEquals(movie.getTitle(), savedMovie.getTitle());
        Assertions.assertEquals(movie.getTitle(),savedMovie.getTitle());
        System.out.println(savedMovie.getID());
    }

    @Test
    public void shouldReturnBookById() {
        Movie movie = new Movie();
        movie.setId("12");
        movie.setTitle("The Godfather");
        movie.setGenre("Thriller");
        movie.setYearOfRelease(1972);

        Mockito.when(movieRepository.findById("someMongoId")).thenReturn(Optional.of(movie));

            Movie foundMovie = movieService.getMoviesById("13");
            Assertions.assertEquals(foundMovie.getTitle(), "The Godfather");
    }

}
