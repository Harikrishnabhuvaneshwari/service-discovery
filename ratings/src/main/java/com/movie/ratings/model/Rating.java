package com.movie.ratings.model;

public class Rating {
    int movieId;
    String userId;

    public Rating(int movieId, String userId) {
        this.movieId = movieId;
        this.userId = userId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
