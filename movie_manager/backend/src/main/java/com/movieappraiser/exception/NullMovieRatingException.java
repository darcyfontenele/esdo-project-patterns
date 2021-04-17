package com.movieappraiser.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NullMovieRatingException extends RuntimeException {

    public NullMovieRatingException() {
        super("Movie rating must be rated.");
    }

}
