package com.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // anotacion para indicar que se esta trabajando con una base de datos
@Table(name = "movies") // se le indica a spring el nombre de la tabla de la base de datos
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // se indica que el id es autoincrementable
    private long id;
    private String title;
    private int year;
    private int votes;
    private double rating;
    @Column(name = "imag_url")
    private String imagUrl;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getVotes() {
        return votes;
    }
    public void setVotes(int votes) {
        this.votes = votes;
    }
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
    public String getImagUrl() {
        return imagUrl;
    }
    public void setImagUrl(String imagUrl) {
        this.imagUrl = imagUrl;
    }

    

}
