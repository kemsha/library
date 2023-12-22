package com.library.rest.dto;

import com.library.core.model.Movie;
import java.util.Date;

public class MovieRequestDTO {
    private String isbn;
    private String title;
    private String genre;
    private int yearOfRelease;
    private String description;

    public MovieRequestDTO() { }

    public MovieRequestDTO(Movie movie){
        this.isbn = movie.getIsbn();
        this.title = movie.getTitle();
        this.genre = movie.getGenre();
        this.yearOfRelease = movie.getYearOfRelease();
        this.description = movie.getDescription();
    }


    public Movie toEntity() {
        Movie movie = new Movie();
        movie.setIsbn(isbn);
        movie.setTitle(title);
        movie.setGenre(genre);
        movie.setYearOfRelease(yearOfRelease);
        movie.setDescription(description);
        return movie;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
