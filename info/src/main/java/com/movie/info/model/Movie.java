package com.movie.info.model;

public class Movie {

    int movieId;

    String movieName;

    String desc;

    public Movie(int movieId, String movieName, String desc) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.desc = desc;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
