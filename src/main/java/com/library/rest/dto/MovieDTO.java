package com.library.rest.dto;

import com.library.core.model.Movie;

public class MovieDTO {

    private int id;

    private String title;

    private String genre;

    private int yearOfRelease;

    private String description;

    public MovieDTO(Movie movie) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.yearOfRelease = yearOfRelease;
        this.description = description;
    }

    public int getID() { return id; }

    public void setId(int id) { this.id = id;}

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title;}

    public String getGenre() { return genre; }

    public void  setGenre(String genre) { this.genre = genre; }

    public int getYearOfRelease() { return yearOfRelease; }

    public void setYearOfRelease(int yearOfRelease) { this.yearOfRelease = yearOfRelease;}

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }
}
