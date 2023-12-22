package com.library.core.model;

import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.library.core.model.Movie;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.Date;

@SpringBootTest
public class MovieTest {

    @Test
    void shouldCreateNewBook() {
        Movie movie = new Movie(
                "some id",
                "123456",
                "Neki film",
                "Fantazija",
                2004,
                "ovo je neki film"
        );
        Assertions.assertEquals("Neki film", movie.getTitle());
        Assertions.assertEquals("fantazija", movie.getGenre());
    }

    @Test
    void shouldCompareTwoMovies() {
        Movie movie1 = new Movie(
                "12",
                "123654",
                "Random movie",
                "Adventure",
                2003,
                "This is some movie"
        );
        Movie movie2 = new Movie(
                "12",
                "123654",
                "Random movie",
                "Adventure",
                2003,
                "This is some movie"
        );

        AssertionsForInterfaceTypes.assertThat(movie1).usingRecursiveComparison().isEqualTo(movie2);
    }
}
