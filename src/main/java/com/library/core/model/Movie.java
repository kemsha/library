package com.library.core.model;

public class Movie {

    private int id;

    private String title;

    private String genre;

    private int yearOfRelease;

    private String description;

    public Movie(int id, String title, String genre, int yearOfRelease, String description) {
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
