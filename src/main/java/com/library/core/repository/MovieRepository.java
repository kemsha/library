package com.library.core.repository;


import com.library.core.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class MovieRepository {
    private List<Movie> movies;

    public MovieRepository() {
        this.movies = Arrays.asList(
                new Movie(1, "First Movie", "Thriller", 1998, "In a world where statistics is hard, Nicholas Cage is harder"),
                new Movie(2, "Second Movie", "Sci-Fi", 1972, "Lol this is star wars"),
                new Movie(3, "Third Movie", "Fantasy", 2002, "Lol this is Lord of the Rings")
        );
    }
    public List<Movie> findAll() {
        return movies;
    }

    public Movie findById(int id){
        return movies.stream().filter(movie -> movie.getID() == id).findFirst().orElse(null);
    }

}
