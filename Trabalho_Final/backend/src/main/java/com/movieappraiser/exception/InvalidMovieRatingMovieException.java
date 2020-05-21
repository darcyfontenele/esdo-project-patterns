package com.movieappraiser.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidMovieRatingMovieException extends RuntimeException {

    public InvalidMovieRatingMovieException() {
        super("Movie rating must have valid movie.");
    }

}
