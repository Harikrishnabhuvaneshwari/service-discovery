package com.movie.catalogservice.controller;

import com.movie.catalogservice.model.Movie;
import com.movie.catalogservice.model.Movies;
import com.movie.catalogservice.model.Ratings;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class CatalogServiceController {

    private final WebClient.Builder webClient;

    @GetMapping(path = "/catalog/{userId}")
    Movies movies(@PathVariable String userId) {
        Mono<Ratings> ratingsMono = webClient.build()
                .get()
                .uri("http://ratings/movie/ratings/{userId}", userId)
                .retrieve()
                .bodyToMono(Ratings.class);
        Ratings ratings = ratingsMono.block();

        List<Movie> moviesList = ratings.getRatings().stream().map(rating -> {
            int movieId = rating.getMovieId();
            Mono<Movie> moviesMono = webClient.build()
                    .get()
                    .uri("http://info/movie/movies/{movieId}", movieId)
                    .retrieve()
                    .bodyToMono(Movie.class);
            return moviesMono.block();
        }).collect(Collectors.toList());

        Movies movies = new Movies();
        movies.setMovies(moviesList);
        return movies;
    }

}
