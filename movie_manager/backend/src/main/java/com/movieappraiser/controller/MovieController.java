package com.movieappraiser.controller;

import com.movieappraiser.entity.Movie;
import com.movieappraiser.exception.DuplicateMovieException;
import com.movieappraiser.exception.ResourceNotFoundException;
import com.movieappraiser.exception.NullMovieTitleException;
import com.movieappraiser.repository.MovieRepository;
import com.movieappraiser.service.MovieService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    private MovieRepository movieRepository;

    private MovieService movieService;

    public MovieController(MovieRepository movieRepository, MovieService movieService) {
        this.movieRepository = movieRepository;
        this.movieService = movieService;
    }

    @GetMapping
    @CrossOrigin
    public ResponseEntity<List<Movie>> findAll() {
        return ResponseEntity.ok(movieService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Movie> findById(@PathVariable Long id) {
        var optional = movieRepository.findById(id);
        if(optional.isPresent())
            return ResponseEntity.ok(optional.get());
        else
            throw new ResourceNotFoundException("Movie", id);
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Movie> save(@RequestBody Movie movie) {
        try {
            var savedMovie = movieRepository.saveAndFlush(movie);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedMovie);
        } catch(DataIntegrityViolationException e) {
            if(e.getMessage().contains("movie_title_key"))
                throw new DuplicateMovieException(movie.getTitle());
            else if(e.getMessage().contains("title"))
                throw new NullMovieTitleException();
            throw new RuntimeException();
        }
    }

}
