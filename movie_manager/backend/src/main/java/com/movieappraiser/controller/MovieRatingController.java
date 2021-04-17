package com.movieappraiser.controller;

import com.movieappraiser.entity.MovieRating;
import com.movieappraiser.exception.InvalidMovieRatingMovieException;
import com.movieappraiser.exception.NullMovieRatingException;
import com.movieappraiser.exception.NullMovieRatingMovieException;
import com.movieappraiser.exception.ResourceNotFoundException;
import com.movieappraiser.repository.MovieRatingRepository;
import com.movieappraiser.repository.MovieRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movieRatings")
public class MovieRatingController {

    private MovieRatingRepository movieRatingRepository;

    private MovieRepository movieRepository;

    public MovieRatingController(MovieRatingRepository movieRatingRepository, MovieRepository movieRepository) {
        this.movieRatingRepository = movieRatingRepository;
        this.movieRepository = movieRepository;
    }

    @GetMapping
    public ResponseEntity<List<MovieRating>> findAll() {
        return ResponseEntity.ok(movieRatingRepository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<MovieRating> findById(@PathVariable Long id) {
        var optional = movieRatingRepository.findById(id);
        if(optional.isPresent())
            return ResponseEntity.ok(optional.get());
        else
            throw new ResourceNotFoundException("Movie rating", id);
    }

    @PostMapping
    @CrossOrigin
    public ResponseEntity<MovieRating> save(@RequestBody MovieRating movieRating) {
        try {
            var movie = movieRepository.findById(movieRating.getMovie().getId());
            if(movie.isPresent())
                movieRating.setMovie(movie.get());
            else
                throw new ResourceNotFoundException("Movie", movieRating.getMovie().getId());
            var savedMovieRating = movieRatingRepository.saveAndFlush(movieRating);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedMovieRating);
        } catch(DataIntegrityViolationException e) {
            if(e.getMessage().contains("movie_rating_movie_fk"))
                throw new InvalidMovieRatingMovieException();
            else if(e.getMessage().contains("movie_id"))
                throw new NullMovieRatingMovieException();
            else if(e.getMessage().contains("rating"))
                throw new NullMovieRatingException();
            throw new RuntimeException();
        }
    }

}
