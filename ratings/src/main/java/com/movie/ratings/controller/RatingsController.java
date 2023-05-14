package com.movie.ratings.controller;

import com.movie.ratings.model.Rating;
import com.movie.ratings.model.Ratings;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/movie")
public class RatingsController {

    private static final List<Rating> ratings;

    static {
        ratings = Arrays.asList(
                new Rating(1, "user1"),
                new Rating(3, "user1"),
                new Rating(4, "user1"),
                new Rating(2, "user2"),
                new Rating(1, "user2"),
                new Rating(2, "user1"),
                new Rating(5, "user2"),
                new Rating(6, "user1"),
                new Rating(6, "user2")
        );
    }

    @GetMapping(path = "/ratings/{userId}")
    Ratings getRatings(@PathVariable String userId) {
        List<Rating> ratingList = ratings.stream().filter(rating -> rating.getUserId().equals(userId)).collect(Collectors.toList());
        Ratings response = new Ratings();
        response.setRatings(ratingList);
        return response;
    }
}
