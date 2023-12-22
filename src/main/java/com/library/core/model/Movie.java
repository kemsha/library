package com.library.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document
public class Movie {

    @Id
    private String id;

    private String isbn;

    private String title;

    private String genre;

    private int yearOfRelease;

    private String description;


    public Movie(String id, String isbn, String title, String genre, int yearOfRelease, String description){
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.yearOfRelease = yearOfRelease;
        this.description = description;
    }
    public Movie() { }


    public String getID() { return id; }

    public void setId(String id) { this.id = id;}

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title;}

    public String getGenre() { return genre; }

    public void  setGenre(String genre) { this.genre = genre; }

    public int getYearOfRelease() { return yearOfRelease; }

    public void setYearOfRelease(int yearOfRelease) { this.yearOfRelease = yearOfRelease;}

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

}
