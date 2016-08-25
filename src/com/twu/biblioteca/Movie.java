package com.twu.biblioteca;

/**
 * Created by Suraj on 25-08-2016.
 */
public class Movie {
    private int movie_id;
    private String title;
    private String director;
    private String year;
    private String rating;

    public int getMovie_id() {
        return movie_id;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getYear() {
        return year;
    }

    public String getRating() {
        return rating;
    }

    public Movie(int movie_id, String title, String director, String year, String rating) {

        this.movie_id = movie_id;
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }
}
