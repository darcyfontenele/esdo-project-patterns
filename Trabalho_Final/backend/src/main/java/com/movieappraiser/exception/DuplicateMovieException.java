package com.movieappraiser.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateMovieException extends RuntimeException {

    public DuplicateMovieException(String title) {
        super("Movie with title "+title+" already exist.");
    }

}
