package com.movieappraiser.service;

import com.movieappraiser.entity.Movie;
import com.movieappraiser.repository.MovieRatingRepository;
import com.movieappraiser.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    private MovieRatingRepository movieRatingRepository;

    public MovieService(MovieRepository movieRepository, MovieRatingRepository movieRatingRepository) {
        this.movieRepository = movieRepository;
        this.movieRatingRepository = movieRatingRepository;
    }

    public List<Movie> findAll() {
        var movies = movieRepository.findAll().stream().map(m -> {
            var movieRatings = movieRatingRepository.findMovieRatingByMovieId(m.getId()).stream().map(mr -> mr.getRating()).collect(Collectors.toList());
            m.setAverageRating(movieRatings.stream().mapToDouble(Double::valueOf).sum()/movieRatings.size());
            return m;
        }).collect(Collectors.toList());
        return movies;
    }

}
