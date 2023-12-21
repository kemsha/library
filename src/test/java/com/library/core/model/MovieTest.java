package com.library.core.model;

import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.Date;

@SpringBootTest
public class MovieTest {

    @Test
    void shouldCreateNewMovie(){
        Movie movie = new Movie(
                14,
                "Test Movie",
                "Fiction",
                2003,
                "Test description"
        );
        Assertions.assertEquals("Test Movie", movie.getTitle());
        Assertions.assertEquals("Fiction", movie.getGenre());
    }

    @Test
    void shouldCompareTwoMovies(){
        Movie movie1 = new Movie(
                14,
                "Test movie1",
                "Fiction",
                2003,
                "Test Description 1"
        );

        Movie movie2 = new Movie(
                14,
                "Test movie1",
                "Fiction",
                2003,
                "Test Description 1"
        );
        AssertionsForInterfaceTypes
                .assertThat(movie1)
                .usingRecursiveComparison()
                .isEqualTo(movie2);
    }
}
