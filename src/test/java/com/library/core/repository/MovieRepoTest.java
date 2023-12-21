package com.library.core.repository;

import com.library.core.model.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class MovieRepoTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void shouldReturnAllMovies(){
        List<Movie> movies = movieRepository.findAll();

        Assertions.assertEquals(1, movies.size());
        Assertions.assertEquals("Lord of the Rings", movies.get(0),getTitle());
    }

    @Test
    public void shouldFindMovieByTitle() {
        Optional<Movie> movie = movieRepository.findByTitle("Lord of the Rings");
        Assertions.assertNotNull(movie.orElse(null));
    }
}
