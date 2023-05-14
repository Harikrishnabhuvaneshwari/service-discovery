package com.movie.info.controller;

import com.movie.info.model.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/movie")
public class MovieInfoController {

    private static final List<Movie> movies;

    static {
        movies = Arrays.asList(
                new Movie(1, "billa", "english movie"),
                new Movie(2, "sivaji", "tamil movie"),
                new Movie(3, "vikram", "tamil movie"),
                new Movie(4, "master", "korean movie"),
                new Movie(5, "mankatha", "tamil movie"),
                new Movie(6, "okok", "english movie")
        );
    }

    @GetMapping(path = "/movies/{movieId}")
    Movie getMovieInfo(@PathVariable int movieId) {
        return movies.stream().filter(movie -> movie.getMovieId() == movieId).findFirst().get();
    }

}
