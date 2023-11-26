package com.library.core.repository;


import com.library.core.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

    List<Movie> findAll();

    List<Movie> findByGenre(String genre);

    Optional<Movie> findByTitle(String title);

}
