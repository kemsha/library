package com.library.core.service;


import com.library.core.exceptions.repository.ResourceNotFoundException;
import com.library.core.model.Movie;
import com.library.core.repository.MovieRepository;
import com.library.rest.dto.MovieRequestDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public Movie getMoviesById(String id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if(movie.isEmpty()) {
            throw   new ResourceNotFoundException("The movie with the given id does not exist!");
        }
        return movie.get();
    }

    public Movie addMovie(MovieRequestDTO payload){
        return movieRepository.save(payload.toEntity());
    }

    public Movie updateMovie(String id, MovieRequestDTO payload){
        Optional<Movie> movie = movieRepository.findById(id);

        if(movie.isEmpty()){
            throw new ResourceNotFoundException("The movie with given id does not exist!");
        }
        Movie updatedMovie = payload.toEntity();
        updatedMovie.setId(movie.get().getID());
        updatedMovie = movieRepository.save(updatedMovie);
        return updatedMovie;
    }

    public void deleteMovie(String id){
        Optional<Movie> movie = movieRepository.findById(id);
        movie.ifPresent(movieRepository::delete);
    }

}
