package com.movieappraiser.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NullMovieRatingMovieException extends RuntimeException {

    public NullMovieRatingMovieException() {
        super("Movie rating must have movie.");
    }

}
